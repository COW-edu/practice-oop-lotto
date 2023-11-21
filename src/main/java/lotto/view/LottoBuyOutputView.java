package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.entity.Lotto;

public class LottoBuyOutputView implements Viewable {

    @Override
    public void render(Map<String, Object> model) {
        printUserLottoCount((Integer) model.get("lottoCount"));
        printLottoList(model.get("lottoList"));

    }

    public void printLottoList(Object lottoRepository) {
        for (Lotto lotto : (List<Lotto>) lottoRepository) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printUserLottoCount(int numberOfuserLotto) {

        System.out.println("\n" + numberOfuserLotto + "개를 구매했습니다.");
    }

}
