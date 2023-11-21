package Service;

import java.util.List;

import static Entity.Money.LOTTO_PRICE;
import static Service.LottoFactory.*;

public class Validator {
    public static void validateSize(List<Integer> numbers){
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }
    }
    public static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < LOTTO_NUMBER_MINIMUM || num > LOTTO_NUMBER_MAXIMUM)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateDuplicate(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 포함되어 있습니다");
        }
    }

    public static void validateMoney(String money) {
        try{
            Integer.parseInt(money);
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        if(Integer.parseInt(money)%LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 입력한 금액은 1000원 단위여야 합니다.");
        }
    }
    public static void validateBonus(String bonusNum){
        try {
            int bonus = Integer.parseInt(bonusNum);
            if (bonus < LOTTO_NUMBER_MINIMUM || bonus > LOTTO_NUMBER_MAXIMUM) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 숫자로 입력해야 합니다.");
        }
    }
}
