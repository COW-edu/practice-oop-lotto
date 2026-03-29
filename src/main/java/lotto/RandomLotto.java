package lotto;

import java.util.*;

public class RandomLotto {
    public List<Integer> generate() {

        Random rand = new Random();
        List<Integer> lotto = new ArrayList<>();

        while (lotto.size() < 6) {
            int num = rand.nextInt(45) + 1;

            if (!lotto.contains(num)) {
                lotto.add(num);
            }
        }

        Collections.sort(lotto);
        return lotto;
    }
}
