package model;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos implements MModel<List<Lotto>>{
    private final List<Lotto> lottos;

    public PurchasedLottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    @Override
    public List<Lotto> getData() {
        return new ArrayList<>(lottos);
    }
}
