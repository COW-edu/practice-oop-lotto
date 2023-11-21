package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import lotto.entity.WinLotto;
import lotto.repository.WinningLottoRepository;

public class DefineWinningImpl implements DefineWinningLotto {

    private final WinningLottoRepository winningLottoRepository;

    public DefineWinningImpl(WinningLottoRepository winningLottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
    }

    @Override
    public void inputWinningNumber(String winningNumber) {
        WinLotto winLotto = new WinLotto();
        winningLottoRepository.saveWinnungLotto(winLotto.drawNumber(winningNumber));
    }


    @Override
    public String process(Map<String, Object> model) {
        inputWinningNumber(Console.readLine());

        model.put("winningLottoRepository", winningLottoRepository);
        return "defineWinningNumber";
    }
}

