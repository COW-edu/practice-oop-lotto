    package lotto.domain;

    import lotto.controller.LottoGenerator;
    import java.util.List;

    public class PurchaseInfo {

        private final int money;
        private final List<Lotto> boughtLottos;

        public PurchaseInfo(int money, List<Lotto> boughtLottos) {
            this.money = money;
            this.boughtLottos = boughtLottos;
        }

        public static PurchaseInfo create(int money, LottoGenerator lottoGenerator) {
            List<Lotto> boughtLottos = lottoGenerator.buy(money);
            return new PurchaseInfo(money, boughtLottos);
        }

        public int getMoney() {
            return money;
        }

        public List<Lotto> getBoughtLottos() {
            return boughtLottos;
        }
    }
