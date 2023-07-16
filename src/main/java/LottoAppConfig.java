import controller.LottoController;
import machine.CheckedEqualMachine;
import machine.ProfitCalculator;
import model.lotto.LottoStore;
import view.input.Input;
import view.input.InputImpl;
import view.output.OutPutImpl;
import view.output.Output;

public class LottoAppConfig {
  public LottoController lottoController(){
    return new LottoController(output(), input(), lottoStore(), checkedEqualMachine(),profitCalculator());
  }
  private Output output(){
    return new OutPutImpl();
  }
  private Input input(){
    return new InputImpl();
  }
  private LottoStore lottoStore(){
    return new LottoStore();
  }
  private CheckedEqualMachine checkedEqualMachine(){
    return new CheckedEqualMachine();
  }
  private ProfitCalculator profitCalculator(){
    return new ProfitCalculator();
  }
}
