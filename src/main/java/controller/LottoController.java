package controller;
import model.Lotto;
import model.LottosData;
import model.WinData;
import view.InputResult;
import view.RequestText;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    RequestText requestText;
    InputResult inputResult;
    LottosData lottosData;
    WinData winData;
    LottoWinChecked lottoWinChecked;
    LottoWinResult lottoWinResult;

    public LottoController(RequestText requestText, InputResult inputResult, LottosData lottosData, WinData winData, LottoWinChecked lottoWinChecked, LottoWinResult lottoWinResult) {
        this.requestText = requestText;
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
        requestText.moneyRequest();
        String stinputMoney = Console.readLine();
        int inputMoney = Integer.parseInt(stinputMoney);
        lottosData.makeLottoData(inputMoney);
        inputResult.lottoNumResult();
    }

    private void inputWinLottoNum() {
        requestText.winLottoNumRequest();
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
        requestText.bonusLottoNumRequest();
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
