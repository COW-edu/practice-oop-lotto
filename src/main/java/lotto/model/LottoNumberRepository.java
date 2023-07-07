package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberRepository {

    private static final List<List<Integer>> lottoList = new ArrayList<>();

    public void saveLottoList(List<Integer> numbers) {
        lottoList.add(numbers);
    }

    public List<List<Integer>> findLottoList() {
        return lottoList;
    }

}
