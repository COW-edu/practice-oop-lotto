package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.User;
import lotto.Lotto;
import view.OutputView;

public class CustomerController {

    private static int count;
    private static int userBonusNumber;

    private final OutputView outputView;
    private Lotto selectLotto;
    private User user;

    public CustomerController(OutputView outputView, User user) {
        this.count = 0;
        this.outputView = outputView;
        this.user = user;
    }

    public int buyingLotto() {
        outputView.inputMoney();
        count = user.lottoCount(Console.readLine());
        outputView.announcePayment(count);
        return count;
    }

    public Lotto selectLottoNumber() {
        outputView.inputLottoNum();
        this.selectLotto = new Lotto(user.userLottoNumber(Console.readLine()));
        return selectLotto;
    }

    public int selectBonusNumber() {
        outputView.inputBonusNum();
        String userBonusStr = user.getUserLottoBonus();
        userBonusNumber = this.selectLotto.userBonusNum(userBonusStr);
        return userBonusNumber;
    }
}
