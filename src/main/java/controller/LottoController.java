package controller;

import camp.nextstep.edu.missionutils.Randoms;
import global.enums.ErrorMessage;
import model.LottoNumber;
import model.WinningNumber;
import view.InputView;
import view.OutputView;

import java.util.*;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private WinningNumber winningNumber;
    private int bonusNumber;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = handlePurchaseAmount(); // 입력 및 검증
        int numberOfLottos = calculateNumberOfLottos(purchaseAmount);
        outputView.printPurchaseCount(numberOfLottos);

        List<LottoNumber> lottoNumbers = generateRandomLottos(numberOfLottos);
        outputView.printLottoNumbers(lottoNumbers);

        getValidatedWinningNumbers();
        bonusNumber=handleBonusNumber();

        Map<String, Integer> result = calculateWinningResult(lottoNumbers);
        outputView.printWinningResult(result);
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
        try {
            if (purchaseAmount <= 0) {
                throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
            }
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }

    private int calculateNumberOfLottos(int purchaseAmount) {
        return purchaseAmount/1000;
    }

    private List<LottoNumber> generateRandomLottos(int numberOfLottos) {
        List<LottoNumber> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottoList.add(new LottoNumber(randomNumbers));
        }
        return lottoList;
    }

    private void getValidatedWinningNumbers() {
        while (true) {
            try {
                String input = inputView.getWinningNumber();
                saveWinningNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void saveWinningNumber(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        try {
            for (String numberString : numberStrings) {
                int number = Integer.parseInt(numberString.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
                }
                if(!uniqueNumbers.add(number)) {
                    throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_DUPLICATE.getMessage());
                }
                numbers.add(number);
            }
            if (numbers.size() != 6) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_LENGTH.getMessage());
            }
            this.winningNumber = new WinningNumber(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_NOT_NUMBER.getMessage());
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
        try {
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
            }
            if(winningNumber.getWinningNumbers().contains(bonusNumber)) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IS_DUPLICATE_WINNING_NUMBER.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IS_NOT_NUMBER.getMessage());
        }
    }

    private Map<String, Integer> calculateWinningResult(List<LottoNumber> lottoNumbers) {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("3개 일치 (5,000원)", 0);
        result.put("4개 일치 (50,000원)", 0);
        result.put("5개 일치 (1,500,000원)", 0);
        result.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        result.put("6개 일치 (2,000,000,000원)", 0);

        for (LottoNumber lotto : lottoNumbers) {
            List<Integer> lottoNums = lotto.getNumbers();
            int matchCount = (int) lottoNums.stream().filter(winningNumber.getWinningNumbers()::contains).count();
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
}
