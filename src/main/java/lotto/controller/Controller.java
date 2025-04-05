package lotto.controller;

import lotto.global.Constant;
import lotto.global.Validator;
import lotto.model.Model;
import lotto.view.View;

import java.util.StringTokenizer;

public class Controller {

    private View view;
    private Model model;

    private final static String INPUT_MONEY = "구입금액을 입력해주세요";
    private final static String INPUT_WININGNUMBER = "당첨 번호를 입력해주세요";
    private final static String INPUT_BONUSNUMBER = "보너스 번호를 입력해주세요";

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

    public void showError(String message) {
        view.showError(message);
    }

    public void handleMoney(){
        String gold = view.inputString(INPUT_MONEY);
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
        String inputString = view.inputString(INPUT_WININGNUMBER );
        try {
            Validator.checkNoBlank(inputString);
            StringTokenizer token = new StringTokenizer(inputString,",");
            int[] winingNumbers = new int[Constant.LottoConstant.LOTTO_COUNT];
            for(int i = 0; i< Constant.LottoConstant.LOTTO_COUNT; i++){
                String num = token.nextToken();
                Validator.checkNumber(num);
                winingNumbers[i] = Integer.parseInt(num);
            }
            model.setWiningLotto(winingNumbers);
        } catch (Exception e) {
            showError(e.getMessage());
            handleWiningNumber();
        }
    }

    public void handleBonus(){
        String bonus = view.inputString(INPUT_BONUSNUMBER);
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