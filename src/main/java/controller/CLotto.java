package controller;

import model.LottoNum;
import model.Lotto;
import model.WinCheck;
import valueObject.ErrorMessage;
import view.VLotto;

import java.util.ArrayList;
import java.util.List;

public class CLotto {
    private LottoNum lottoNum;
    private Lotto mLotto;
    private WinCheck winCheck;
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


        try {
            // 당첨 번호 및 보너스 번호 입력받기
            String winningNumber = vLotto.getWinningNumber();
            List<Integer> winningNumberList = lottoNum.splitNum(winningNumber);
            mLotto = new Lotto(winningNumberList);
            int bonusNumber = vLotto.getBonusNumber();
            lottoNum.validate(bonusNumber); // 보너스 번호 범위 확인
            winCheck = new WinCheck(winningNumberList, bonusNumber, userLottos);
        } catch (NumberFormatException e) {
            System.err.println(errorMessage.ERROR_NUM);
        } catch (IllegalArgumentException e) {
            System.err.println(errorMessage.ERROR_COUNT);
        }


    }
}
