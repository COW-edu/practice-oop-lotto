package lotto.repository;

import java.util.List;
import java.util.Map;

public interface ResultRepository {

    void saveResult(List<Integer> resultList);

    void setResult();

    int[] getResultList();

    Map<String, Integer> getResultMap();

    void setRateOfReturn(double rateOfReturn);

    double getRateOfReturn();
}
