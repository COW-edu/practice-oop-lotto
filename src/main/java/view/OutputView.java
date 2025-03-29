package view;

import model.LottoNumbers;

import java.util.List;

public class OutputView {
    public void printPurchaseCount(int purchaseAmount){
        System.out.println("\n"+purchaseAmount+"개를 구매했습니다.");
    }

    public void printLottoNumbers(List<LottoNumbers> lottoNumbers){
        for(LottoNumbers lottoNumber : lottoNumbers){
            System.out.println(lottoNumber.getNumbers());
        }
    }
}
