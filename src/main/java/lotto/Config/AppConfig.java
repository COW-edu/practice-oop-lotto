package lotto.Config;

import lotto.Controller.LottoSeller;
import lotto.Model.Buyer;
import lotto.Model.LottoBuyer;
import lotto.View.BuyerInteractionHandler;

public class AppConfig {

    public LottoBuyer lottoBuyer() {
        return new LottoBuyer();
    }

    public BuyerInteractionHandler buyerInteractionHandler() {
        return new BuyerInteractionHandler();
    }

    public LottoSeller lottoSeller(Buyer lottoBuyer, BuyerInteractionHandler buyerInteractionHandler) {
        return new LottoSeller(lottoBuyer, buyerInteractionHandler);
    }
}
