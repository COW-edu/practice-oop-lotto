package lotto.View;


import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputHandler {
    Scanner sc = new Scanner(System.in);

    public int getPurchasingMoney(){
        System.out.println("구입 금액을 입력해주세요");
        int purchasingMoney = sc.nextInt();
        if((purchasingMoney%1000)!=0){
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하셨습니다.");
        }
        return purchasingMoney;
    }
    public String getWinningNumber(){
        System.out.println("당첨 번호를 입력해주세요");
        sc.nextLine();
        return sc.nextLine();
    }
    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        try{
            int bonusNumber = sc.nextInt();
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하셨습니다.");
            }
            return bonusNumber;
        }catch(NumberFormatException e){
            throw new NumberFormatException("[ERROR] 잘못된 값을 입력하셨습니다.");
        }
    }
}
