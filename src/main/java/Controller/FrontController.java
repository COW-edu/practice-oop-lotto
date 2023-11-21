package Controller;

import View.InputView;
import View.OutputView;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
    private OutputView outputView = new OutputView();
    private static final String END = "6";
    private final Map<String, Controllable> controllers = new HashMap<>();


    public FrontController(){
        controllers.put("1", new BuyLottoController());
        controllers.put("2", new MakeWinningNumbersController());
        controllers.put("3", new MakeBonusNumberController());
        controllers.put("4", new GetLottoController());
        controllers.put("5", new CalculateController());
    }
    public void run() {
        FrontController frontController = new FrontController();

        String Menu = "0";
        while(!Menu.equals(END)){
            outputView.RequestMenu();
            Menu = InputView.getInput();
            frontController.service(Menu);
            System.out.println("");
        }
    }

    public void service(String path) {
        Controllable controllable = controllers.get(path);
        controllable.process();
    }
}
