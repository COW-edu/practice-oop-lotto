package lotto.repository;

import static lotto.constant.LottoRule.LOTTO_DISTINCTION_RANGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MemoryResultRepository implements ResultRepository {

    private List<Integer> resultCountlist;
    private final int[] resultList;

    private Map<String, Integer> resultMap;

    public double rateOfReturn;

    public MemoryResultRepository() {
        this.resultList = new int[LOTTO_DISTINCTION_RANGE];
    }

    @Override
    public void saveResult(List<Integer> resultList) {
        resultCountlist = new ArrayList<>(resultList);
        setResult();
    }

    @Override
    public void setResult() {
        resultCountlist.forEach(count -> resultList[count] += 1);
        setTotalResultMap();
    }

    @Override
    public int[] getResultList() {
        return resultList;
    }

    public void setTotalResultMap() {
        String[] matchingCount = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "FIVE_BONUS"};
        resultMap = IntStream
            .range(0, matchingCount.length)
            .boxed()
            .collect(Collectors.toMap(i -> matchingCount[i], i -> resultList[i + 1]));
    }

    @Override
    public Map<String, Integer> getResultMap() {
        return this.resultMap;
    }

  
    public void setRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    @Override
    public double getRateOfReturn() {
        return rateOfReturn;
    }

}
