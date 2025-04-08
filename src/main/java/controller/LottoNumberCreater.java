package controller;

import camp.nextstep.edu.missionutils.Randoms;
import view.OutputView;
import java.util.*;
import java.util.Collections;


public class LottoNumberCreater {
    private final OutputView outputView;

    public LottoNumberCreater(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<List<Integer>> generate(int count) {
        List<List<Integer>> result = new ArrayList<>();
        outputView.printPurchasedCount(count);
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            result.add(numbers);
            outputView.printLotto(numbers);
        }
        return new ArrayList<>(result);
    }
}