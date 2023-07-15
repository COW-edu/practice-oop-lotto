package lotto;

import controller.LottoController;
import controller.LottoWinChecked;
import controller.LottoWinResult;
import model.LottosData;
import model.WinData;
import view.output.OutPutImpl;
import view.output.Output;

public class LottoAppConfig {
  public LottoController LottoController(){
    return new LottoController(RequestText(), LottosData(), WinData(), LottoWinChecked(),LottoWinResult());
  }

  public Output RequestText(){return new OutPutImpl();}

  public LottosData LottosData(){return new LottosData();}

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
