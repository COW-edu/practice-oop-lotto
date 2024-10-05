package lotto;

import java.util.List;

public class PrintStrings {

  public static void printLottos (List<List<Integer>> saveLottos, int count){
    System.out.println("\n" + count + "개를 입력했습니다.");
    for (int i =0; i < saveLottos.size(); i++){
      System.out.println(saveLottos.get(i));
    }
  }

  public static void lottoResult(){
    System.out.println("\n당첨 통계");
    System.out.println("---------");

    System.out.println("3개 일치 (5,000원)- 0개");
    System.out.println("4개 일치 (50,000원)- 0개");
    System.out.println("5개 일치 (1,500,000원)- 0개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)- 0개");
    System.out.println("6개 일치 (2,000,000,000원)- 0개");

    System.out.println("총 수익률은 0%입니다.");
  }
}
