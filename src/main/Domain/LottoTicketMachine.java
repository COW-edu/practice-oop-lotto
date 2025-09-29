package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LottoTicketMachine {
    private int lottoCount;

    public LottoTicketMachine(int money) {
        validate(money);
        this.lottoCount = money / 1000;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }


    public List<Integer> getRandomNum(){
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 45; i++){
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);    //1~45까지 무작위 섞기
        List<Integer> lottoNumbers = new ArrayList<>(numbers.subList(0, 6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public Lottos execute(){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++){
            List<Integer> numbers = getRandomNum();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

}
