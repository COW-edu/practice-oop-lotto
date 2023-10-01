package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Input{

    public String InputMoney(){
        System.out.println("금액을 입력하시오: ");
        return Console.readLine();
    }

    public List<Integer> InputLottoNums(){
        System.out.println("로또 번호를 입력하시오(1~45): ");
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> InputBonus(){
        System.out.println("보너스 번호를 입력하시오(1~45): ");
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
