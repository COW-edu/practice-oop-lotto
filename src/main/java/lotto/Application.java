package lotto;

import lotto.Controller.LottoSeller;
import lotto.Model.Buyer;
import lotto.Model.LottoBuyer;
import lotto.Controller.Seller;
import lotto.View.BuyerInteractionHandler;

public class Application {
    public static void main(String[] args) {
        Buyer buyer = new LottoBuyer();
        BuyerInteractionHandler buyerInteractionHandler = new BuyerInteractionHandler();
        Seller seller = new LottoSeller(buyer, buyerInteractionHandler);
        seller.run();
    }
}
