package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoAnswer {

    private List<Integer> lottoAnswer=new ArrayList<>();
    private int bonusNum;
    public LottoAnswer(){
        ReceiveLottoAnswer();
    }
    public void ReceiveLottoAnswer(){
        for(int i=0; i<6; i++) {
            int number = Integer.parseInt(Console.readLine());
            this.lottoAnswer.add(number);
        }
        this.bonusNum=Integer.parseInt(Console.readLine());
        System.out.println(lottoAnswer);
    }
    public List<Integer> getLottoAnswer(){
        return lottoAnswer;
    };
    public int getBonusNum(){ return bonusNum; }
}
