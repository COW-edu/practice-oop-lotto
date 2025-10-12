package lotto.view;

import lotto.enums.ErrorMessage;
import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class View {
    private final InputReader reader;
    private Validator validator;

    // 생성자에서 InputReader 구현체 주입
    public View() {
        this.reader = new Scan(); // Scan은 InputReader 구현체
        this.validator = new Validator();
    }

    // 로또 구매하기
    public int lottoPurchseStart(){
        try {
            System.out.println("로또 구입금액을 입력해 주세요.");
            String line = reader.readLine();

            // 빈 입력 체크
            int purchasePrice=validator.priceValidator(line);

            System.out.println();
            return purchasePrice;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
        }
    }

    // 로또 구매 개수 출력
    public void LottoNum(int count){
        System.out.println(count + "개를 구매했습니다.");
        System.out.println();
    }

    // 로또 번호 출력
    public void LottoDrow(List<List<Integer>> lottos){
        for(List<Integer> lotto : lottos){
            System.out.println(lotto);
        }
        System.out.println();
    }

    // 당첨 번호 입력
    public List<Integer> winningNumber(){
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumber = reader.readLine();
            String[] winningNumbers = winningNumber.split(",");
            System.out.println();

            return validator.winningNumberValidator(winningNumbers);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_VALID_NUMBER.getMessage());
        }
    }

    // 보너스 번호 입력
    public int bounusNumber(){ // 메서드명 그대로 유지
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = reader.readLine();
            int bonusNumber = Integer.parseInt(input);
            System.out.println();
            return validator.bounusNumberValidator(bonusNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    // 최종 결과 출력
    public void winningStatistics(Map<Rank, Integer> statistics, double lottoYield) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + statistics.get(Rank.THREE) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(Rank.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(Rank.FIVE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "
                + statistics.get(Rank.FIVE_AND_BONUS) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(Rank.SIX) + "개");

        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoYield);
    }

}
