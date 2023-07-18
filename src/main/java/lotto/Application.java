package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        //금액 입력 받기
        int inputPrice = inputPrice();
        //로또 답 입력 받기
        LottoAnswer lottoAnswer =lottoAnswer();
        //로또 생성하기
        List<Lotto> lottoList =lottoShop(inputPrice);
        LottoWallet lottoShop = new LottoWallet(lottoList);
        //생성한 로또 저장하기
        List<Lotto> CustomerLotto = lottoShop.getLottos(); //뭔가 클래스로 감싸서 전달하고 싶은데...
        LottoWallet lottoCustomer = new LottoWallet(CustomerLotto);
        //로또 계산하기
        LottoCalculator lottoCalculator = new LottoCalculator(lottoCustomer, lottoAnswer);
        List<Integer> lottoResult=lottoCalculator.getResult();
        //출력
        List<Integer> lottoWinPrice= Arrays.asList(5000, 50000, 1500000, 2000000000, 30000000);
        Customer customer = new Customer(lottoCustomer,lottoResult,lottoWinPrice);
        customer.Print();

        incomeCalculator(lottoWinPrice,lottoResult,inputPrice);
    }

    private static void incomeCalculator(List<Integer> lottoWinPriceInt, List<Integer> lottoResult, int inputPrice) {
        int expense=0;
        for(int i=0; i<lottoResult.size();i++){
            expense+=lottoWinPriceInt.get(i)*lottoResult.get(i);
        }
        double incomeRate=(1-(expense*1.0/inputPrice));
        incomeRate = Math.round(incomeRate*10)/10.0;

        System.out.println("총 수익률은 "+incomeRate*100+"% 입니다.");
    }
    public static int inputPrice(){
        System.out.println("금액을 입력하세요");
        int inputPrice = Integer.parseInt(Console.readLine());
        return inputPrice;
    }
    public static LottoAnswer lottoAnswer(){
        System.out.println("당첨 로또 번호를 입력하세요.");
        List<Integer> lottoAnswerList= new ArrayList<>();
        for(int i=0; i<6; i++){
            int number = Integer.parseInt(Console.readLine());
            lottoAnswerList.add(number);
        }
        int bonusNumber = Integer.parseInt(Console.readLine());

        LottoAnswer lottoAnswer = new LottoAnswer(lottoAnswerList,bonusNumber);
        //Enum 사용?
        return lottoAnswer;
    }
    public static List<Lotto> lottoShop(int inputPrice){
        int inputCount= inputPrice/1000;
        System.out.println(inputCount+"개 구매했습니다");
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<inputCount; i++) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(lottoNums);
            Lotto lotto = new Lotto(lottoNums);
            lottoList.add(lotto);
        }
        return lottoList;
    }
}