package lotto.controller;

import lotto.Lotto;
import lotto.User;
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
    public static void printLottoNumbers(Lotto lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            System.out.print(lotto.getNumbers().get(i));
            if (i < lotto.getNumbers().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public void printLottoNumbersAndQuantity(List<Lotto> lottoTickets, int numberOfLottery) {
        Output.print(numberOfLottery + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            printLottoNumbers(lotto);
        }
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
    public void printResult(int numberOfLottery) {
        Output.print("3개 일치 (5,000원) - " + result[0] + "개\n" +
                "4개 일치 (50,000원) - " + result[1] + "개\n" +
                "5개 일치 (1,500,000원) - " + result[2] + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[3] + "개\n" +
                "6개 일치 (2,000,000,000원) - " + result[4] + "개\n" +
                "총 수익률은 " + calculateRate(numberOfLottery) + "%입니다.");
    }
}
