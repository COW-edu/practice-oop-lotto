package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.User;
import lotto.Lotto;
import view.OutputView;

import java.util.List;

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

    public List<Integer> selectLottoNumber() {
        List<Integer> selectNum = user.userLottoNumber((Console.readLine()));
        return selectNum;
    }

    public String selectBonusNumber() {
        String userBonusStr = user.getUserLottoBonus();
        return userBonusStr;
    }
}
