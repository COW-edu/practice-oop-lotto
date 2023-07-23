package view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import message.ErrorMessage;
import model.lotto.LottoData;

public class InputImpl implements Input {

  private List<Integer> winLottoNumberList;

  @Override
  public int inputMoney() throws IllegalArgumentException {
    String inputMoney = Console.readLine();
    validateInteger(inputMoney);
    validateUnit(inputMoney);
    return Integer.parseInt(inputMoney);
  }

  @Override
  public List<Integer> inputWinNumber() throws IllegalArgumentException {
    String inputWinLottoNumber = Console.readLine();
    String[] winLottoNumbers = inputWinLottoNumber.split(LottoData.SPLIT_LETTER);
    winLottoNumberList = stringToIntList(winLottoNumbers);
    return winLottoNumberList;
  }

  @Override
  public int inputBonusNumber() throws IllegalArgumentException {
    String inputBonusLottoNumber = Console.readLine();
    validateInteger(inputBonusLottoNumber);
    validateRangeNumber(inputBonusLottoNumber);
    validateDuplicated(inputBonusLottoNumber);
    return Integer.parseInt(inputBonusLottoNumber);
  }

  private List<Integer> stringToIntList(String[] winLottoNumbers) {
    List<Integer> winLottoNumberList = new ArrayList<>();
    Arrays.stream(winLottoNumbers).mapToInt(Integer::parseInt).forEach(winLottoNumberList::add);
    return winLottoNumberList;
  }

  private void validateUnit(String inputMoney) throws IllegalArgumentException {
    if (Integer.parseInt(inputMoney) % LottoData.LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(ErrorMessage.NOT_THOUSANDONE);
    }
  }

  private void validateInteger(String inputMoney) throws IllegalArgumentException {
    String regex = "^[0-9]*$";
    if (!inputMoney.matches(regex)) {
      throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
    }
  }

  private void validateDuplicated(String inputBonusLottoNumber) throws IllegalArgumentException {
    int bonusNumber = Integer.parseInt(inputBonusLottoNumber);
    if (winLottoNumberList.stream()
        .anyMatch(winLottoNumber -> winLottoNumber.equals(bonusNumber))) {
      throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUSNUMBER);
    }
  }

  private void validateRangeNumber(String inputBonusLottoNumber) throws IllegalArgumentException {
    int bonusNumber = Integer.parseInt(inputBonusLottoNumber);
    if (bonusNumber < LottoData.START_LOTTO_NUMBER || bonusNumber > LottoData.END_LOTTO_NUMBER) {
      throw new IllegalArgumentException(ErrorMessage.NOT_EXACT_RANGE_NUMBER);
    }
  }

}
