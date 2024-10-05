package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static List<Integer> winningNumberList;

    public static int inputPlayerPrice() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputLottoWinningNum() {
        return numberList(Console.readLine());
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    //for문 서비스 쪽으로 옮겨야 함
    public static List<Integer> numberList(String winningNumber) {
        String[] result = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberList.add(conventToInt(result[i]));
        }
        return winningNumberList;
    }

    private static int conventToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
