package lotto.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.*;
public class LottoBuyer implements Buyer{
    private int purchasingMoney;
    private int purchasedLotto;
    private List<Lotto> lottoes;



    public List<Integer> getRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    @Override
    public void purchaseMoney(int purchasingMoney) {
        this.purchasingMoney = purchasingMoney;
        this.purchasedLotto = purchasingMoney/1000;
    }
    @Override
    public void getLotto(){
        lottoes = new ArrayList<>(purchasedLotto);
        for(int i=0; i<purchasedLotto; i++){
            lottoes.add(new Lotto(getRandomNumber()));
        }
    }

    @Override
    public int getPurchasingMoney() {
        return this.purchasingMoney;
    }

    @Override
    public int getPurchasedLotto() {
        return this.purchasedLotto;
    }

    @Override
    public List<Lotto> showMyLotto() {
        return this.lottoes;
    }




}
