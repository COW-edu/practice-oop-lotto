package lotto;

import lotto.instrastructure.persistance.InMemoryLottoRepository;
import lotto.lotto.service.FinishedLottoService;
import lotto.lotto.service.ListLottoService;
import lotto.lotto.service.PurchaseLottoService;
import lotto.view.console.ApplicationConsoleView;
import lotto.view.converter.LottoMessageConverter;

public class Application {
    public static void main(String[] args) {
        var consoleView = new ApplicationConsoleView(new LottoMessageConverter());
        var inMemoryLottoRepository = new InMemoryLottoRepository();
        var purchaseLottoUseCase = new PurchaseLottoService(inMemoryLottoRepository);
        var listLottoUseCase = new ListLottoService(inMemoryLottoRepository);
        var finishedLottoUseCase = new FinishedLottoService(inMemoryLottoRepository);

        new LottoApplication(consoleView, purchaseLottoUseCase, listLottoUseCase, finishedLottoUseCase).run();
    }
}
