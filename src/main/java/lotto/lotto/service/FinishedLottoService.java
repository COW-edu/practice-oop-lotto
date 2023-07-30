package lotto.lotto.service;

import lombok.RequiredArgsConstructor;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoMatcher;
import lotto.lotto.domain.LottoNumber;
import lotto.lotto.port.in.FinishedLottoUseCase;
import lotto.lotto.port.in.dto.RequestFinishedLotto;
import lotto.lotto.port.out.LottoRepository;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FinishedLottoService implements FinishedLottoUseCase {

    private final LottoRepository lottoRepository;

    @Override
    public void finish(RequestFinishedLotto request) {
        // 결과 저장
        var resultNumbers = request.getWinningNumbers().stream().map(LottoNumber::valueOf).collect(Collectors.toSet());
        var resultBonusNumbers = LottoNumber.valueOf(request.getBonusNumber());
        LottoMatcher.setResult(resultNumbers, resultBonusNumbers);

        // 로또 보상 생성
        var allLotto = lottoRepository.findAll();
        for (Lotto lotto : allLotto) {
            LottoMatcher.match(lotto);
        }

        // 데이터 저장
        lottoRepository.saveAll(allLotto);
    }
}
