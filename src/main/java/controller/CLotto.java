package controller;

import model.LottoNum;
import model.Lotto;
import valueObject.ErrorMessage;
import view.VLotto;

import java.util.ArrayList;
import java.util.List;

public class CLotto {
    private LottoNum lottoNum;
    private Lotto mLotto;
    private VLotto vLotto;
    private ErrorMessage errorMessage;

    public CLotto(LottoNum lottoNum, VLotto vLotto) {
        this.lottoNum = lottoNum;
        this.vLotto = vLotto;
    }

    public void run() {
        int money = vLotto.getMoneyInput();
        int lottoCount = lottoNum.buyLotto(money);
        vLotto.displayLottoCount(lottoCount);

        List<List<Integer>> userLottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = lottoNum.lottoNumbers();
            vLotto.displayLottoNumber(lottoNumbers);
            userLottos.add(lottoNumbers);
        }

        // 당첨 번호 및 보너스 번호 입력받기
        String winningNumber = vLotto.getWinningNumber();
        List<Integer> winningNumberList = lottoNum.splitNum(winningNumber);
        try {
            mLotto = new Lotto(winningNumberList);
        } catch (IllegalArgumentException e) {
            System.err.println(errorMessage.ERROR_COUNT);
        }
        int bonusNumber = vLotto.getBonusNumber();

    }
}
