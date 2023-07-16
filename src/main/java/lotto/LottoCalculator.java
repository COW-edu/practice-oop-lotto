package lotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Set;
public class LottoCalculator {
    private List<Lotto> customerLottos;
    private List<Integer> answerLotto;
    private List<Integer> customerResult=new ArrayList<>();
    private int bonus;
    public LottoCalculator(LottoWallet lottoWallet, LottoAnswer lottoAnswer) {
        this.customerLottos =lottoWallet.getLottoWallet();
        this.answerLotto=lottoAnswer.getLottoAnswer();
        this.bonus = lottoAnswer.getBonusNum();
        ReceiveValues();
    }
    public List<Integer> getResult(){
        return this.customerResult;
    }
    private void ReceiveValues(){
        List<Integer> customerLottoList=null;
        List<Integer> Result = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        for(int i = 0; i< customerLottos.size(); i++){
            Lotto customerLotto = customerLottos.get(i);
            customerLottoList=customerLotto.getLotto();
            Result=Calculate(customerLottoList,Result);
        }
        this.customerResult=Result;
    }
    private List<Integer> Calculate(List<Integer> customerLottoList,List<Integer> result) {
        List<Integer> testList = null;
        testList = Stream.of(answerLotto, customerLottoList)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        int beforeCount = testList.size();
        Set testSet = Set.copyOf(testList);
        int afterCount = testSet.size();
        int gap=beforeCount-afterCount;
        boolean bonusCheck= customerLottoList.contains(bonus);
        if (gap < 3) {
            return result;
        }
        result=ResultRecord(gap,bonusCheck,result);

        return result;
    }
    private List<Integer> ResultRecord(int gap,boolean bonusCheck,List<Integer> result) {
        result.set(gap-1, result.get(gap-1)+1);
        if(gap==5) {
                result=BonusRecord(result,bonusCheck);
            }
        return result;
    }
    private List<Integer> BonusRecord(List<Integer> result,boolean bonusCheck){
        if(bonusCheck){
            result.set(4,result.get(4)+1);
        }
        return result;
    }
}


