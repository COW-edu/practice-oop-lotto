package lotto.Controller;


import lotto.Model.Buyer;
import lotto.Model.LottoResultChecker;
import lotto.Model.Lotto;
import lotto.Model.WinningLotto;
import lotto.View.BuyerInteractionHandler;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller implements Seller {
    private final Buyer buyer;
    private final BuyerInteractionHandler buyerInteractionHandler;
    private final WinningLotto winningLotto;
    private final LottoResultChecker lottoResultChecker = new LottoResultChecker();

    public LottoSeller(Buyer buyer, BuyerInteractionHandler buyerInteractionHandler) {
        this.buyer = buyer;
        this.buyerInteractionHandler = buyerInteractionHandler;
        winningLotto = new WinningLotto();
    }

    @Override
    public void run() {
        buyer.pay(buyerInteractionHandler.requestMoney());
        buyer.receiveLotto();
        buyerInteractionHandler.showBuyResult(buyer.getPurchasedLottoCount(), getchangedString());
        setWinningLottoNumber(buyerInteractionHandler.requestWinningNumber());
        setBonusWinningLottoNumber(buyerInteractionHandler.requestBonusNumber());
        useLottoResultChecker();
        showStatics(lottoResultChecker.getMoneyStatics().getCountStatics(), lottoResultChecker.getConfirmedMoney(), buyer.getPaidMoney());
    }

    private void setWinningLottoNumber(String firstNumber) {
        winningLotto.setNumbers(firstNumber);
    }

    private void setBonusWinningLottoNumber(int bonusNumber) {
        winningLotto.setBonusNumber(bonusNumber);
    }

    private void useLottoResultChecker() {
        lottoResultChecker.matchNumber(buyer.getMyLotto(), winningLotto);
    }

    private void showStatics(List<Integer> countStatics, int totalAmount, int purchaseAmount) {
        buyerInteractionHandler.sayProfit(countStatics, calculateProfitRate(totalAmount, purchaseAmount));
    }

    private double calculateProfitRate(int totalWinningAmount, int purchaseAmount) {
        double rate = (double) totalWinningAmount / purchaseAmount;
        return Math.round(rate * 1000) / 10.0;
    }

    private List<String> getchangedString() {
        List<String> lottoStrings = new ArrayList<>();
        for (Lotto lotto : buyer.getMyLotto()) {
            lottoStrings.add(lotto.getNumbers().toString());
        }
        return lottoStrings;
    }
}
