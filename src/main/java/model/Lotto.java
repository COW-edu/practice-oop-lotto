package model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers)  {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkCountLottoNum(numbers);
        checkExactLottoNum(numbers);
    }
    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkCountLottoNum(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 6개여야만 합니다.");
        }
    }

    private void checkExactLottoNum(List<Integer> numbers) {
        for(int number : numbers){
            if(number<1||number>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45내의 범위여야만 합니다.");
            }
        }
    }
}
