package lotto.io;

import java.util.Scanner;
import lotto.error.ErrorCheckingAndParsing;

public class InputHandler {

  static Scanner scanner = new Scanner(System.in);

  public int getPrice(){
    System.out.println("구입 금액을 입력해 주세요.");

    String lottoPrice = scanner.nextLine();
    int price = ErrorCheckingAndParsing.isNum(lottoPrice);

    return price;
  }

  public String getWinNums() {
    System.out.println("\n당첨 번호를 입력해 주세요.");

    String winNumbers = scanner.nextLine();

    return winNumbers;
  }

  public int getBonusNum(){
    System.out.println("\n보너스 번호를 입력해 주세요.");
    int bonusNumber = scanner.nextInt();

    ErrorCheckingAndParsing.confirmNumRange(bonusNumber);

    return bonusNumber;
  }

}
