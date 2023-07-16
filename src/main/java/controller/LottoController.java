package controller;
import message.RequestMessage;
import model.LottosData;
import model.WinData;
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

    public void lottoRun() {
        try {
            storedDataForMethod();
            inputMoney();
            inputWinLottoNumber();
            inputBonusLottoNumber();
            totalWinChecked();
            profitRateCheck();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void storedDataForMethod(){
        lottoWinChecked.storedData(lottosData,winData);
        lottoWinResult.storedData(lottosData,winData);
    }

    private void inputMoney()throws IllegalArgumentException{
        output.outPutMessage(RequestMessage.BUY_INPUT_MONEY);
        lottosData.makeLottoData(input.inputMoney());
        output.outPutBuyLotto(lottosData);
    }

    private void inputWinLottoNumber()throws IllegalArgumentException{
        output.outPutMessage(RequestMessage.INPUT_WIN_NUMBER);
        winData.setWinLotto(input.inputWinNumber());
        lottoWinChecked.checkedWinLottoNumbers();
        winData.setEqualCounts(lottoWinChecked.getEqualCounts());
    }

    private void inputBonusLottoNumber()throws IllegalArgumentException{
        output.outPutMessage(RequestMessage.INPUT_BONUS_NUMBER);
        winData.setBonusNumber(input.inputBonusNumber());
        lottoWinChecked.checkedBonusLottoNumbers();
        winData.setBonusCounts(lottoWinChecked.getBonusCounts());
    }

    private void totalWinChecked(){
        lottoWinResult.totalWinCounted();
        winData.setWinCountResult(lottoWinResult.getWinCountTemp());
    }

    private void profitRateCheck() {
        lottoWinResult.profitRateCalculate();
        winData.setProfitRateSecondPoint(lottoWinResult.getProfitRateSecondPoint());
        output.outPutLottoResult(winData);
    }
}
