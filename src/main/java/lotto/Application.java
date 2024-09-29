package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.mockito.internal.stubbing.defaultanswers.ReturnsSmartNulls;

public class Application {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        int buyCost = scanner.nextInt();

        try {
            if (buyCost % 1000 != 0) {
                throw new IllegalArgumentException("[Error] 잔돈이 남았습니다. 잔돈은 드리지 않으니 다시 시작 후 정확히 입력하십시오.");
            }
            System.out.println("\n"+(buyCost / 1000) + "개를 구매했습니다.");
        } catch (IllegalAccessError e) {
            System.out.println(e.getMessage());
            return;
        }

        for (int i=0; i < (buyCost / 1000); i++){
            List<Integer> selectedLottoList = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(selectedLottoList);
            System.out.println(selectedLottoList);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        String inputWinningNum = scanner.nextLine();
        List<String> inputWinningNumList= List.of(inputWinningNum.split(","));
        System.out.println(inputWinningNumList);

//        for (int i = 0; i < inputWinningNumList.size(); i++){
//            List<Integer> winningLottoList = Randoms.pickUniqueNumbersInRange(1,45,6);
//            if (inputWinningNumList.get(i).equals("1")){
//
//            } else if (inputWinningNumList.get(i).equals("2")) {
//
//            }else if (inputWinningNumList.get(i).equals("3")) {
//
//            }else if (inputWinningNumList.get(i).equals("4")) {
//
//            }else if (inputWinningNumList.get(i).equals("5")) {
//
//            }else if (inputWinningNumList.get(i).equals("6")) {
//
//            }}
        }
}
