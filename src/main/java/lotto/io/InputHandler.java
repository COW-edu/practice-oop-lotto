package lotto.io;

import java.util.Scanner;
import lotto.error.ErrorCheckingAndParsing;

public class InputHandler {

  int price = 0;
  static Scanner scanner = new Scanner(System.in);

  public void getPrice(){
    System.out.println("구입 금액을 입력해 주세요.");

    String lottoPrice = scanner.nextLine();
    price = ErrorCheckingAndParsing.isNum(lottoPrice);
  }

  public int getInputPrice() {
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
