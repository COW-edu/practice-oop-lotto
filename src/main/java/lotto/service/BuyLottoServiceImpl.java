package lotto.service;

import java.util.Map;
import lotto.control.Input;
import lotto.logic.LottoMachine;
import lotto.repository.BudgetRepository;
import lotto.repository.LottoRepository;

public class BuyLottoServiceImpl implements BuyLottoService {

    private final BudgetRepository budgetRepository;

    private final LottoRepository lottoRepository;
    private final LottoMachine lottoMachine;


    public BuyLottoServiceImpl(BudgetRepository BudgetRepository, LottoMachine lottoMachine,
        LottoRepository lottoRepository) {
        this.budgetRepository = BudgetRepository;
        this.lottoRepository = lottoRepository;
        this.lottoMachine = lottoMachine;
    }

    @Override
    public void inputBudget() {

        budgetRepository.setBudget(Input.inputInt());
    }

    @Override
    public String process(Map<String, Object> model) {
        inputBudget();

        lottoRepository.saveLotto(lottoMachine.playLotto(budgetRepository.getLottoCount()));
        model.put("lottoCount", budgetRepository.getLottoCount());
        model.put("lottoList", lottoRepository.getLottoList());

        return "buy";

    }

}


