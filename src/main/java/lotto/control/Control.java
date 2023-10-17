package lotto.control;

import java.util.ArrayList;
import java.util.Map;
import lotto.constant.TotalResultMap;
import lotto.entity.Lotto;
import lotto.entity.LottoListClass;
import lotto.entity.User;
import lotto.entity.WinLotto;
import lotto.entity.WinLottoListClass;
import lotto.logic.Calculator;
import lotto.logic.Judgment;
import lotto.logic.LottoMachine;

public class Control {

    // 생성자에 매개변수로 받아 쓰는 게 좋은  지, 아니면 클래스 공통 변수로 참조해서 쓰는 게 좋은 지 궁금..
    protected User user;
    protected double rateOfReturn;
    protected int[] totalResult;

    private final LottoMachine lottoMachine;
    private final TotalResultMap totalResultMapClass;
    private final Calculator calculator;
    private LottoListClass lottoListsClass;
    private WinLottoListClass winLottoListClass;


    public Control() {
        user = new User();
        lottoMachine = new LottoMachine();
        totalResultMapClass = new TotalResultMap();
        calculator = new Calculator();
    }

    public void inputBudget(int budget) {
        user.setBudget(budget);
        playLotto();
    }

    public void playLotto() {
        lottoListsClass = new LottoListClass(lottoMachine.playLotto(user.getLottoCount()));
    }

    public ArrayList<Lotto> getLottoList() {
        return this.lottoListsClass.getLottoLists();
    }

    public void inputWinningNumber(String[] winningNumber) {
        WinLotto winLotto = new WinLotto();
        this.winLottoListClass = new WinLottoListClass(winLotto.drawNumber(winningNumber));
    }

    public void inputBonusLottoNumber(int bonusNumber) {
        winLottoListClass.setBonusNumber(bonusNumber);
        lottoJudge();
    }

    public void lottoJudge() {
        Judgment judgment = new Judgment(this.lottoListsClass.getLottoLists(), this.winLottoListClass);
        this.totalResult = judgment.judgeProduce();
        changeResultToHashMap();
    }

    public void changeResultToHashMap() {
        calculateResult(totalResultMapClass.getTotalResultMap(this.totalResult));
    }

    public void calculateResult(Map<String, Integer> totalResultMap) {
        rateOfReturn = calculator.calculate(totalResultMap, user.getBudget());
    }
}
