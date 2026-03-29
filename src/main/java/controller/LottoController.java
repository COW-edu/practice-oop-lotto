package controller;

import domain.Amount;
import domain.Lotto;
import domain.BonusNumber;
import domain.Result;
import enums.Rank;
import view.UserInput;

import java.util.ArrayList;
import java.util.List;

//[x] 구입 금액에 해당하는 로또 수량을 생성한다.

public class LottoController {
    public void run(){
        try{
            UserInput userInput = new UserInput();
            int lottoCount = new Amount(userInput.PurchaseAmount()).getLottoCount();

            System.out.println();
            System.out.println(lottoCount + "개를 구매했습니다.");

            // 구매한 로또 저장
            List<Lotto> purchasedLottos = new ArrayList<>();
            for(int i = 0; i < lottoCount; i++){
                Lotto lotto = Lotto.Random();
                purchasedLottos.add(lotto);
                System.out.println(lotto);
            }


            Lotto winLotto = new Lotto(userInput.WinningNumbers());
            BonusNumber bonusNumber = new BonusNumber(userInput.BonusNumbers(), winLotto);

            Result result = new Result(purchasedLottos, winLotto, bonusNumber);

            System.out.println();
            System.out.println("당첨 통계");
            System.out.println("---");
            System.out.println(Rank.FIFTH.getDisplayString() + result.getCount(Rank.FIFTH) + "개");
            System.out.println(Rank.FOURTH.getDisplayString() + result.getCount(Rank.FOURTH) + "개");
            System.out.println(Rank.THIRD.getDisplayString() + result.getCount(Rank.THIRD) + "개");
            System.out.println(Rank.SECOND.getDisplayString() + result.getCount(Rank.SECOND) + "개");
            System.out.println(Rank.FIRST.getDisplayString() + result.getCount(Rank.FIRST) + "개");

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
