package lotto;

import controller.LottoController;
import controller.LottoWinChecked;
import controller.LottoWinResult;
import model.LottosData;
import model.WinData;
import view.input.Input;
import view.input.InputImpl;
import view.output.OutPutImpl;
import view.output.Output;

public class LottoAppConfig {
  public LottoController LottoController(){
    return new LottoController(Output(), Input(), LottosData(), WinData(), LottoWinChecked(),LottoWinResult());
  }
  public Output Output(){
    return new OutPutImpl();
  }
  public Input Input(){
    return new InputImpl();
  }
  public LottosData LottosData(){
    return new LottosData();
  }

  public WinData WinData(){
    return new WinData();
  }

  public LottoWinChecked LottoWinChecked(){
    return new LottoWinChecked();
  }

  public LottoWinResult LottoWinResult(){
    return new LottoWinResult();
  }
}
