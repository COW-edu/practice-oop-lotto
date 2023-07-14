package lotto;

import controller.LottoController;

public class LottoProgram {
    public void lottoStart(){
        LottoAppConfig lottoAppConfig = new LottoAppConfig();
        LottoController lottoController = lottoAppConfig.LottoController();
        lottoController.lottoRun();

    }
}
