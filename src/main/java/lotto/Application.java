package lotto;

import lotto.Config.AppConfig;
import lotto.Model.Buyer;
import lotto.Controller.Seller;
import lotto.View.BuyerInteractionHandler;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Buyer buyer = appConfig.lottoBuyer();
        BuyerInteractionHandler buyerInteractionHandler = appConfig.buyerInteractionHandler();
        Seller seller = appConfig.lottoSeller(buyer, buyerInteractionHandler);
        seller.run();
    }
}
