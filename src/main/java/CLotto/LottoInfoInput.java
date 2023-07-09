package CLotto;
import MLotto.Lotto;
import MLotto.LottosData;
import MLotto.WinData;
import VLotto.InputResult;
import VLotto.RequestText;
import camp.nextstep.edu.missionutils.Console;
import forException.CheckedException;

import java.util.ArrayList;
import java.util.List;

public class LottoInfoInput {
    RequestText requestText;
    InputResult inputResult;
    LottosData lottosData;
    WinData winData;
    LottoWinChecked lottoWinChecked;
    LottoWinResult lottoWinResult;
//    CheckedException checkedException;
    public LottoInfoInput(){
        lottosData = new LottosData();
        winData= new WinData();
        requestText = new RequestText();
        inputResult = new InputResult(lottosData,winData);
        lottoWinChecked = new LottoWinChecked(lottosData,winData);
        lottoWinResult = new LottoWinResult(lottosData,winData);
//        checkedException= new CheckedException(lottosData,winData);
    }
    public void inputMoney(){
        requestText.moneyRequest();
        String stinputMoney = Console.readLine();
        int inputMoney = Integer.parseInt(stinputMoney);
        lottosData.makeLottoData(inputMoney);
        inputResult.lottoNumResult();
    }

    public void inputWinLottoNum() {
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
    public void inputBonusLottoNum() {
        requestText.bonusLottoNumRequest();
        String inputBonusLottoNum = Console.readLine();
        int bonusNum =Integer.parseInt(inputBonusLottoNum);
        winData.setBonusNum(bonusNum);
        lottoWinChecked.checkedBonusLottoNums();
        winData.setBonusCounts(lottoWinChecked.getBonusCounts());
    }
    public void totalWinChecked(){
        lottoWinResult.totalWinCounted(winData);
        winData.setWinCountResult(lottoWinResult.getWinCountTemp());
        inputResult.goalResult();
    }

    public void profitRateCheck() {
        lottoWinResult.profitRateCal();
        winData.setProfitRateSecondPoint(lottoWinResult.getProfitRateSecondPoint());
        inputResult.profitRateResult();
    }
}
