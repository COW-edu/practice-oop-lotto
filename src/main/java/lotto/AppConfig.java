package lotto;

import lotto.constant.TotalResultMap;
import lotto.entity.User;
import lotto.logic.Calculator;
import lotto.logic.LottoMachine;
import lotto.repository.LottoRepository;
import lotto.repository.MemoryLottoRepository;
import lotto.repository.MemoryResultRepository;
import lotto.repository.MemoryWinningLottoRepository;
import lotto.repository.ResultRepository;
import lotto.repository.WinningLottoRepository;
import lotto.service.BuyLottoService;
import lotto.service.BuyLottoServiceImpl;
import lotto.service.DefineWinningImpl;
import lotto.service.DefineWinningLotto;
import lotto.service.JudgMentServiceImpl;
import lotto.service.JudgeMentService;


public class AppConfig {

    private static LottoRepository lottoRepositoryInstance;
    private static WinningLottoRepository winningLottoRepositoryInstance;
    private static ResultRepository resultRepositoryInstance;

    private static User user;

    public BuyLottoService buyLottoService() {
        return new BuyLottoServiceImpl(user(), lottoMachine(), lottoRepository());
        //getRepositroy가 중복되는 게 불편
    }

    public static LottoMachine lottoMachine() {
        return new LottoMachine(lottoRepository());
    }

    public static synchronized LottoRepository lottoRepository() {
        if (lottoRepositoryInstance == null) {
            lottoRepositoryInstance = new MemoryLottoRepository();
        }
        return lottoRepositoryInstance;
    }

    public static User user() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public DefineWinningLotto defineWinningLotto() {
        return new DefineWinningImpl(winningLottoRepositroy());
    }

    public WinningLottoRepository winningLottoRepositroy() {
        if (winningLottoRepositoryInstance == null) {
            winningLottoRepositoryInstance = new MemoryWinningLottoRepository();
        }
        return winningLottoRepositoryInstance;
    }

    public JudgeMentService judgeMentService() {
        return new JudgMentServiceImpl(lottoRepository(), winningLottoRepositroy(), ResultRepository(),
            TotalResultMap(), Calculator(), user()
        );
    }

    private static Calculator Calculator() {
        return new Calculator();
    }

    private static TotalResultMap TotalResultMap() {
        return new TotalResultMap();
    }

    private static ResultRepository ResultRepository() {
        if (resultRepositoryInstance == null) {
            resultRepositoryInstance = new MemoryResultRepository();
        }
        return resultRepositoryInstance;
    }
}
