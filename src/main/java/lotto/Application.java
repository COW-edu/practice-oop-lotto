package lotto;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Random;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        int purchasePrice = Integer.parseInt(Console.readLine());
        List<Lotto> lottoList = purchase(purchasePrice);

        System.out.println("당첨 번호를 입력해 주세요.");
        int[] winNumbers = getWinNumber(Console.readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber(Console.readLine());
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
            lotto.print();
            lottoList.add(lotto);
        }

        return lottoList;
    }

    private static int[] getWinNumber(String numbersLine) {
        String[] temp = numbersLine.split(",");
        if (temp.length != 6) {
            throw new IllegalArgumentException("[ERROR] 번호 입력이 올바르지 않습니다.");
        }
        int[] winNumbers = new int[6];
        for (int i = 0; i < temp.length; i++) {
            winNumbers[i] = Integer.parseInt(temp[i]);
        }
        return winNumbers;
    }

    private static int getBonusNumber(String bonusNumberLine) {
        return Integer.parseInt(bonusNumberLine);
    }
}
