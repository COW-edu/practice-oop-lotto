package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 사용자로부터 번호 입력받음(당첨번호 + 보너스번호)
public class LottoInput {
  private static final int LOTTO_PRICE = 1000;

  private List<Integer> winningNumbers;
  private int bonusNumber;

  public LottoInput(List<Integer> winningNumbers, int bonusNumber) {
    this.winningNumbers = winningNumbers;
    this.bonusNumber = bonusNumber;
  }
  public static LottoInput askWinningDetails() {
    List<Integer> winningNumbers = askWinningNumbers();
    int bonusNumber = askBonusNumber();
    return new LottoInput(winningNumbers, bonusNumber);
  }
  public static int askMoney() {
    System.out.println("구입금액을 입력해 주세요.");

    String input = Console.readLine();
    int money;

    try {
      money = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 금액은 정수로 입력해주세요.");
    }

    if (money % 1000 != 0) {
      throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해주세요.");
    }

    return money;
  }

  public static int getLottoCount(int money) {
    int countLotto = money / LOTTO_PRICE;
    System.out.printf("%d개를 구매했습니다.", countLotto);
    System.out.println("");
    return countLotto;
  }

  public static List<Integer> askWinningNumbers() {
    System.out.println("당첨 번호를 입력해주세요.");
    String input = Console.readLine();
    List<Integer> winningNumbers = parseInputNumbers(input);

    if (winningNumbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
    }

    return winningNumbers;
  }

  public static int askBonusNumber() {
    System.out.println("보너스 번호를 입력해주세요.");
    try {
      return Integer.parseInt(Console.readLine());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수로 입력해주세요.");
    }
  }

  private static List<Integer> parseInputNumbers(String input) {
    try {
      return Arrays.stream(input.split(","))
          .map(String::trim)
          .map(Integer::parseInt)
          .collect(Collectors.toList());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 숫자 외의 값이 포함되어 있습니다.");
    }
  }

  public static Integer getBonus() {
    return askBonusNumber();
  }

  public List<Integer> getWinningNumbers() {
    return askWinningNumbers();
  }


}
