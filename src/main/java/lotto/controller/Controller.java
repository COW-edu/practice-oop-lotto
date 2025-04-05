package lotto.controller;

import lotto.global.Constant;
import lotto.global.Validator;
import lotto.model.Model;
import lotto.view.View;

public class Controller {

    private View view;
    private Model model;

    public Controller() {
    }
    public void association(View view, Model model){
        this.view = view;
        this.model = model;
    }

    public void start() {
        handleMoney();
        model.makeLotto();
        view.printLotto(model.getLottos());
        handleWiningNumber();
        handleBonus();
        model.startLotto();
        view.showMessage(model.getLottoResult());
    }

    public void showMessage(String message) {
        view.showMessage(message);
    }
    public void showError(String message) {
        view.showError(message);
    }

    public void handleMoney(){
        String gold = view.inputString(Constant.ControllerConstant.INPUT_MONEY);
        try {
            Validator.checkNoBlank(gold);
            Validator.checkNumber(gold);
            model.setWallet(Integer.parseInt(gold));
        } catch (Exception e) {
            showError(e.getMessage());
            handleMoney();
        }
    }

    public void handleWiningNumber(){
        String lotto = view.inputString(Constant.ControllerConstant.INPUT_WININGNUMBER);
        try {
            Validator.checkNoBlank(lotto);
            model.setWiningLotto(lotto);
        } catch (Exception e) {
            showError(e.getMessage());
            handleWiningNumber();
        }
    }

    public void handleBonus(){
        String bonus = view.inputString(Constant.ControllerConstant.INPUT_BONUSNUMBER);
        try {
            Validator.checkNoBlank(bonus);
            Validator.checkNumber(bonus);
            model.setBonus(Integer.parseInt(bonus));
        } catch (Exception e) {
            showError(e.getMessage());
            handleBonus();
        }
    }
}