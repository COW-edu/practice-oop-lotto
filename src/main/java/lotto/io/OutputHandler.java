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

  public static void printLottoResult(Map<String, Integer> prizeRanking, double profit){

    System.out.println("\n당첨 통계");
    System.out.println("---------");

    System.out.println("3개 일치 (5,000원)- " + prizeRanking.get("5등") + "개");
    System.out.println("4개 일치 (50,000원)- " + prizeRanking.get("4등") + "개");
    System.out.println("5개 일치 (1,500,000원)- "+ prizeRanking.get("3등") + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)-"+ prizeRanking.get("2등") + "개");
    System.out.println("6개 일치 (2,000,000,000원)- "+ prizeRanking.get("1등") + "개");

    System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
  }

}
