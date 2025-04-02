package lotto.model;

import lotto.global.Constant.ControllerWallet;

public class Wallet {

    private int money;
    private int lottoCount;
    
    public Wallet(int money) {
        checkUnitMoney(money);
        this.money = money;
        lottoCount = this.money / ControllerWallet.UNIT;
    }
    private void checkUnitMoney(int money){
        if (money % ControllerWallet.UNIT != 0) {
            throw new IllegalArgumentException(ControllerWallet.unitError());
        }
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getLottoCount() {
        return lottoCount;
    }
    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }
}
