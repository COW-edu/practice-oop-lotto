package controller;

import model.Grade;
import model.Lotto;
import model.LottoRepository;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrontController {

    private InputView inputView;
    private OutputView outputView;
    private final Map<Integer, Controller> controllers = new HashMap<>();

    public FrontController(InputView inputView, OutputView outputView, LottoController lottoController, WinningCheckController winningCheckController) {
        this.inputView = inputView;
        this.outputView = outputView;
        controllers.put(0, new LottoController());
        controllers.put(1, new WinningLottoController());
        controllers.put(2, new WinningCheckController());
    }

    public void run() {
        try {
            for(int i = 0; i < 3; i++) {
                controllers.get(i).service(this.inputView, this.outputView);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
