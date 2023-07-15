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
    Output output;
    InputResult inputResult;
    LottosData lottosData;
    WinData winData;
    LottoWinChecked lottoWinChecked;
    LottoWinResult lottoWinResult;

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
        inputWinLottoNum();
        inputBonusLottoNum();
        totalWinChecked();
        profitRateCheck();
    }

    private void inputMoney(){
        output.outPutMessage(RequestMessage.BUY_INPUT_MONEY);
        String inputMoney = Console.readLine();
        lottosData.makeLottoData(Integer.parseInt(inputMoney));
        inputResult.lottoNumResult();
    }

    private void inputWinLottoNum() {
        output.outPutMessage(RequestMessage.INPUT_WIN_NUMBER);
        String inputWinLottoNum = Console.readLine();
        String[] stWinLottoNums = inputWinLottoNum.split(",");
        List<Integer> winLottoNums = stringToInt(stWinLottoNums);
        Lotto winLotto = new Lotto(winLottoNums);
        winData.setWinLotto(winLotto);
        lottoWinChecked.checkedWinLottoNums();
        winData.setEqualCounts(lottoWinChecked.getEqualCounts());

    }
    private List<Integer> stringToInt(String[] winLottoNums){
        List<Integer> winlottonums = new ArrayList<>();
        for (String winLottoNum : winLottoNums) {
            winlottonums.add(Integer.parseInt(winLottoNum));
        }
        return winlottonums;
    }
    private void inputBonusLottoNum() {
        output.outPutMessage(RequestMessage.INPUT_BONUS_NUM);
        String inputBonusLottoNum = Console.readLine();
        int bonusNum =Integer.parseInt(inputBonusLottoNum);
        winData.setBonusNum(bonusNum);
        lottoWinChecked.checkedBonusLottoNums();
        winData.setBonusCounts(lottoWinChecked.getBonusCounts());
    }
    private void totalWinChecked(){
        lottoWinResult.totalWinCounted(winData);
        winData.setWinCountResult(lottoWinResult.getWinCountTemp());
        inputResult.goalResult();
    }

    private void profitRateCheck() {
        lottoWinResult.profitRateCal();
        winData.setProfitRateSecondPoint(lottoWinResult.getProfitRateSecondPoint());
        inputResult.profitRateResult();
    }
}
