package controller;
import message.RequestMessage;
import model.Lotto;
import model.LottosData;
import model.WinData;
import view.InputResult;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import view.output.Output;

public class LottoController {
    private final Output output;
    private final InputResult inputResult;
    private final LottosData lottosData;
    private final WinData winData;
    private final LottoWinChecked lottoWinChecked;
    private final LottoWinResult lottoWinResult;

    public LottoController(Output output, InputResult inputResult, LottosData lottosData, WinData winData, LottoWinChecked lottoWinChecked, LottoWinResult lottoWinResult) {
        this.output = output;
        this.inputResult = inputResult;
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
        String inputMoney = Console.readLine();
        lottosData.makeLottoData(Integer.parseInt(inputMoney));
        inputResult.lottoNumberResult();
    }

    private void inputWinLottoNumber() {
        output.outPutMessage(RequestMessage.INPUT_WIN_NUMBER);
        String inputWinLottoNumber = Console.readLine();
        String[] stWinLottoNumbers = inputWinLottoNumber.split(",");
        List<Integer> winLottoNumbers = stringToInt(stWinLottoNumbers);
        Lotto winLotto = new Lotto(winLottoNumbers);
        winData.setWinLotto(winLotto);
        lottoWinChecked.checkedWinLottoNumbers();
        winData.setEqualCounts(lottoWinChecked.getEqualCounts());
    }

    private List<Integer> stringToInt(String[] winLottoNumbers){
        List<Integer> winlottonumbers = new ArrayList<>();
        for (String winLottoNumber : winLottoNumbers) {
            winlottonumbers.add(Integer.parseInt(winLottoNumber));
        }
        return winlottonumbers;
    }

    private void inputBonusLottoNumber() {
        output.outPutMessage(RequestMessage.INPUT_BONUS_NUMBER);
        String inputBonusLottoNumber = Console.readLine();
        int bonusNumber =Integer.parseInt(inputBonusLottoNumber);
        winData.setBonusNumber(bonusNumber);
        lottoWinChecked.checkedBonusLottoNumbers();
        winData.setBonusCounts(lottoWinChecked.getBonusCounts());
    }

    private void totalWinChecked(){
        lottoWinResult.totalWinCounted(winData);
        winData.setWinCountResult(lottoWinResult.getWinCountTemp());
        inputResult.goalResult();
    }

    private void profitRateCheck() {
        lottoWinResult.profitRateCalculate();
        winData.setProfitRateSecondPoint(lottoWinResult.getProfitRateSecondPoint());
        inputResult.profitRateResult();
    }
}
