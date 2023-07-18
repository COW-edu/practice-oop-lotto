package lotto;
import java.util.ArrayList;
import java.util.List;
public class LottoWallet {
    private List<Lotto> lottos= new ArrayList<>();
    public LottoWallet(List<Lotto> lottos){
        this.lottos= lottos;
    }
    public List<Lotto> getLottos(){
        return this.lottos;
    }





}
