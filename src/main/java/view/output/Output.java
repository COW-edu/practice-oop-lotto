package view.output;

public interface Output {
  void outPutMessage(String message);
  void outPutLottoResult(double profitRate, WinLottoResult winLottoResult);
  void outPutBuyLotto(PayLottosData lottosData);
}
