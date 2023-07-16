package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //금액 입력 받기
        System.out.println("금액을 입력하세요");
        int inputPrice = Integer.parseInt(Console.readLine());
        //로또 답 입력 받기
        System.out.println("당첨 로또 번호를 입력하세요.");
        LottoAnswer lottoAnswer = new LottoAnswer();
        //로또 생성하기
        LottoShop lottoShop = new LottoShop(inputPrice);
        //생성한 로또 저장하기
        List<Lotto> CustomerLotto = lottoShop.getLottos(); //뭔가 클래스로 감싸서 전달하고 싶은데...
        LottoWallet lottoWallet = new LottoWallet(CustomerLotto);
        //로또 계산하기
        LottoCalculator lottoCalculator = new LottoCalculator(lottoWallet, lottoAnswer);
        List<Integer> lottoResult=lottoCalculator.getResult();
        //출력
        Customer customer = new Customer(lottoWallet,lottoResult);

    }
}