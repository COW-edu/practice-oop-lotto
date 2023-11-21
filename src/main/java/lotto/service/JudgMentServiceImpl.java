package lotto.service;

import java.util.Map;
import lotto.repository.LottoRepository;
import lotto.repository.ResultRepository;
import lotto.repository.WinningLottoRepository;

public class JudgMentServiceImpl implements JudgeMentService {

    private final LottoRepository lottoRepository;
    private final WinningLottoRepository winningLottoRepository;

    private final ResultRepository resultRepository;
    
    private final Judgement judgement;


    public JudgMentServiceImpl(LottoRepository lottoRepository, WinningLottoRepository winningLottoRepository,
        ResultRepository resultRepository, Judgement judgement) {
        this.lottoRepository = lottoRepository;
        this.winningLottoRepository = winningLottoRepository;
        this.resultRepository = resultRepository;
        this.judgement = judgement;
    }


    @Override
    public String process(Map<String, Object> model) {
        resultRepository.saveResult(judgement.resultJudge(lottoRepository.getLottoList(), winningLottoRepository.getWinLotto(),
            winningLottoRepository.getBonusNumber()));

        return null;
    }
}
