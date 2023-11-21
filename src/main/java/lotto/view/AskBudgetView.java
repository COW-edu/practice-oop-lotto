package lotto.view;

import java.util.Map;

public class AskBudgetView implements Viewable {

    @Override
    public void render(Map<String, Object> model) {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
