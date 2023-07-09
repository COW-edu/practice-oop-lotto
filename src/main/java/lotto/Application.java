package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("금액을 입력해주세요");
        int price = receivePrice();
        System.out.println("로또 개수:"+price);


        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<6; i++){
            System.out.println((i+1)+"번째 로또 당첨 번호를 입력해주세요");
            int number = Integer.parseInt(Console.readLine());
            numbers.add(number);
        }
        System.out.println("로또 당첨 번호는" +numbers+"입니다.");
        System.out.println("보너스 당첨 번호를 입력해주세요");
        int bonusNum = Integer.parseInt(Console.readLine());
        System.out.println("보너스 당첨 번호는" +bonusNum+"입니다.");
        Lotto lotto = new Lotto(numbers);

        List<List<Integer>> userNum =new ArrayList<>();
        for(int i=0; i<price; i++) {
            userNum.add(create());
        }
        System.out.println("발행한 로또 번호입니다\n"+userNum);
    }
    private static int receivePrice(){
        int price = Integer.parseInt(Console.readLine());
        if(price%1000!=0){
            throw new IllegalArgumentException();
        }
        if(price<0){
            System.out.println("다시 입력해주세요");
            price = Integer.parseInt(Console.readLine());
        }
        price=price/1000;
        return price;
    }
    private static List<Integer> create(){
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

}
