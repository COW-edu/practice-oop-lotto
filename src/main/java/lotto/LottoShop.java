package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private List<Lotto> lottos= new ArrayList<>();
    private int lottoCount;
    public LottoShop(int inputPrice){
        this.lottoCount=calculateLottoCount(inputPrice);
        System.out.println(lottoCount+"개를 구매했습니다");
        createLottos();
    }
    public List<Lotto> getLottos(){
        return this.lottos;
    }
    public int calculateLottoCount(int inputPrice) {
        return inputPrice/1000;
    }
    public void createLottos(){
        for(int i=0; i<lottoCount; i++) {
            Lotto lotto = createLotto();
            this.lottos.add(lotto);
        }
    }
    public Lotto createLotto(){
        List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(lottoNums);
        return lotto;
    }



}
