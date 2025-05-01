package lotto.Model;

import lotto.Exception.ErrorMessage;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicationValidate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTOSIZE.getMessage());
        }
    }

    private void duplicationValidate(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++){
            int target = numbers.get(i);
            for(int j=0; j<numbers.size(); j++){
                if(target == numbers.get(j) && i != j){
                    throw  new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
                }
            }
        }
    }
}
