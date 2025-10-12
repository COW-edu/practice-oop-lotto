package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto_purchaser {

    private final int costOfPurchasing;
    private List<Lotto> lottos;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;


    public Lotto_purchaser(int costOfPurchasing) {
        this.costOfPurchasing = costOfPurchasing;
    }

    // 구매 금액에 따른 로또 티켓 수 반환
    public int costToTicketNUM() {
        return costOfPurchasing / 1000;
    }


    public List<List<Integer>> randomPick() {
        List<Lotto> lottos = new ArrayList<>();
        int ticketCount = costToTicketNUM();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
            lottos.add(new Lotto(numbers));
        }
        this.lottos = lottos;
        List<List<Integer>> lottoList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoList.add(lotto.getNumbers());
        }
        return lottoList;
    }





}
