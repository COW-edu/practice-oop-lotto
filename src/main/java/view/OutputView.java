package view;

import model.LottoNumber;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printPurchaseCount(int purchaseAmount){
        System.out.println("\n"+purchaseAmount+"개를 구매했습니다.");
    }

    public void printLottoNumbers(List<LottoNumber> lottoNumbers){
        for(LottoNumber lottoNumber : lottoNumbers){
            System.out.println(lottoNumber.getNumbers());
        }
    }

    public void printWinningResult(Map<String, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("-------------------");
        result.forEach((key, value) -> System.out.println(key + " - " + value + "개"));
    }
}
