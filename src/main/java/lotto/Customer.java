package lotto;
import java.util.List;
public class Customer {
        private LottoWallet lottoWallet;
        private List<Integer> lottoResult;
        private List<Integer> lottoWinPrice;

        public Customer(LottoWallet lottoWallet, List<Integer> lottoResult, List<Integer> lottoWinPrice){
            this.lottoWallet = lottoWallet;
            this.lottoResult = lottoResult;
            this.lottoWinPrice = lottoWinPrice;
        }
        public void Print(){
            int UntilBonus=lottoResult.size()-1;
            for(int i=0 ;i<UntilBonus; i++){
                System.out.println(i+3+"개 일치 ("+lottoWinPrice.get(i)+"원) - "+lottoResult.get(i)+"개");
            }
            System.out.println("5개 일치, 보너스 볼 일치 ("+lottoWinPrice.get(4)+"원) - "+lottoResult.get(4)+"개");
            System.out.println("6개 일치, ("+lottoWinPrice.get(3)+"원) - "+lottoResult.get(3)+"개");
        }

}
