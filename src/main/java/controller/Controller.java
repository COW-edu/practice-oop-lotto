package controller;

import model.Validator;
import model.Lotto;
import model.LottoService;
import model.LottoTickets;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService = new LottoService();
    private final Validator validator = new Validator();

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

    }
    public void run(){
        int price = inputView.readPurchasePrice();
        validator.validatePurchasedAmount(price);
        LottoTickets tickets = lottoService.purchaseLottos(price);
        outputView.printLottos(tickets);
        List<Integer> winningNumber = inputView.readWinningNumberInput();
        validator.validateWinningNumber(winningNumber);
        Lotto winningLotto = new Lotto(winningNumber);
        int bonusNumber = inputView.readBonusNumber();
        validator.validateBonusNumber(winningLotto, bonusNumber);
        int[] result = LottoService.checkResult(tickets, winningLotto, bonusNumber);
        outputView.printResult(result, price);
    }
}
