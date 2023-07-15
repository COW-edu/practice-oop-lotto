package view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import model.Lotto;

public class InputImpl implements Input{


  @Override
  public int inputMoney() {
    String inputMoney = Console.readLine();
    return Integer.parseInt(inputMoney);
  }

  @Override
  public Lotto inputWinNumber() {
    String inputWinLottoNumber = Console.readLine();
    String[] stWinLottoNumbers = inputWinLottoNumber.split(",");
    return new Lotto(stringToIntList(stWinLottoNumbers));
  }

  @Override
  public int inputBonusNumber() {
    String inputBonusLottoNumber = Console.readLine();
    return Integer.parseInt(inputBonusLottoNumber);
  }
  private List<Integer> stringToIntList(String[] winLottoNumbers){
    List<Integer> winlottonumbers = new ArrayList<>();
    for (String winLottoNumber : winLottoNumbers) {
      winlottonumbers.add(Integer.parseInt(winLottoNumber));
    }
    return winlottonumbers;
  }
}
