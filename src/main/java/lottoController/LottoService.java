package lottoController;

import lottoModel.Lotto;
import lottoModel.Comparator;
import lottoView.LottoInput;
import lottoView.LottoOutput;


public class LottoService {
    private final LottoInput lottoInput = new LottoInput();
    private final LottoOutput lottoOutput = new LottoOutput();
    private final Comparator comparator = new Comparator();

    public void run() {
        int inputMoney = lottoInput.getInputMoney();
        lottoOutput.generateLottoNum(inputMoney);

        Lotto userLotto = lottoInput.inputNumber();
        int bonusNum = lottoInput.getBonusNum();
        comparator.lottoComparison(userLotto, bonusNum);
        lottoOutput.print(inputMoney);


    }


}
