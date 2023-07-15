package controller;
import message.RequestMessage;
import model.Lotto;
import model.LottosData;
import model.WinData;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import view.input.Input;
import view.output.Output;

public class LottoController {
    private final Output output;
    private final Input input;
    private final LottosData lottosData;
    private final WinData winData;
    private final LottoWinChecked lottoWinChecked;
    private final LottoWinResult lottoWinResult;

    public LottoController(Output output, Input input, LottosData lottosData, WinData winData, LottoWinChecked lottoWinChecked, LottoWinResult lottoWinResult) {
        this.output = output;
        this.input=input;
        this.lottosData = lottosData;
        this.winData = winData;
        this.lottoWinChecked = lottoWinChecked;
        this.lottoWinResult=lottoWinResult;
    }

    public void lottoRun(){
        inputMoney();
        inputWinLottoNumber();
        inputBonusLottoNumber();
        totalWinChecked();
        profitRateCheck();
    }

    private void inputMoney(){
        output.outPutMessage(RequestMessage.BUY_INPUT_MONEY);
        lottosData.makeLottoData(input.inputMoney());
        output.outPutBuyLotto(lottosData);
    }

    private void inputWinLottoNumber() {
        output.outPutMessage(RequestMessage.INPUT_WIN_NUMBER);
        winData.setWinLotto(input.inputWinNumber());
        lottoWinChecked.checkedWinLottoNumbers();
        winData.setEqualCounts(lottoWinChecked.getEqualCounts());
    }

    private void inputBonusLottoNumber() {
        output.outPutMessage(RequestMessage.INPUT_BONUS_NUMBER);
        winData.setBonusNumber(input.inputBonusNumber());
        lottoWinChecked.checkedBonusLottoNumbers();
        winData.setBonusCounts(lottoWinChecked.getBonusCounts());
    }

    private void totalWinChecked(){
        lottoWinResult.totalWinCounted(winData);
        winData.setWinCountResult(lottoWinResult.getWinCountTemp());
    }

    private void profitRateCheck() {
        lottoWinResult.profitRateCalculate();
        winData.setProfitRateSecondPoint(lottoWinResult.getProfitRateSecondPoint());
        output.outPutLottoResult(winData);
    }
}
