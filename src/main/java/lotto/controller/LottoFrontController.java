package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class LottoFrontController {
    private final InputView inputView;
    private final OutputView outputView;


    private final Map<Integer, Controller> controllersMap = new HashMap<>();

    public LottoFrontController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

        controllersMap.put(1, new LottoPurchaseController(inputView, outputView));
        controllersMap.put(2, new LottoController(inputView, outputView));
        controllersMap.put(3, new WinningLottoController(inputView, outputView));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();

        for (Controller controller : controllersMap.values()) {
            controller.service(model);
        }


//        Iterator<Integer> iter = controllersMap.keySet().iterator();
//        while (iter.hasNext()) {
//            int key = iter.next();
//            controllersMap.get(key).service(model);
//        }
    }
}
