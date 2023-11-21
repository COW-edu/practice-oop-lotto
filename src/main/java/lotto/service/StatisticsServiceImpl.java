package lotto.service;

import java.util.Map;
import lotto.logic.Calculator;
import lotto.repository.BudgetRepository;
import lotto.repository.ResultRepository;

public class StatisticsServiceImpl implements StatisticsService {

    private final Calculator calculator;
    private final BudgetRepository budgetRepository;
    private final ResultRepository resultRepository;

    public StatisticsServiceImpl(Calculator calculator, BudgetRepository budgetRepository,
        ResultRepository resultRepository) {
        this.calculator = calculator;
        this.budgetRepository = budgetRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public String process(Map<String, Object> model) {
        resultRepository.setRateOfReturn(
            calculator.calculatePrize(resultRepository.getResultMap(), budgetRepository.getBudget()));
        model.put("resultList", resultRepository.getResultList());
        model.put("rateOfReturn", resultRepository.getRateOfReturn());

        return "statistics";
    }
}
