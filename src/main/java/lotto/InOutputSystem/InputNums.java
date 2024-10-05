package lotto.InOutputSystem;

import java.util.Scanner;
import lotto.manageError.CheckError;

public class InputNums {
  static Scanner scanner = new Scanner(System.in);

  public static int price(){
    System.out.println("구입금액을 입력해 주세요.");
    String lottoPrice = scanner.nextLine();
    int intPrice = CheckError.isNum(lottoPrice);
    return intPrice;
  }

  public static String winningNums() {
    System.out.println("\n당첨 번호를 입력해 주세요.");
    String winningNums = scanner.nextLine();
    return winningNums;
  }

  public static int bonusNum(){
    System.out.println("\n보너스 번호를 입력해 주세요.");
    int bonusNum = scanner.nextInt();
    CheckError.numRange(bonusNum);
    return bonusNum;
  }
}
