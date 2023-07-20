package lotto.controller;

import lotto.Lotto;
import lotto.constants.Prize;
import lotto.model.LotteryCalculator;
import lotto.model.LotteryManager;
import lotto.validation.LotteryNumberValidator;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class LotteryHost {
    private int[] result;
    private Lotto generateLotto() {
        List<Integer> numbers = LotteryManager.generateLottoNumbers();
        List<Integer> newNumbers = new ArrayList<>(numbers);
        return new Lotto(newNumbers);
    }
    public LotteryHost() {
        this.result = new int[5];
    }

    public List<Lotto> generateAndSaveLottoTickets(int numberOfLottery) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfLottery; i++) {
            lottoTickets.add(generateLotto());
        }
        return lottoTickets;
    }

    public void inputWinningNumbers() {
        String winningNumbers = Input.readLine();
        LotteryManager.saveWinningNumbers(winningNumbers);
    }
    public void inputBonusNumber() {
        String bonusNumber = Input.readLine();
        LotteryNumberValidator.validateNumberFormat(bonusNumber);
        LotteryManager.saveBonusNumber(bonusNumber);
    }
    public void compareLottoNumbersAndWinningNumbers(List<Lotto> lottoTickets) {
        this.result = LotteryCalculator.calculateResult(lottoTickets, LotteryManager.winningNumbers, LotteryManager.bonusNumber);
    }
    public double calculateRate(int numberOfLottery) {
        double profit = 0;
        profit += result[0] * Prize.FIFTH_PRIZE.getValue();
        profit += result[1] * Prize.FOURTH_PRIZE.getValue();
        profit += result[2] * Prize.THIRD_PRIZE.getValue();
        profit += result[3] * Prize.SECOND_PRIZE.getValue();
        profit += result[4] * Prize.FIRST_PRIZE.getValue();
        return (Math.round(profit / numberOfLottery * 1000)) / 10000.0;
    }
    public int[] getResult() {
        return this.result;
    }
}
