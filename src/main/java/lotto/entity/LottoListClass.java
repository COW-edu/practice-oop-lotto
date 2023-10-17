package lotto.entity;

import java.util.ArrayList;

public class LottoListClass {

    private final ArrayList<Lotto> lottoLists;

    public LottoListClass(ArrayList<Lotto> lottos) {
        this.lottoLists = new ArrayList<>(lottos);
    }

    public ArrayList<Lotto> getLottoLists() {
        return lottoLists;
    }


}
