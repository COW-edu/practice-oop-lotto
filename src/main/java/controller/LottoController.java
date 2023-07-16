package controller;
import machine.CheckedEqual;
import message.RequestMessage;
import model.lotto.LottoStore;
import model.lotto.PayLottosData;
import model.win.WinLottoResult;
import machine.ProfitCalculator;
import view.input.Input;
import view.output.Output;

public class LottoController {
    private final Output output;
    private final Input input;
    private final LottoStore lottoStore;
    private final CheckedEqual lottoWinChecked;
    private final ProfitCalculator lottoWinResult;

    public LottoController(Output output, Input input, LottoStore lottoStore, CheckedEqual lottoWinChecked, ProfitCalculator lottoWinResult) {
        this.output = output;
        this.input=input;
        this.lottoStore=lottoStore;
        this.lottoWinChecked = lottoWinChecked;
        this.lottoWinResult=lottoWinResult;
    }

    public void lottoRun() {
        try {
            PayLottosData payLottosData = lottoStore.makePayLottosData();
            storedDataForMethod(payLottosData);
           int payMoney = inputMoney(payLottosData);
           int[] equalCounts = inputWinLottoNumber();
           boolean[] bonusCounts= inputBonusLottoNumber();
           WinLottoResult winLottoResult = makewinLottoResult(equalCounts,bonusCounts);
           profitRateCheck(winLottoResult,payMoney);
        }catch (IllegalArgumentException e){
            output.outPutMessage(e.getMessage());
        }
    }
    public void storedDataForMethod(PayLottosData payLottosData){
        lottoWinChecked.storedData(payLottosData);
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
        return lottoWinChecked.checkedWinLottoNumbers(input.inputWinNumber());
    }

    private boolean[] inputBonusLottoNumber()throws IllegalArgumentException{
        output.outPutMessage(RequestMessage.INPUT_BONUS_NUMBER);
        return lottoWinChecked.checkedBonusLottoNumbers(input.inputBonusNumber());

    }

    private WinLottoResult makewinLottoResult(int[] equalCounts, boolean[] bonusCounts){
        return lottoStore.makeWinLottoResult(equalCounts,bonusCounts);
    }

    private void profitRateCheck(WinLottoResult winLottoResult, int payMoney) {
       double profitRate = lottoWinResult.profitRateCalculate(winLottoResult,payMoney);
        output.outPutLottoResult(profitRate,winLottoResult);
    }
}
