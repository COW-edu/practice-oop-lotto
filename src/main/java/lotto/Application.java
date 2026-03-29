package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Check checkMoney = new CheckMoney();
        RandomLotto randomLotto = new RandomLotto();

        System.out.println("구입금액을 입력해 주세요.");

        int num = sc.nextInt();

        if (!checkMoney.checkNum(num)) {
            throw new IllegalArgumentException();
        }
        int count = (num / 1000);

        System.out.println("\n"+ count + "개를 구매했습니다.");

        List<List<Integer>> randLotto = new ArrayList<>();
        for (int i=0; i<count; i++) {
            List<Integer> rLotto = randomLotto.generate();

            System.out.println(rLotto);
            randLotto.add(rLotto);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");

    }


}
