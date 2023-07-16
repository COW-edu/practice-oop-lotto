package lotto;
import java.util.List;

public class Customer {
        private LottoWallet lottoWallet;
        private List<Integer> lottoResult;

        public Customer(LottoWallet lottoWallet, List<Integer> lottoResult){
            this.lottoWallet = lottoWallet;
            this.lottoResult = lottoResult;
            Print();
        }
        public void Print(){
            for(int i=0 ;i<lottoResult.size(); i++){
                System.out.println(i+3+"개일치"+lottoResult.get(i));
            }
        }

}
