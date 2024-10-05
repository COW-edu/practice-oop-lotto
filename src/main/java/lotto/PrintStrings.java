package lotto;

import java.util.List;

public class PrintStrings {

  public static void printLottos (List<List<Integer>> saveLottos, int count){
    System.out.println("\n" + count + "개를 입력했습니다.");
    for (int i =0; i < saveLottos.size(); i++){
      System.out.println(saveLottos.get(i));
    }
  }
}
