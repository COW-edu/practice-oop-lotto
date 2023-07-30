package lotto.lotto.port.in;

import lotto.lotto.port.in.dto.RequestFinishedLotto;

public interface FinishedLottoUseCase {
    void finish(RequestFinishedLotto request);
}
