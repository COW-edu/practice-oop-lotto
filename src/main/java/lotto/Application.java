package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = LottoInput.askMoney();          // 사용자로부터 금액을 입력받음
        int countLotto = LottoInput.getLottoCount(money); // 구매한 로또 개수를 계산하고 출력함

        LottoManager lottoManager = new LottoManager();
        lottoManager.issueLottos(countLotto);           // 로또 발행
        lottoManager.printLottos();                     // 발행된 로또 출력

        List<Integer> winningNumbers = LottoInput.askWinningNumbers();
        int bonusNumber = LottoInput.askBonusNumber();
    }
}
