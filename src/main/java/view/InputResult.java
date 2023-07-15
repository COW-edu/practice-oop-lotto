package view;

import model.LottosData;
import model.WinData;
import model.WinLottoCount;

public class InputResult {
    private final LottosData lottsData;
    private final WinData winData;


    public InputResult(LottosData lottsData, WinData winData) {
        this.lottsData = lottsData;
        this.winData = winData;
    }

    public void lottoNumberResult() {
        System.out.println("\n"+lottsData.getCountOfLotto()+"개를 구매했습니다.");
        System.out.println(lottsData.getLottosResult());
    }

    public void goalResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) -"+winData.getWinCountResult().get(WinLottoCount.threeCount.getCount())+"개");
        System.out.println("4개 일치 (50,000원) -"+winData.getWinCountResult().get(WinLottoCount.fourCount.getCount())+"개");
        System.out.println("5개 일치 (1,500,000원) -"+winData.getWinCountResult().get(WinLottoCount.fiveCount.getCount())+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -"+winData.getWinCountResult().get(WinLottoCount.fiveBonusCount.getCount())+"개");
        System.out.println("6개 일치 (2,000,000,000원) -"+winData.getWinCountResult().get(WinLottoCount.sixCount.getCount())+"개");
    }

    public void profitRateResult(){
        System.out.println("총 수익률은 "+winData.getProfitRateSecondPoint()+"%입니다.");
    }

}
