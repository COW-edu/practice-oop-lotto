package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class MoneyStatics {
    private List<Integer> countStatics = new ArrayList<>(5);
    public MoneyStatics(){
        for(int i=0; i<5; i++){
            countStatics.add(0);
        }
    }

    public List<Integer> getCountStatics() {
        return countStatics;
    }
}
