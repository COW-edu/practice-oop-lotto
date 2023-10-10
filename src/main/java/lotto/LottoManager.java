package lotto;

import java.util.ArrayList;
import java.util.List;

// 로또 발행과 발행된 로또의 관리(저장 및 출력)의 역할
public class LottoManager {
  private List<Lotto> lottos;

  public LottoManager() {
    lottos = new ArrayList<>();
  }

  // 로또를 발행하여 리스트에 추가하는  메서드
  public void issueLottos(int count) {
    for (int i = 0; i < count; i++) {
      lottos.add(LottoGenerator.generateLotto(LottoInput.getLottoCount()));
    }
  }

  // 발행된 로또들을 출력하는 메서드
  public void printLottos() {
    for (Lotto lotto : lottos) {
      System.out.println(lotto.getNumbers());
    }
  }

  public List<Lotto> getLottos() {
    return lottos;
  }
}
