import controller.LottoController;

public class Application {

  public static void main(String[] args) {
    LottoAppConfig lottoAppConfig = new LottoAppConfig();
    LottoController lottoController = lottoAppConfig.lottoController();
    lottoController.lottoRun();
  }
}
