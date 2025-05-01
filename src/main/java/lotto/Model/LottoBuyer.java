package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class LottoBuyer implements Buyer {
    private int paidMoney;
    private int purchasedLottoCount;
    private List<Lotto> lottoes;

    public void pay(int paidMoney) {
        this.paidMoney = paidMoney;
        this.purchasedLottoCount = paidMoney/1000;
    }

    @Override
    public void receiveLotto() {
        lottoes = new ArrayList<>(purchasedLottoCount);
        for(int i = 0; i< purchasedLottoCount; i++){
            lottoes.add(new Lotto(getRandomNumber()));
        }
    }

    @Override
    public int getPaidMoney() {
        return this.paidMoney;
    }

    @Override
    public int getPurchasedLottoCount() {
        return this.purchasedLottoCount;
    }

    @Override
    public List<Lotto> getMyLotto() {
        return this.lottoes;
    }

    private List<Integer> getRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
