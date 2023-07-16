package controller;

import model.LottoModel;
import view.LottoView;

import java.util.Scanner;

public class LottoController {
    private LottoModel lottoModel;
    private LottoView lottoView;
    private Scanner scanner;
    private Result result;
    private Bonus bonus;
    private Winner winner;
    private Amount amount;

    public LottoController(LottoModel lottoModel, LottoView lottoView) {
        this.lottoModel = lottoModel;
        this.lottoView = lottoView;
        scanner = new Scanner(System.in);
        result = new Result();
        bonus = new Bonus();
        winner = new Winner();
        amount = new Amount();
    }

    public void run() {
        int[] winnerNumbers = winner.readWinnerNumbers();
        int bonusNumber = bonus.readBonusNumber();
        int amountValue = amount.readAmount();

        lottoModel.setWinnerNumbers(winnerNumbers);
        lottoModel.setBonus(bonusNumber);
        lottoModel.setAmount(amountValue);

        int count = amountValue / 1000;

        for (int i = 0; i < count; i++) {
            int[] lottoNumbers = lottoModel.generateLottoNumbers();
            lottoView.displayLottoNumber(lottoNumbers, i + 1);

            int matchCount = lottoModel.countMatchingNumbers(winnerNumbers, lottoNumbers);
            boolean hasBonus = contains(lottoNumbers, bonusNumber);

            String prize = result.calculatePrize(matchCount, hasBonus);
            lottoView.displayPrize(prize);
        }

        scanner.close();
    }

    private boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}