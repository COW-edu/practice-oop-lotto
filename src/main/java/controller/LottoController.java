package controller;

import global.enums.ErrorMessage;
import model.*;
import view.Input;
import view.Output;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {
    private final Input inputView;
    private final Output outputView;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public LottoController(Input inputView, Output outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = handlePurchaseAmount();
        int numberOfLotto = purchaseAmount.calculateNumberOfLotto();
        outputView.printPurchaseCount(numberOfLotto);

        List<Lotto> lottoNumbers = LottoGenerator.generateMultiple(numberOfLotto);
        outputView.printLottoNumbers(lottoNumbers);

        winningLotto = getWinningNumbers();
        bonusNumber = handleBonusNumber();

        Map<WinningRank, Integer> result = calculateWinningResult(lottoNumbers);
        outputView.printWinningResult(result);

        float profitRate = calculateProfitRate(result, purchaseAmount.getAmount());
        outputView.printProfitRate(profitRate);
    }

    private PurchaseAmount handlePurchaseAmount() {
        while (true) {
            try {
                int amount = inputView.getPurchaseAmount();
                return new PurchaseAmount(amount);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getMessage() + ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getMessage() + e.getMessage());
            }
        }
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
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getMessage() + ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getMessage() + e.getMessage());
            }
        }
    }

    private BonusNumber handleBonusNumber() {
        while (true) {
            try {
                int bonusNumber = inputView.getBonusNumber();
                return new BonusNumber(bonusNumber, winningLotto);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getMessage() + ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getMessage() + e.getMessage());
            }
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
            boolean bonusMatch = lottoNums.contains(bonusNumber.getNumber());

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
