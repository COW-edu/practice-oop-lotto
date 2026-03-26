package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        Check checkMoney = new CheckMoney();

        int num = sc.nextInt();

        if (!checkMoney.checkNum(num)) {
            throw new IllegalArgumentException();
        }
        int count = (num % 1000);
    }


}
