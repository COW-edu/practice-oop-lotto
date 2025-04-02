package controller;

import camp.nextstep.edu.missionutils.Randoms;
import global.enums.ErrorMessage;
import global.enums.MagicNumber;
import model.Lotto;
import model.WinningRank;
import view.Input;
import view.Output;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {
    private final Input inputView;
    private final Output outputView;
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoController(Input inputView, Output outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = handlePurchaseAmount();
        int numberOfLotto = calculateNumberOfLotto(purchaseAmount);
        outputView.printPurchaseCount(numberOfLotto);

        List<Lotto> lottoNumbers = generateRandomLotto(numberOfLotto);
        outputView.printLottoNumbers(lottoNumbers);

        winningLotto = getWinningNumbers();
        bonusNumber = handleBonusNumber();

        Map<WinningRank, Integer> result = calculateWinningResult(lottoNumbers);
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
                System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getMessage() + e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
        if (purchaseAmount % MagicNumber.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getMessage());
        }
    }

    private int calculateNumberOfLotto(int purchaseAmount) {
        return purchaseAmount / MagicNumber.LOTTO_PRICE.getValue();
    }

    private List<Lotto> generateRandomLotto(int numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MagicNumber.LOTTO_NUMBER_MIN.getValue(), MagicNumber.LOTTO_NUMBER_MAX.getValue(), MagicNumber.LOTTO_LENGTH.getValue());
            Collections.sort(randomNumbers);
            lottoList.add(new Lotto(randomNumbers));
        }
        return lottoList;
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.getWinningNumber();
                List<Integer> numbers = parseNumbers(input);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getMessage() + e.getMessage());
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
                System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getMessage() + e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MagicNumber.LOTTO_NUMBER_MIN.getValue() || bonusNumber > MagicNumber.LOTTO_NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
        }
        if (winningLotto.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IS_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private Map<WinningRank, Integer> calculateWinningResult(List<Lotto> lottoNumbers) {
        Map<WinningRank, Integer> result = new LinkedHashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            result.put(rank, 0);
        }

        for (Lotto lotto : lottoNumbers) {
            List<Integer> lottoNums = lotto.getLottoNumbers();
            int matchCount = (int) lottoNums.stream().filter(winningLotto.getLottoNumbers()::contains).count();
            boolean bonusMatch = lottoNums.contains(bonusNumber);

            WinningRank rank = WinningRank.of(matchCount, bonusMatch);
            if (rank != null) {
                result.put(rank, result.get(rank) + 1);
            }
        }

        return result;
    }

    private float calculateProfitRate(Map<WinningRank, Integer> winningResult, int purchaseAmount) {
        int totalPrize = winningResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        float profitRate = (float) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0f;
    }
}
