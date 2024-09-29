package lotto;

import controller.CLotto;
import model.Lotto;
import model.LottoNum;
import view.VLotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoNum lottoNum = new LottoNum();
        VLotto vLotto = new VLotto();
        CLotto cLotto = new CLotto(lottoNum, vLotto);

        cLotto.run();
    }


}
