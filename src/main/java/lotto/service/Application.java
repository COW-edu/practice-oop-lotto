package lotto.service;

import lotto.controller.LottoGenerator;
import lotto.controller.ResultCalculator;
import lotto.utils.InputValidator;

public class Application {

    public static void main(String[] args) {
        OutputHandler outputHandler = new OutputHandler();
        InputValidator inputValidator = new InputValidator();
        InputHandler inputHandler = new InputHandler(outputHandler, inputValidator);
        ResultCalculator resultCalculator = new ResultCalculator();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoGame lottoGame = new LottoGame(inputHandler, resultCalculator, outputHandler,lottoGenerator);
        lottoGame.start();
    }
}
