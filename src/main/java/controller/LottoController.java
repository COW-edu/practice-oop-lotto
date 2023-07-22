package controller;

import message.RequestMessage;
import model.lotto.Lotto;
import model.lotto.LottoStore;
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
      enterCustomer(inputMoney());
      calculateProfitRate(inputWinLottoNumber(), inputBonusLottoNumber());
    } catch (IllegalArgumentException e) {
      output.outPutMessage(e.getMessage());
    }
  }

  private void enterCustomer(int payMoney) {
    lottoStore.enterCustomer(payMoney);
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

  private double calculateProfitRate(Lotto winLotto, int bonusNumber) {
    return lottoStore.calculateProfitRate(winLotto, bonusNumber);
  }


}
