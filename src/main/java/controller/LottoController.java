package controller;
import message.RequestMessage;
import model.lotto.LottoStore;
import model.lotto.PayLottosData;
import model.win.WinData;
import model.win.WinLottoResult;
import profitcalculator.profitCalculator;
import view.input.Input;
import view.output.Output;

public class LottoController {
    private final Output output;
    private final Input input;
    private final LottoStore lottoStore;
    private final LottoWinChecked lottoWinChecked;
    private final profitCalculator lottoWinResult;

    public LottoController(Output output, Input input, LottoStore lottoStore, LottoWinChecked lottoWinChecked, profitCalculator lottoWinResult) {
        this.output = output;
        this.input=input;
        this.lottoStore=lottoStore;
        this.lottoWinChecked = lottoWinChecked;
        this.lottoWinResult=lottoWinResult;
    }

    public void lottoRun() {
        try {
            PayLottosData payLottosData= lottoStore.makePayLottosData();
            WinData winData= lottoStore.makeWinData();
            storedDataForMethod();
           int payMoney = inputMoney(payLottosData);
           int[] equalCounts = inputWinLottoNumber();
           boolean[] bonusCounts= inputBonusLottoNumber();
            WinLottoResult winLottoResult = totalWinChecked(equalCounts,bonusCounts);
            profitRateCheck(winLottoResult,payMoney);
        }catch (IllegalArgumentException e){
            output.outPutMessage(e.getMessage());
        }
    }
    public void storedDataForMethod(){
        lottoWinChecked.storedData(payLottosData,winData);
        lottoWinResult.storedData(payLottosData,winData);
    }

    private int inputMoney(PayLottosData payLottosData)throws IllegalArgumentException{
        output.outPutMessage(RequestMessage.BUY_INPUT_MONEY);
        int payMoney = input.inputMoney();
        payLottosData.makeLottoData(payMoney);
        output.outPutBuyLotto(payLottosData);
        return payMoney;
    }

    private int[] inputWinLottoNumber()throws IllegalArgumentException{
        output.outPutMessage(RequestMessage.INPUT_WIN_NUMBER);
        winData.setWinLotto(input.inputWinNumber());
        lottoWinChecked.checkedWinLottoNumbers();
        return lottoWinChecked.getEqualCounts();
    }

    private boolean[] inputBonusLottoNumber()throws IllegalArgumentException{
        output.outPutMessage(RequestMessage.INPUT_BONUS_NUMBER);
        winData.setBonusNumber(input.inputBonusNumber());
        lottoWinChecked.checkedBonusLottoNumbers();
        return lottoWinChecked.getBonusCounts();
    }

    private WinLottoResult totalWinChecked(int[] equalCounts, boolean[] bonusCounts){
        return lottoStore.makeWinLottoResult(equalCounts,bonusCounts);
    }

    private void profitRateCheck(WinLottoResult winLottoResult, int payMoney) {
       double profitRate = lottoWinResult.profitRateCalculate(winLottoResult,payMoney);
        output.outPutLottoResult(profitRate,winLottoResult);
    }
}
