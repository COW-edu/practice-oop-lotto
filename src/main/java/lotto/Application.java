package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int price = receivePrice();

        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<5; i++){
            int number = Integer.parseInt(Console.readLine());
            numbers.add(number);
        }
        int bonusNum = Integer.parseInt(Console.readLine());
        Lotto lotto = new Lotto(numbers);

        List<List<Integer>> usernum =new ArrayList<List<Integer>>();
        for(int i=0; i<price; i++) {
            usernum.add(create());
        }

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
