package lotto;

import java.util.*;

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
        int inputMoney = sc.nextInt();
        int amount = inputMoney / 1000;
        System.out.println(amount + "개를 구매했습니다.");
        lottoMaker.generate(amount);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        String inputNum = sc.next();
        String[] targetNum = inputNum.split(",");
        for (String num : targetNum) {
            numbers.add(Integer.parseInt(num.trim()));
        }

        Lotto userLotto = new Lotto(numbers);//사용자 로또 저장


        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = sc.nextInt();

        System.out.println("당첨 통계");
        System.out.println("---");


        //루프 돌리면서 하나씩 꺼내고 비교 반복

        int first = 0;
        int third = 0;
        int fourth = 0;
        int fifth = 0;
        int second = 0;

        Iterator<List<Integer>> lottoList = lottoMaker.lottoSaved.iterator();
        while (lottoList.hasNext()) {
            List<Integer> current = lottoList.next();
            int count = 0; // 매번 current에 대해 초기화

            // userLotto의 숫자와 current 비교
            for (Integer element : userLotto) { // userLotto에서 번호 가져오기
                if (current.contains(element)) {
                    count++;
                }
            }

            // count에 따른 조건 처리
            if (count == 6) {
                first++; // 6개 일치
            } else if (count == 5) {
                if (current.contains(bonusNum)) {
                    second++; // 5개 일치 + 보너스 번호
                } else {
                    third++; // 5개 일치
                }
            } else if (count == 4) {
                fourth++; // 4개 일치
            } else if (count == 3) {
                fifth++; // 3개 일치
            }
        }

        int firstPrice = 1000000000;
        int secondPrice = 30000000;
        int thirdPrice = 1500000;
        int fourthPrice = 50000;
        int fifthPrice = 5000;

        System.out.println("3개 일치 (5,000원)" + fifth + "개");
        System.out.println("4개 일치 (50,000원)" + fourth + "개");
        System.out.println("5개 일치 (1,500,000원)" + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)" + second + "개");
        System.out.println("6개 일치 (1,000,000,000원)" + first + "개");

        double totalPrice = (double) (fifthPrice * fifth + fourthPrice * fourth + thirdPrice * third + secondPrice * second + firstPrice * first) / inputMoney * 100;

        System.out.println("총 수익률은 " + totalPrice + "% 입니다.");


    }


}
