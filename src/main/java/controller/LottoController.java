package controller;

import java.util.List;
import message.RequestMessage;
import model.lotto.Lotto;
import model.lotto.LottoStore;
import model.lotto.PayLottos;
import model.win.WinLottoResult;
import view.input.Input;
import view.output.Output;

public class LottoController {

  private final Output output;
  private final Input input;
  private final LottoStore lottoStore;

  public LottoController(Output output, Input input, LottoStore lottoStore) {
    this.output = output;
    this.input = input;
    this.lottoStore = lottoStore;
  }

  public void lottoRun() {
    try {
      createPayLottos(inputMoney());
      List<Integer> equalWinCounts = countEqualWinLotto(inputWinLottoNumber());
      List<Boolean> equalBonusCheck = checkEqualBonusNumber(inputBonusLottoNumber());
      createWinLottoResult(equalWinCounts, equalBonusCheck);
      profitRateCheck(winLottoResult, payMoney);
    } catch (IllegalArgumentException e) {
      output.outPutMessage(e.getMessage());
    }
  }
  private void createPayLottos(int payMoney) {
    lottoStore.createPayLottos(payMoney);
  }

  private int inputMoney() throws IllegalArgumentException {
    output.outPutMessage(RequestMessage.BUY_INPUT_MONEY);
    return input.inputMoney();
  }

  private Lotto inputWinLottoNumber() throws IllegalArgumentException {
    output.outPutMessage(RequestMessage.INPUT_WIN_NUMBER);
    return input.inputWinNumber();
  }

  private int inputBonusLottoNumber() throws IllegalArgumentException {
    output.outPutMessage(RequestMessage.INPUT_BONUS_NUMBER);
    return input.inputBonusNumber();
  }

  private List<Integer> countEqualWinLotto(Lotto winLotto) {
    return lottoStore.getEqualWinCounts(winLotto);
  }

  private List<Boolean> checkEqualBonusNumber(int bonusNumber) {
    return lottoStore.getEqualBonusNumber(bonusNumber);
  }

  private WinLottoResult createWinLottoResult(int[] equalWinCounts, boolean[] equalBonusCheck) {
    return lottoStore.createWinLottoResult(equalWinCounts, equalBonusCheck);
  }

  private void profitRateCheck(WinLottoResult winLottoResult, int payMoney) {
    double profitRate = profitCalculator.profitRateCalculate(winLottoResult, payMoney);
    output.outPutLottoResult(profitRate, winLottoResult);
  }




}
