package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        int price = InputView.inputPrice();
        LottoTickets purchasedLottos = LottoGenerator.buyLottos(price);
        displayLottos(purchasedLottos);

        String winningNumbersInput = InputView.inputWinningNumbers();
        List<Integer> winningNumbers = parseNumbers(winningNumbersInput);
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(purchasedLottos, winningLotto, price);
        displayResult(lottoResult);

    }

    public void displayLottos(LottoTickets lottos) {
        OutputView.printLottos(lottos.getTotalCount(), lottos.getLottoNumbers());
    }

    public void displayResult(LottoResult lottoResult) {
        OutputView.printWinningStatistics(lottoResult);
    }

    //문자열 정수 변환
    private static List<Integer> parseNumbers(String number) {
        List<Integer> numbers = new ArrayList<>();
        String[] numberStrings = number.split(",");
        for (String numberString : numberStrings) {
            try {
                numbers.add(Integer.parseInt(numberString.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
            }
        }
        return numbers;
    }
}
