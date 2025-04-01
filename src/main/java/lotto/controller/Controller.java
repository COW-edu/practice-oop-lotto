package lotto.controller;

import java.util.Scanner;

import lotto.global.Constant;
import lotto.global.Validator;
import lotto.model.Model;
import lotto.view.View;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        inputGold();
        model.makeLotto();
        view.printLotto(model.getLottos());
        inputLotto();
        inputBonus();
        model.startLotto();
        view.printResult(model.getMoney(), model.getLottoResult());
    }

    public void showMessage(String message) {
        view.showMessage(message);
    }
    public void showError(String message) {
        view.showError(message);
    }

    public void inputGold(){
        String gold = view.inputString(Constant.ControllerConstant.INPUT_MONEY);
        try {
            Validator.checkNoBlank(gold);
            Validator.checkNumber(gold);
            model.setMoney(Integer.parseInt(gold), Constant.ControllerConstant.UNIT);
        } catch (Exception e) {
            showError(e.getMessage());
            inputGold();
        }
    }

    public void inputLotto(){
        String lotto = view.inputString(Constant.ControllerConstant.INPUT_CORRECTNUMBER);
        try {
            Validator.checkNoBlank(lotto);
            model.setCorrectLotto(lotto);
        } catch (Exception e) {
            showError(e.getMessage());
            inputLotto();
        }
    }

    public void inputBonus(){
        String bonus = view.inputString(Constant.ControllerConstant.INPUT_BONUSNUMBER);
        try {
            Validator.checkNoBlank(bonus);
            Validator.checkNumber(bonus);
            model.setBonus(Integer.parseInt(bonus));
        } catch (Exception e) {
            showError(e.getMessage());
            inputBonus();
        }
    }
}