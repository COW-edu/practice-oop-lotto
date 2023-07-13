package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerImpl;
import lotto.model.LottoNumberRepository;
import lotto.model.LottoNumberRepositoryImpl;
import lotto.model.LottoResultRepository;
import lotto.model.LottoResultRepositoryImpl;
import lotto.model.WinningLottoNumberRepository;
import lotto.model.WinningLottoNumberRepositoryImpl;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

  public InputView inputView() {
    return new InputView(lottoController());
  }

  public OutputView outputView() {
    return new OutputView(lottoController());
  }

  public LottoController lottoController() {
    return new LottoControllerImpl(lottoService());
  }

  public LottoService lottoService() {
    return new LottoServiceImpl(
        lottoNumberRepository(),
        winningLottoNumberRepository(),
        lottoResultRepository());
  }

  public LottoNumberRepository lottoNumberRepository() {
    return new LottoNumberRepositoryImpl();
  }

  public WinningLottoNumberRepository winningLottoNumberRepository() {
    return new WinningLottoNumberRepositoryImpl();
  }

  public LottoResultRepository lottoResultRepository() {
    return new LottoResultRepositoryImpl();
  }

}
