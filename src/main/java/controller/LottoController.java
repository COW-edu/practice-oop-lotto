package controller;

import machine.CheckedEqualMachine;
import message.RequestMessage;
import model.lotto.Lotto;
import model.lotto.LottoStore;
import model.win.WinLottoResult;
import machine.ProfitCalculator;
import view.input.Input;
import view.output.Output;

public class LottoController {

  private final Output output;
  private final Input input;
  private final LottoStore lottoStore;
  private final CheckedEqualMachine checkedEqualMachine;
  private final ProfitCalculator profitCalculator;

  public LottoController(Output output, Input input, LottoStore lottoStore,
      CheckedEqualMachine checkedEqualMachine, ProfitCalculator profitCalculator) {
    this.output = output;
    this.input = input;
    this.lottoStore = lottoStore;
    this.checkedEqualMachine = checkedEqualMachine;
    this.profitCalculator = profitCalculator;
  }

  public void lottoRun() {
    try {
      createPayLottos(inputMoney());
      int[] equalWinCounts = checkEqualWinLotto(inputWinLottoNumber());
      boolean[] equalBonusCheck = checkEqualBonusNumber(inputBonusLottoNumber());
      WinLottoResult winLottoResult = createWinLottoResult(equalWinCounts, equalBonusCheck);
      profitRateCheck(winLottoResult, payMoney);
    } catch (IllegalArgumentException e) {
      output.outPutMessage(e.getMessage());
    }
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

  private WinLottoResult createWinLottoResult(int[] equalCounts, boolean[] bonusCounts) {
    return lottoStore.createWinLottoResult(equalCounts, bonusCounts);
  }

  private void profitRateCheck(WinLottoResult winLottoResult, int payMoney) {
    double profitRate = profitCalculator.profitRateCalculate(winLottoResult, payMoney);
    output.outPutLottoResult(profitRate, winLottoResult);
  }
  private void createPayLottos(int payMoney) {
    lottoStore.createPayLottos(payMoney);
  }

  private int[] checkEqualWinLotto(Lotto winLotto){
    return checkedEqualMachine.checkedWinLottoNumbers(winLotto);
  }
  private boolean[] checkEqualBonusNumber(int bonusNumber){
    return checkedEqualMachine.checkedBonusLottoNumbers(bonusNumber);
  }
}
