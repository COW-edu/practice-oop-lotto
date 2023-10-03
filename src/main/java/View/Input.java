package View;
import camp.nextstep.edu.missionutils.Console;


public class Input{

    public String InputMoney(){
        System.out.println("금액을 입력하시오: ");
        return Console.readLine();
    }

    public String InputLottoNums(){
        System.out.println("로또 번호를 입력하시오(1~45): ");
        return Console.readLine();
    }

    public String InputBonus(){
        System.out.println("보너스 번호를 입력하시오(1~45): ");
        return Console.readLine();
    }
}
