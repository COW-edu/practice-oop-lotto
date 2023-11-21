package lotto.view;

import java.util.Map;

public class AskWinningNumberView implements Viewable {

    @Override
    public void render(Map<String, Object> model) {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
