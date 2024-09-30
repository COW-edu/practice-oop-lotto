package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.internal.bytebuddy.utility.RandomString.make;

public class Application {
    public static void main(String[] args) {
        run();

        // TODO: 프로그램 구현
    }

    private static void run() {
        LottoMaker lottoMaker = new LottoMaker();

        Scanner sc = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = sc.nextInt() / 1000;
        System.out.println(amount + "개를 구매했습니다.");
        lottoMaker.generate(amount);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        String input = sc.next();
        String[] targetNum = input.split(",");
        for (String num : targetNum) {
           numbers.add(Integer.parseInt(num.trim()));
        }
        Lotto userLotto = new Lotto(numbers);//사용자 로또 저장


        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = sc.nextInt();

        System.out.println("당첨 통계");
        System.out.println("---");
        //각각에 맞느 숫자 구현하면 됨.

        System.out.println("3개 일치 (5,000원)" + "개" );
        System.out.println("4개 일치 (50,000원)" );
        System.out.println("5개 일치, 보너스 볼 일치 (1,500,000원)" );
        System.out.println("6개 일치 (1,000,000,000원)" );

        System.out.println("총 수익률은 " + "입니다.");


    }


}
