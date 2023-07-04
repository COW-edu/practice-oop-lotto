package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int price = Integer.parseInt(Console.readLine());

        List<Integer> numbers = new ArrayList<>();

        for(int i=0; i<5; i++){
            int number = Integer.parseInt(Console.readLine());
            numbers.add(number);
        }

        int bonusNum = Integer.parseInt(Console.readLine());
        

    }
}
