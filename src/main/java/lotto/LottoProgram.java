package lotto;

import CLotto.LottoInfoInput;

public class LottoProgram {
    public void lottoStart(){
        LottoInfoInput lottoinfoinput = new LottoInfoInput();
        lottoinfoinput.inputMoney();
        lottoinfoinput.inputWinLottoNum();
        lottoinfoinput.inputBonusLottoNum();
        lottoinfoinput.totalWinChecked();
        lottoinfoinput.profitRateCheck();
    }
}
