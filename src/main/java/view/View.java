package view;

import camp.nextstep.edu.missionutils.Console;
import global.Validator;
import model.Lotto;
import model.LottoRank;

import java.util.ArrayList;

public class View {

    public int inputLottoPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            Validator.validatePurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(input);
    }

    public int[] inputWinningNumbers() {
        System.out.print("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            Validator.validateWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        String[] splitNumbers = input.split(",");
        int[] winningNumbers = new int[6];

        for (int i = 0; i < splitNumbers.length; i++) {
            winningNumbers[i] = Integer.parseInt(splitNumbers[i].trim());
        }

        return winningNumbers;
    }

    public int inputBonusNumber(int[] winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            Validator.validateBonusNumber(input, winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return Integer.parseInt(input);
    }

    public void outputPurchaseLotto(int price, ArrayList<Lotto> lottos) {
        System.out.println(price/1000+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void outputWinningCount(LottoRank rank) {
        System.out.println(rank);
    }

    public void outputprofitRate(int price, int totalPrizeMoney) {
        double profitRate = (double) totalPrizeMoney / price * 100;
        profitRate = Math.round(profitRate * 100.0) / 100.0;
        System.out.println("총 수익률은 "+profitRate+"%입니다");
    }
}
