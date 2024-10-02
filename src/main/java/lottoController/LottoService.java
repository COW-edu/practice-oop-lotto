package lottoController;

import lottoModel.Lotto;
import lottoModel.LottoComparison;
import lottoModel.LottoMaker;
import lottoView.LottoViewer;

//로또 생성 및 계산
public class LottoService {
    static LottoMaker lottoMaker = new LottoMaker();
    private final LottoViewer lottoViewer = new LottoViewer();
    private final LottoComparison lottoComparison = new LottoComparison();

    public void run() {
        int inputMoney = lottoViewer.getInputMoney();
        generateLottoNum(inputMoney);

        Lotto userLotto = lottoViewer.inputNumber();
        int bonusNum = lottoViewer.getBonusNum();

        lottoComparison.lottoComparison(userLotto, bonusNum);

        lottoViewer.print(inputMoney);
    }

    private void generateLottoNum(int inputMoney) {

        int amount = inputMoney / 1000;
        System.out.println(amount + "개를 구매했습니다.");
        lottoMaker.generate(amount);
    }

}
