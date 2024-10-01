package lotto;

import java.util.*;

import static lotto.LottoRank.*;
import static lotto.LottoRank.FIFTH;

//로또 생성 및 계산
public class LottoService {
    static LottoMaker lottoMaker = new LottoMaker();

    Scanner sc = new Scanner(System.in);


    public void run() {
        int inputMoney = getInputMoney();
        generateLottoNum(inputMoney);
        Lotto userLotto = inputNumber();
        int bonusNum = getBonusNum();
        lottoComparison(userLotto, bonusNum);
        print(inputMoney);
    }

    private int getBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = sc.nextInt();
        return bonusNum;
    }

    private int getInputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        int inputMoney = sc.nextInt();
        return inputMoney;
    }

    private static void lottoComparison(Lotto userLotto, int bonusNum) {
        Iterator<List<Integer>> lottoList = lottoSavedLooping();
        while (lottoList.hasNext()) {
            List<Integer> current = lottoList.next();
            int sameNumbers = 0; // 매번 current에 대해 초기화

            // userLotto의 숫자와 current 비교
            for (Integer element : userLotto) { // userLotto에서 번호 가져오기
                if (current.contains(element)) {
                    sameNumbers++;
                }
            }
            if (sameNumbers == 6) {
                FIRST.setQuantity(FIRST.getQuantity() + 1);// 6개 일치
                continue;
            }
            if (sameNumbers == 5 && current.contains(bonusNum)) {
                SECOND.setQuantity(SECOND.getQuantity() + 1); // 5개 일치 + 보너스 번호
                continue;
            }

            if (sameNumbers == 5) {
                THIRD.setQuantity(THIRD.getQuantity() + 1); // 5개 일치
                continue;
            }

            if (sameNumbers == 4) {
                FOURTH.setQuantity(FOURTH.getQuantity() + 1); // 4개 일치
                continue;
            }

            if (sameNumbers == 3) {
                FIFTH.setQuantity(FIFTH.getQuantity() + 1);// 3개 일치
            }
        }
    }

    private static Iterator<List<Integer>> lottoSavedLooping() {
        return lottoMaker.lottoSaved.iterator();
    }

    private Lotto inputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        String inputNum = sc.next();
        String[] targetNum = inputNum.split(",");
        for (String num : targetNum) {
            numbers.add(Integer.parseInt(num.trim()));
        }
        Collections.sort(numbers); //어떻게 입력 받든 정렬하기.
        return new Lotto(numbers);//사용자 로또 저장 후 반환
    }

    private void generateLottoNum(int inputMoney) {

        int amount = inputMoney / 1000;
        System.out.println(amount + "개를 구매했습니다.");
        lottoMaker.generate(amount);
    }

    private void print(int inputMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원)" + FIFTH.getQuantity() + "개");
        System.out.println("4개 일치 (50,000원)" + FOURTH.getQuantity() + "개");
        System.out.println("5개 일치 (1,500,000원)" + THIRD.getQuantity() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)" + SECOND.getQuantity() + "개");
        System.out.println("6개 일치 (1,000,000,000원)" + FIRST.getQuantity() + "개");


        double totalPrice = (FIFTH.getLottoTotalPrize() + FOURTH.getLottoTotalPrize() + THIRD.getLottoTotalPrize() + SECOND.getLottoTotalPrize() + FIRST.getLottoTotalPrize()) / inputMoney * 100;


        System.out.println("총 수익률은 " + totalPrice + "% 입니다.");
    }
}
