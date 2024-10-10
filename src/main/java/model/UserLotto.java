package model;

import java.util.List;

public interface UserLotto {
    public List<Integer> createLotto();
    public List<List<Integer>> createLottosList(int count);
}
