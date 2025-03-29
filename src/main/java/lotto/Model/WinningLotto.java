package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void setFirstNumbers(String firstNumber){
        for(int part : cutNumbers(firstNumber)){
            winningNumbers.add(part);
        }
    }
    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }
    public ArrayList<Integer> cutNumbers(String firstNumber){
        ArrayList<Integer> firstNumbers = new ArrayList<>();
        for(String part : firstNumber.split(",")){
            firstNumbers.add(Integer.valueOf(part));
        }
        return firstNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
