package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Random;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해 주세요.");
        int purchasePrice = Integer.parseInt(Console.readLine());
        List<Lotto> lottoList = purchase(purchasePrice);
    }

    private static List<Lotto> purchase(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        int purchaseAmount = purchasePrice / 1000;
        System.out.println(purchaseAmount + "개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }

        return lottoList;
    }
}
