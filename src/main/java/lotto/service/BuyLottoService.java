package lotto.service;

import java.util.Map;

public interface BuyLottoService extends Service {

    void inputBudget();
    
    String process(Map<String, Object> model);
}

