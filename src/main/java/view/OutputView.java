package view;

import model.Lotto;
import java.util.List;

public class OutputView {

    public static void printLottos(int count, List<List<Integer>> lottoNumbers) {
        System.out.println(count + "개를 구매했습니다.");
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }
}
