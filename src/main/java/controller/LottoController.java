package controller;

import machine.CheckedEqualMachine;
import message.RequestMessage;
import model.lotto.LottoStore;
import model.lotto.PayLottosData;
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
      PayLottosData payLottosData = lottoStore.makePayLottosData();
      storedDataForMethod(payLottosData);
      int payMoney = inputMoney(payLottosData);
      int[] equalCounts = inputWinLottoNumber();
      boolean[] bonusCounts = inputBonusLottoNumber();
      WinLottoResult winLottoResult = makeWinLottoResult(equalCounts, bonusCounts);
      profitRateCheck(winLottoResult, payMoney);
    } catch (IllegalArgumentException e) {
      output.outPutMessage(e.getMessage());
    }
  }

  public void storedDataForMethod(PayLottosData payLottosData) {
    checkedEqualMachine.storedData(payLottosData);
  }

  private int inputMoney(PayLottosData payLottosData) throws IllegalArgumentException {
    output.outPutMessage(RequestMessage.BUY_INPUT_MONEY);
    int payMoney = input.inputMoney();
    payLottosData.makeLottoData(payMoney);
    output.outPutBuyLotto(payLottosData);
    return payMoney;
  }

  private int[] inputWinLottoNumber() throws IllegalArgumentException {
    output.outPutMessage(RequestMessage.INPUT_WIN_NUMBER);
    return checkedEqualMachine.checkedWinLottoNumbers(input.inputWinNumber());
  }

  private boolean[] inputBonusLottoNumber() throws IllegalArgumentException {
    output.outPutMessage(RequestMessage.INPUT_BONUS_NUMBER);
    return checkedEqualMachine.checkedBonusLottoNumbers(input.inputBonusNumber());

  }

  private WinLottoResult makeWinLottoResult(int[] equalCounts, boolean[] bonusCounts) {
    return lottoStore.makeWinLottoResult(equalCounts, bonusCounts);
  }

  private void profitRateCheck(WinLottoResult winLottoResult, int payMoney) {
    double profitRate = profitCalculator.profitRateCalculate(winLottoResult, payMoney);
    output.outPutLottoResult(profitRate, winLottoResult);
  }
}
