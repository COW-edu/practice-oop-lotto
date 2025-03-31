package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    //구매금액
    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    //당첨번호
    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseNumbers(input);
    }

    //보너스 번호
    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    //문자열 정수 변환
    private static List<Integer> parseNumbers(String number) {
        List<Integer> numbers = new ArrayList<>();
        String[] numberStrings = number.split(",");
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }
        return numbers;
    }
}
