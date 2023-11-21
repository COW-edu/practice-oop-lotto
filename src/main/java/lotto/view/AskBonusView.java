package lotto.view;

import java.util.Map;

public class AskBonusView implements Viewable {

    @Override
    public void render(Map<String, Object> model) {
        System.out.println("\n보너스 번호를 입력해주세요");
    }
}
