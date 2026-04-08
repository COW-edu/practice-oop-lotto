package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    private final int count;
    private final List<List<Integer>> listLotto = new ArrayList<>();
    private final RandomLotto randomLotto = new RandomLotto();

    // 구입 금액으로 랜덤 로또 생성
    public Lotto(int money) {
        this.count = money / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            listLotto.add(randomLotto.generate());
        }
    }

    // 당첨 번호용 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.count = 0;
        this.listLotto.add(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public int getCount() {
        return count;
    }

    public List<List<Integer>> getListLotto() {
        return listLotto;
    }
}