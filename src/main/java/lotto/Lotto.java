package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    // 번호를 저장할 수 있는 리스트 생성(ALL)
    public Lotto() {
    	this.numbers = new ArrayList<>();
    }

    // 사용자가 입력한 번호를 받는 생성자 (User)
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
  
    //일반 번호 6개 생성 (Lotto)
    public void generateRandomNumbers() {
        numbers.clear();
        numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
    
    // 보너스 번호 생성 (Lotto )
    private int generateBonusNumber() {
        int bonus;
        do {
            bonus = Randoms.pickNumberInRange(1, 45);
        } while (numbers.contains(bonus));
        return bonus;
    }
    
    //get
    public List<Integer> getNumbers() {
        return numbers;
    }
    
    public int getBonusNumber() {
        return bonusNumber;
    }
    
    //validate
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 로또 번호입니다.");
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
