package lotto.service;

import java.util.Map;
import lotto.control.Input;
import lotto.repository.WinningLottoRepository;

public class DefineBonusServiceImpl implements DefineBonusService {

    private final WinningLottoRepository winningLottoRepository;

    public DefineBonusServiceImpl(WinningLottoRepository winningLottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
    }

    @Override
    public String process(Map<String, Object> model) {
        inputBonusNumber(Input.inputInt());
        model.put("winningLottoRepository", winningLottoRepository);
        return "defineBonusNumber";
    }

    private void inputBonusNumber(int bonusNumber) {
        winningLottoRepository.saveBonusNumber(bonusNumber);
    }

}
