package view.output;

import model.LottosData;
import model.WinData;

public interface Output {
  void outPutMessage(String message);
  void outPutLottoResult(WinData winData);
  void outPutBuyLotto(LottosData lottosData);
}
