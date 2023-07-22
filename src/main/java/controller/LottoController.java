package controller;

import java.util.List;
import java.util.Map;
import message.RequestMessage;
import model.customer.Customer;
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
      Customer customer = enterCustomer(inputMoney());
      printPurchasedLottos(customer);
      Map<String, Integer> winLottoResult = createWinLottoResult(inputWinLottoNumber(),
          inputBonusLottoNumber());
      double profitRate = calculateProfitRate(winLottoResult);
      printResult(winLottoResult, profitRate);
    } catch (IllegalArgumentException e) {
      output.outPutMessage(e.getMessage());
    }
  }

  private Customer enterCustomer(int payMoney) {
    return lottoStore.enterCustomer(payMoney);
  }

  private int inputMoney() throws IllegalArgumentException {
    output.outPutMessage(RequestMessage.BUY_INPUT_MONEY);
    return input.inputMoney();
  }

  private List<Integer> inputWinLottoNumber() throws IllegalArgumentException {
    output.outPutMessage(RequestMessage.INPUT_WIN_NUMBER);
    return input.inputWinNumber();
  }

  private int inputBonusLottoNumber() throws IllegalArgumentException {
    output.outPutMessage(RequestMessage.INPUT_BONUS_NUMBER);
    return input.inputBonusNumber();
  }

  private Map<String, Integer> createWinLottoResult(List<Integer> winLottoList, int bonusNumber) {
    return lottoStore.createWinLottoResult(winLottoList, bonusNumber);
  }

  private double calculateProfitRate(Map<String, Integer> winLottoResult) {
    return lottoStore.calculateProfitRate(winLottoResult);
  }

  private void printPurchasedLottos(Customer customer) {
    output.outPutBuyLotto(customer);
  }

  private void printResult(Map<String, Integer> winLottoResult, double profitRate) {
    output.outPutLottoResult(winLottoResult, profitRate);
  }

}
