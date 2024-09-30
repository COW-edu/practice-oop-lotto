package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //LottoMaker lottoMaker = new LottoMaker();
        //System.out.println(lottoMaker.getLottoNum());


        LottoRepository repository = new LottoRepository();
        System.out.println(repository.getLottoSaved());
        run();
        //System.out.println(repository.getLottoSaved());
        // TODO: 프로그램 구현
    }

    private static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = sc.nextInt();
        System.out.println((amount / 1000) + "개를 구매했습니다.");
    }
}
