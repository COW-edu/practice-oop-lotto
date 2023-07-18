package lotto;
import java.util.ArrayList;
import java.util.List;
public class LottoAnswer {

    private List<Integer> lottoAnswer=new ArrayList<>();
    private int bonusNum;
    public LottoAnswer(List<Integer>lottoAnswer, int bonusNum){
        this.lottoAnswer = lottoAnswer;
        this.bonusNum = bonusNum;
    }
    public List<Integer> getLottoAnswer(){
        return lottoAnswer;
    };
    public int getBonusNum(){ return bonusNum; }
}
