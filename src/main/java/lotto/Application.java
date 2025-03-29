package lotto;

import lotto.Controller.LottoSeller;
import lotto.Model.Buyer;
import lotto.Model.LottoBuyer;
import lotto.Controller.Seller;
import lotto.View.InteractBuyer;

public class Application {
    public static void main(String[] args) {
        Buyer buyer = new LottoBuyer();
        InteractBuyer interactBuyer = new InteractBuyer();
        Seller seller = new LottoSeller(buyer, interactBuyer);
        seller.sell();
    }
}
