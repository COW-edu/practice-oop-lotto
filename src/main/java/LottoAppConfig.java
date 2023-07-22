import calculator.Calculator;
import calculator.ProfitCalculator;
import controller.LottoController;
import model.lotto.LottoStore;
import view.input.Input;
import view.input.InputImpl;
import view.output.OutPutImpl;
import view.output.Output;

public class LottoAppConfig {

  public LottoController lottoController() {
    return new LottoController(output(), input(), lottoStore());
  }

  private Output output() {
    return new OutPutImpl();
  }

  private Input input() {
    return new InputImpl();
  }

  private LottoStore lottoStore() {
    return new LottoStore();
  }

}
