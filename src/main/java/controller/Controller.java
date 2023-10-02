package controller;

import lotto.Lotto;
import lotto.LottoNumbers;
import lotto.Reward;
import user.User;

import java.util.List;

public class Controller {

    private User user;
    private List<Lotto> lottos;
    private LottoNumbers lottoNumbers;
    private Lotto selectLotto;

    public Controller() {
        user = new User();
        lottoNumbers = new LottoNumbers();
    }

    public void start() {
        // 로또 구매
        System.out.println("구입 금액을 입력해주세요: ");
        int count = user.lottoCount();

        // 입력 금액에 해당하는 로또 번호 출력
        lottos = lottoNumbers.makeList(count);

        // 당첨 번호 & 보너스 번호 입력
        System.out.println("당첨 번호를 입력해주세요.");
        selectLotto = lottoNumbers.checkOutOfRange(user.getUserLottoNumber());

        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = lottoNumbers.checkDuplication(selectLotto, user.getUserLottoBonus());

        // 번호 비교 후 당첨금 배분
        System.out.println("\n당첨 통계\n---");
        Reward reward = new Reward(lottos, count);
        reward.compareLotto(selectLotto, bonusNumber);

        // 수익률 출력
        reward.getPercentage();
    }

}
