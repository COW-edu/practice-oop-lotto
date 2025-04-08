package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class MoneyStatics {
    private final int STATICS_COUNT = 5;
    private List<Integer> countStatics = new ArrayList<>(5);
    public MoneyStatics(){
        for(int i=0; i<STATICS_COUNT; i++) {
            countStatics.add(0);
        }
    }

    public List<Integer> getCountStatics() {
        return countStatics;
    }
}
