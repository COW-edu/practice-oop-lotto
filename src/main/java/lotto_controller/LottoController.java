package lotto_controller;

import lotto_model.Lotto;
import lotto_model.LottoService;
import lotto_view.LottoInput;
import lotto_view.LottoOutput;

public class LottoController {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    private final LottoService lottoService;

    public LottoController(LottoInput lottoInput, LottoOutput lottoOutput, LottoService lottoService) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
        this.lottoService = lottoService;
    }

    public void run() {
        int inputMoney = lottoInput.getInputMoney();
        lottoService.printLotto(inputMoney);
        Lotto targetLotto = lottoInput.inputNumber();
        int bonusNumber = lottoInput.getBonusNum();
        lottoService.lottoCompare(targetLotto, bonusNumber);
        lottoOutput.resultPrint(inputMoney);
    }
}
