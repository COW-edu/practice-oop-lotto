package lotto.io;

import java.util.List;
import java.util.Map;

public class OutputHandler {

  public static void printLottos (List<List<Integer>> lottoStorage, int count){

    System.out.println("\n" + count + "개를 입력했습니다.");
    for (int i =0; i < lottoStorage.size(); i++){
      System.out.println(lottoStorage.get(i));
    }
  }

  public static void printLottoResult(Map<Integer, Integer> prizeRanking, double profitRate){
    final int FIRST_PLACE = 6;
    final int SECOND_PLACE = 5;
    final int THIRD_PLACE = 4;
    final int FOURTH_PLACE = 3;
    final int FIFTH_PLACE = 2;

    System.out.println("\n당첨 통계");
    System.out.println("---------");
    System.out.println("3개 일치 (5,000원)- " + prizeRanking.get(FIFTH_PLACE) + "개");
    System.out.println("4개 일치 (50,000원)- " + prizeRanking.get(FOURTH_PLACE) + "개");
    System.out.println("5개 일치 (1,500,000원)- "+ prizeRanking.get(THIRD_PLACE) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)-"+ prizeRanking.get(SECOND_PLACE) + "개");
    System.out.println("6개 일치 (2,000,000,000원)- "+ prizeRanking.get(FIRST_PLACE) + "개");
    System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
  }

}
