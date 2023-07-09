package lotto.model;

import java.util.Stack;

public class Wallet {
    Stack<Lotto> lottoStack = new Stack<>();
    int[] winNumber;
    int bonusNumber;

    public void addLotto(Lotto lotto) {
        lottoStack.push(lotto);
    }

    public Lotto getLotto() {
        if (lottoStack.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_EMPTY_WALLET.getData());
        }
        return lottoStack.pop();
    }

    public void setWinNumber(int[] winNumber) {
        this.winNumber = winNumber;
    }

    public int[] getWinNumber() {
        return this.winNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
