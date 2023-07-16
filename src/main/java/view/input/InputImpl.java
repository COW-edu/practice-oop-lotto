package view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import message.ErrorMessage;
import model.lotto.Lotto;
import model.lotto.LottosData;

public class InputImpl implements Input{

  private  List<Integer> winLottoNumberList;
  @Override
  public int inputMoney()throws IllegalArgumentException {
    String inputMoney = Console.readLine();
    validateInteger(inputMoney);
    validateThousandOne(inputMoney);
    return Integer.parseInt(inputMoney);
  }

  @Override
  public Lotto inputWinNumber() throws IllegalArgumentException {
    String inputWinLottoNumber = Console.readLine();
    String[] winLottoNumbers = inputWinLottoNumber.split(",");
    winLottoNumberList = stringToIntList(winLottoNumbers);
    validateCountLottoNum(winLottoNumberList);
    validateRangeNumber(winLottoNumberList);
    validateDuplicated(winLottoNumberList);
    return new Lotto(winLottoNumberList);
  }

  @Override
  public int inputBonusNumber()throws IllegalArgumentException {
    String inputBonusLottoNumber = Console.readLine();
    validateInteger(inputBonusLottoNumber);
    validateRangeNumber(inputBonusLottoNumber);
    validateDuplicated(inputBonusLottoNumber);
    return Integer.parseInt(inputBonusLottoNumber);
  }

  private List<Integer> stringToIntList(String[] winLottoNumbers){
    List<Integer> winLottoNumberList = new ArrayList<>();
    Arrays.stream(winLottoNumbers)
        .mapToInt(Integer::parseInt)
        .forEach(winLottoNumberList::add);
    return winLottoNumberList;
  }

  private void validateThousandOne(String inputMoney)throws IllegalArgumentException {
    if(Integer.parseInt(inputMoney)% LottosData.LOTTO_PRICE !=0){
      throw new IllegalArgumentException(ErrorMessage.NOT_THOUSANDONE);
    }
  }

  private void validateInteger(String inputMoney)throws IllegalArgumentException {
    String regex = "^[0-9]*$";
    if(!inputMoney.matches(regex)){
      throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
    }
  }

  private void validateCountLottoNum(List<Integer> numbers)throws IllegalArgumentException{
    if (numbers.size() != 6) {
      throw new IllegalArgumentException(ErrorMessage.NOT_EXACT_COUNT_NUMBER);
    }
  }

  private void validateDuplicated(String inputBonusLottoNumber)throws IllegalArgumentException {
    int bonusNumber = Integer.parseInt(inputBonusLottoNumber);
    if(winLottoNumberList.stream().anyMatch(winLottoNumber->winLottoNumber.equals(bonusNumber))){
      throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUSNUMBER);
    }
  }
  private void validateDuplicated(List<Integer> winNumberList)throws IllegalArgumentException {
    if(winNumberList.size()!= winNumberList.stream().distinct().count()){
      throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNUMBER);
    }
  }

  private void validateRangeNumber(String inputBonusLottoNumber)throws IllegalArgumentException {
    int bonusNumber = Integer.parseInt(inputBonusLottoNumber);
    if(bonusNumber<1||bonusNumber>45){
      throw new IllegalArgumentException(ErrorMessage.NOT_EXACT_RANGE_NUMBER);
    }
  }
  private void validateRangeNumber(List<Integer> winLottoList)throws IllegalArgumentException {
    for(int number : winLottoList) {
      if (number < 1 || number > 45) {
        throw new IllegalArgumentException(ErrorMessage.NOT_EXACT_RANGE_NUMBER);
      }
    }
  }
}
