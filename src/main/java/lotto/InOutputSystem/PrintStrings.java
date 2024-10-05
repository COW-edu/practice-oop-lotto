package lotto.InOutputSystem;

import java.util.List;
import java.util.Map;

public class PrintStrings {

  public static void printLottos (List<List<Integer>> saveLottos, int count){
    System.out.println("\n" + count + "개를 입력했습니다.");
    for (int i =0; i < saveLottos.size(); i++){
      System.out.println(saveLottos.get(i));
    }
  }

  public static void lottoResult(Map<String, Integer> prizeMap, double profit){
    System.out.println("\n당첨 통계");
    System.out.println("---------");

    System.out.println("3개 일치 (5,000원)- " + prizeMap.get("5등") + "개");
    System.out.println("4개 일치 (50,000원)- " + prizeMap.get("4등") + "개");
    System.out.println("5개 일치 (1,500,000원)- "+ prizeMap.get("3등") + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)-"+ prizeMap.get("2등") + "개");
    System.out.println("6개 일치 (2,000,000,000원)- "+ prizeMap.get("1등") + "개");

    System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
  }
}
