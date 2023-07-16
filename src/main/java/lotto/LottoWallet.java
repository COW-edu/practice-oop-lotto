package lotto;
import java.util.List;

public class LottoWallet {
    private List<Lotto> lottos;
    public LottoWallet(List<Lotto> lottos){
        this.lottos=lottos;
    }
    public List<Lotto> getLottoWallet(){
        return this.lottos;
    }



}
