package lotto.view;

import static lotto.constant.ViewIndex.ASK_BONUS_NUMBER;
import static lotto.constant.ViewIndex.ASK_BUDGET;
import static lotto.constant.ViewIndex.ASK_WINNING_NUMBER;

import java.util.HashMap;
import java.util.Map;

public class OutputViewFactory {


    private final Map<String, Viewable> views = new HashMap<>();
    private static final OutputViewFactory instance = new OutputViewFactory();

    public static OutputViewFactory getInstance() {
        return instance;
    }

    private OutputViewFactory() {
        views.put("buy", new LottoBuyOutputView());
        views.put(ASK_BUDGET, new AskBudgetView());
        views.put(ASK_WINNING_NUMBER, new AskWinningNumberView());
        views.put(ASK_BONUS_NUMBER, new AskBonusView());
        views.put("statistics", new ResultView());
    }

    public Viewable get(String viewPath) {
        return views.get(viewPath);
    }
}
