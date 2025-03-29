package controller;

import camp.nextstep.edu.missionutils.Randoms;
import global.enums.ErrorMessage;
import model.Lotto;
import view.InputView;
import view.OutputView;

import java.util.*;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = handlePurchaseAmount(); // 입력 및 검증
        int numberOfLottos = purchaseAmount / 1000;
        outputView.printPurchaseCount(numberOfLottos);

        List<Lotto> lottoNumbers = generateRandomLottos(numberOfLottos);
        outputView.printLottoNumbers(lottoNumbers);

        winningLotto = getWinningNumbers();
        bonusNumber = handleBonusNumber();

        Map<String, Integer> result = calculateWinningResult(lottoNumbers);
        outputView.printWinningResult(result);

        float profitRate = calculateProfitRate(result, purchaseAmount);
        outputView.printProfitRate(profitRate);
    }

    private int handlePurchaseAmount() {
        while (true) {
            try {
                int amount = inputView.getPurchaseAmount();
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getMessage());
        }
    }

    private List<Lotto> generateRandomLottos(int numberOfLottos) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottoList.add(new Lotto(randomNumbers));
        }
        return lottoList;
    }

    private List<Integer> parseNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }

        return numbers;
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.getWinningNumber();
                List<Integer> numbers = parseNumbers(input);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private int handleBonusNumber() {
        while (true) {
            try {
                int bonusNumber = inputView.getBonusNumber();
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
        }
        if (winningLotto.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IS_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private Map<String, Integer> calculateWinningResult(List<Lotto> lottoNumbers) {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("3개 일치 (5,000원)", 0);
        result.put("4개 일치 (50,000원)", 0);
        result.put("5개 일치 (1,500,000원)", 0);
        result.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        result.put("6개 일치 (2,000,000,000원)", 0);

        for (Lotto lotto : lottoNumbers) {
            List<Integer> lottoNums = lotto.getLottoNumbers();
            int matchCount = (int) lottoNums.stream().filter(winningLotto.getLottoNumbers()::contains).count();
            boolean bonusMatch = lottoNums.contains(bonusNumber);

            if (matchCount == 3) {
                result.put("3개 일치 (5,000원)", result.get("3개 일치 (5,000원)") + 1);
            } else if (matchCount == 4) {
                result.put("4개 일치 (50,000원)", result.get("4개 일치 (50,000원)") + 1);
            } else if (matchCount == 5 && !bonusMatch) {
                result.put("5개 일치 (1,500,000원)", result.get("5개 일치 (1,500,000원)") + 1);
            } else if (matchCount == 5 && bonusMatch) {
                result.put("5개 일치, 보너스 볼 일치 (30,000,000원)", result.get("5개 일치, 보너스 볼 일치 (30,000,000원)") + 1);
            } else if (matchCount == 6) {
                result.put("6개 일치 (2,000,000,000원)", result.get("6개 일치 (2,000,000,000원)") + 1);
            }
        }

        return result;
    }

    private float calculateProfitRate(Map<String, Integer> winningResult, int purchaseAmount) {
        int totalPrize = 0;

        Map<String, Integer> prizeMap = Map.of(
                "3개 일치 (5,000원)", 5000,
                "4개 일치 (50,000원)", 50000,
                "5개 일치 (1,500,000원)", 1500000,
                "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000,
                "6개 일치 (2,000,000,000원)", 2000000000
        );

        for (Map.Entry<String, Integer> entry : winningResult.entrySet()) {
            totalPrize += prizeMap.get(entry.getKey()) * entry.getValue();
        }

        float profitRate = (float) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0f;
    }
}