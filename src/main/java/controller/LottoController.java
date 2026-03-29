package controller;

import domain.Amount;
import domain.Lotto;
import domain.BonusNumber;
import view.UserInput;

public class LottoController {
    public void run(){
        try{
            UserInput userInput = new UserInput();
            int lottoCount = new Amount(userInput.PurchaseAmount()).getLottoCount();

            System.out.println();
            System.out.println(lottoCount + "개를 구매했습니다.");
            //[x] 구입 금액에 해당하는 로또 수량을 생성한다.
            for(int i = 0; i < lottoCount; i++){
                Lotto lotto = Lotto.Random();
                System.out.println(lotto);
            }



        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
