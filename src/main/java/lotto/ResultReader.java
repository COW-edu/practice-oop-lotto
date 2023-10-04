package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultReader {
    private ArrayList<Lotto> lottoArrayList;
    private List<Integer> winningLottos;
    private List<Integer> countlist;
    private int[] totalResult;
    private Calculater calculater;
    public ResultReader(){
        countlist = new ArrayList<>();
        totalResult = new int[8];
        Arrays.fill(totalResult, 0);
        calculater = new Calculater();
    }
    public void produce (ArrayList<Lotto> lottoLists, List<Integer> winningLottos, int budget) {
        this.lottoArrayList = lottoLists;
        this.winningLottos = winningLottos;
        judge();
        reportResult();
        printResult();
        double RateOfReturn = calculater.calculate(totalResult,budget);
        System.out.println("총 수익률은 "+RateOfReturn+"%입니다."); // 이건 따로
    }

    private void printResult() {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+ totalResult[3] +"개");
        System.out.println("4개 일치 (50,000원) - "+ totalResult[4] +"개");
        System.out.println("5개 일치 (1,500,000원) "+ totalResult[5] +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ totalResult[7] +"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ totalResult[6] +"개");

    }

    public void judge(){
        for(Lotto lotto:lottoArrayList){
            countlist.add(rowCompare(lotto));
            }
        }
    public int rowCompare(Lotto lotto){
        int count=0;
        for(int i=0;i<6;i++){
            count+=countCheck(lotto, i);
        }
        if(count==5){
            count+=bonusCheck(lotto);
        }
        return count;
    }

    private int bonusCheck(Lotto lotto) {
        if(lotto.getNums().contains((winningLottos.get(6)))){
            return 2;
        }
        return 0;
    }

    private int countCheck(Lotto lotto, int i) {
        if(lotto.getNums().contains(winningLottos.get(i))) {
            return 1;
        }
        return 0;
    }

    private void reportResult(){
        for(Integer count:countlist){
            totalResult[count]+=1;
        }
    }

}
