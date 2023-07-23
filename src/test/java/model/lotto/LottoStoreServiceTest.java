package model.lotto;

import java.util.List;
import java.util.Map;
import model.customer.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreServiceTest {

  private LottoStoreService lottoStoreService;
  @BeforeEach
  public void BeforeEach() {
    lottoStoreService = new LottoStoreService();
  }

  @Test
  @DisplayName("지불한 금액만큼 로또의 개수만큼 PurchasedLotto클래스를 생성하고 리스트에 데이터를 추가해준다.")
  void createPurchaseLottos() {
    PurchasedLottos purchasedLottos = lottoStoreService.createPurchaseLottos(5000);
    Assertions.assertThat(purchasedLottos.getPurchasedLottosCount()).isEqualTo(5);
  }

  @DisplayName("개수당 당첨 결과를 만들고")
  @Test
  void createWinLottoResult() {
    PurchasedLottos purchasedLottos = new PurchasedLottos();
    purchasedLottos.addPurchasedLotto(new Lotto(List.of(3,4,5,6,7,8)));
    Customer customer = new Customer(purchasedLottos, 1000);
    Lotto winLotto = new Lotto(List.of(1,2,3,4,5,6));
    Map<String, Integer> winLottoResult = lottoStoreService.createWinLottoResult(customer,winLotto, 8);
    Assertions.assertThat(winLottoResult.get("4")).isEqualTo(1);

  }
}