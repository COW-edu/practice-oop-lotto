package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        String numbers = sc.next();

    }


    // String 분리하여 배열에 저장하고 배열을 리턴하는 메서드
    private List<Integer> SplitNum(String numbers) {
        List<Integer> result = new ArrayList<>();

        String[] number = numbers.split(",");
        for (int i = 0; i < number.length; i++) {
            result.add(Integer.parseInt(number[i]));
        }

        return result;
    }


}
