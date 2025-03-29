package lotto.Controller;

import lotto.Model.Buyer;
import lotto.Model.ConfirmMachine;
import lotto.Model.WinningLotto;
import lotto.View.InteractBuyer;

import java.util.List;

public class LottoSeller implements Seller{
    private Buyer buyer;
    private InteractBuyer interactBuyer;
    private WinningLotto winningLotto;
    private ConfirmMachine confirmMachine = new ConfirmMachine();

    public LottoSeller(Buyer buyer, InteractBuyer interactBuyer){
        this.buyer = buyer;
        this.interactBuyer = interactBuyer;
        winningLotto = new WinningLotto();
    }
    public void setFirstWinningLottoNumber(String firstNumber){
        winningLotto.setFirstNumbers(firstNumber);
    }
    public void setBonusWinningLottoNumber(int bonusNumber){
        winningLotto.setBonusNumber(bonusNumber);
    }
    public void useConfirmMachine(){
        confirmMachine.matchNumber(buyer.showMyLotto(), winningLotto);
    }

    public void sayStatics(List<Integer> countStatics, int confirmedMoney, int purchasingMoney){
        interactBuyer.sayProfit(countStatics, confirmedMoney, purchasingMoney);
    }

    @Override
    public void sell() {
        try{
            buyer.purchaseMoney(interactBuyer.requestMoney());
            buyer.getLotto();
            interactBuyer.showBuyResult(buyer.getPurchasedLotto(), buyer.showMyLotto());
            setFirstWinningLottoNumber(interactBuyer.requestWinningNumber());
            setBonusWinningLottoNumber(interactBuyer.requestBonusNumber());
            useConfirmMachine();
            sayStatics(confirmMachine.getMoneyStatics().getCountStatics(), confirmMachine.getConfirmedMoney(), buyer.getPurchasingMoney());

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }




}
