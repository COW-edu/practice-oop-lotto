package lotto;

import lotto.logic.Calculator;
import lotto.logic.CalculatorImpl;
import lotto.logic.LottoMachine;
import lotto.logic.LottoMachineImpl;
import lotto.repository.BudgetRepository;
import lotto.repository.LottoRepository;
import lotto.repository.MemoreyBudgetRepository;
import lotto.repository.MemoryLottoRepository;
import lotto.repository.MemoryResultRepository;
import lotto.repository.MemoryWinningLottoRepository;
import lotto.repository.ResultRepository;
import lotto.repository.WinningLottoRepository;
import lotto.service.BuyLottoService;
import lotto.service.BuyLottoServiceImpl;
import lotto.service.DefineBonusService;
import lotto.service.DefineBonusServiceImpl;
import lotto.service.DefineWinningImpl;
import lotto.service.DefineWinningLotto;
import lotto.service.JudgMentServiceImpl;
import lotto.service.JudgeMentService;
import lotto.service.Judgement;
import lotto.service.JudgementImpl;
import lotto.service.StatisticsService;
import lotto.service.StatisticsServiceImpl;


public class AppConfig {

    private static LottoRepository lottoRepositoryInstance;
    private static WinningLottoRepository winningLottoRepositoryInstance;
    private static ResultRepository resultRepositoryInstance;

    private static BudgetRepository budgetRepository;

    public BuyLottoService buyLottoService() {
        return new BuyLottoServiceImpl(budgetRepository(), lottoMachine(), lottoRepository());
    }

    public static LottoMachine lottoMachine() {
        return new LottoMachineImpl();
    }

    public static synchronized LottoRepository lottoRepository() {
        if (lottoRepositoryInstance == null) {
            lottoRepositoryInstance = new MemoryLottoRepository();
        }
        return lottoRepositoryInstance;
    }

    public static synchronized BudgetRepository budgetRepository() {
        if (budgetRepository == null) {
            budgetRepository = new MemoreyBudgetRepository();
        }
        return budgetRepository;
    }

    public DefineBonusService defineBonusService() {
        return new DefineBonusServiceImpl(winningLottoRepositroy());
    }

    public DefineWinningLotto defineWinningLotto() {
        return new DefineWinningImpl(winningLottoRepositroy());
    }

    public static synchronized WinningLottoRepository winningLottoRepositroy() {
        if (winningLottoRepositoryInstance == null) {
            winningLottoRepositoryInstance = new MemoryWinningLottoRepository();
        }
        return winningLottoRepositoryInstance;
    }

    public JudgeMentService judgeMentService() {
        return new JudgMentServiceImpl(lottoRepository(), winningLottoRepositroy(), resultRepository(), judgement()
        );
    }

    public StatisticsService statisticsService() {
        return new StatisticsServiceImpl(calculator(), budgetRepository(), resultRepository());
    }

    private static Judgement judgement() {
        return new JudgementImpl();
    }

    private static Calculator calculator() {
        return new CalculatorImpl();
    }


    private static ResultRepository resultRepository() {
        if (resultRepositoryInstance == null) {
            resultRepositoryInstance = new MemoryResultRepository();
        }
        return resultRepositoryInstance;
    }
}
