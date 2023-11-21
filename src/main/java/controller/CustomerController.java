package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.User;
import lotto.Lotto;
import view.OutputView;

public class CustomerController {

    private static int count;
    private static int userBonusNumber;

    private Lotto selectLotto;
    private User user;

    public CustomerController(User user) {
        this.count = 0;
        this.user = user;
    }

    public int buyingLotto() {
        count = user.lottoCount(Console.readLine());
        return count;
    }

    public Lotto selectLottoNumber() {
        this.selectLotto = new Lotto(user.userLottoNumber(Console.readLine()));
        return selectLotto;
    }

    public int selectBonusNumber() {
        String userBonusStr = user.getUserLottoBonus();
        userBonusNumber = this.selectLotto.userBonusNum(userBonusStr);
        return userBonusNumber;
    }
}
