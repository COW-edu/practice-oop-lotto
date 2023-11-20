package lotto.service;

import static lotto.constant.LottoRule.LOTTO_ROW_SIZE;

import java.util.Map;
import java.util.stream.IntStream;
import lotto.constant.TotalResultMap;
import lotto.control.Output;
import lotto.entity.Lotto;
import lotto.entity.User;
import lotto.entity.WinLottoListClass;
import lotto.logic.Calculator;
import lotto.repository.LottoRepository;
import lotto.repository.ResultRepository;
import lotto.repository.WinningLottoRepository;

public class JudgMentServiceImpl implements JudgeMentService {

    private LottoRepository lottoRepository;
    private WinningLottoRepository winningLottoRepository;

    private ResultRepository resultRepository;

    private final TotalResultMap totalResultMap;

    private Calculator calculator;

    private final User user;


    public JudgMentServiceImpl(LottoRepository lottoRepository, WinningLottoRepository winningLottoRepository,
        ResultRepository resultRepository, TotalResultMap totalResultMap, Calculator calculator, User user) {
        this.lottoRepository = lottoRepository;
        this.winningLottoRepository = winningLottoRepository;
        this.resultRepository = resultRepository;
        this.totalResultMap = totalResultMap;
        this.calculator = calculator;
        this.user = user;
    }

    @Override
    public void process() {
        resultJudge();
        resultRepository.setResult();
        resultRepository.setRateOfReturn(calculator.calculate(resultRepository.getResultMap(), user.getBudget()));
        //여기다가 resultRepository.get으로 결과값을 줄까 아니면, totalResultMap이 직접 접근을 할까.
        Output.printResult(resultRepository);
        Output.printRateOfReturn(resultRepository);
    }

    public void resultJudge() {
        lottoRepository.getLottoList().forEach(lotto -> {
            resultRepository.saveResult(rowCompare(lotto));
        });
    }

    public Integer rowCompare(Lotto lotto) {
        int count = IntStream.range(0, LOTTO_ROW_SIZE)
            .map(i -> countCheck(lotto, i))
            .sum();
        return count + (count == 5 ? bonusCheck(lotto) : 0);
    }


    public int countCheck(Lotto lotto, int i) {
        WinLottoListClass winLottoListClass = null;
        if (lotto.getNumbers()
            .contains(winningLottoRepository.getWinLotto().get(i))) {
            return 1;
        }
        return 0;
    }

    public int bonusCheck(Lotto lotto) {
        if (lotto.getNumbers()
            .contains((winningLottoRepository.getBonusNumber()))) {
            return 2;
        }
        return 0;
    }


    @Override
    public String process(Map<String, Object> model) {
        return null;
    }
}
