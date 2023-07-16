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
  public Output output(){
    return new OutPutImpl();
  }
  public Input input(){
    return new InputImpl();
  }
  public LottoStore lottoStore(){
    return new LottoStore();
  }
  public CheckedEqualMachine checkedEqualMachine(){
    return new CheckedEqualMachine();
  }

  public ProfitCalculator profitCalculator(){
    return new ProfitCalculator();
  }
}
