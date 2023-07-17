package lotto;

import lotto.model.LotteryCalculator;
import lotto.view.Input;

import java.util.List;

public class User {
    private Lotto lotto;
    private List<Lotto> lottoTickets;
    private int numberOfLottery;
    public void buyLotto() {
        // 구입 금액 입력
        String amount = Input.readLine();
        // 로또 매수 저장
        this.numberOfLottery = LotteryCalculator.divideByLottoPrice(amount);
    }
    public void saveLotto(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
    public int getNumberOfLottery() {
        return numberOfLottery;
    }
}
