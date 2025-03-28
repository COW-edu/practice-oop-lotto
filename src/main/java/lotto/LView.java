package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LView {

    public int inputLottoPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.print("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        String[] splitNumbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String num : splitNumbers) {
            winningNumbers.add(Integer.parseInt(num.trim()));
        }

        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void outputPurchaseLotto(int price, ArrayList<Lotto> lottos) {
        System.out.println(price/1000+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
