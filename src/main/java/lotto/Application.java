package lotto;

public class Application {

    public static void main(String[] args) {
        OutputHandler outputHandler = new OutputHandler();
        InputValidator inputValidator = new InputValidator();
        InputHandler inputHandler = new InputHandler(outputHandler, inputValidator);
        ResultCalculator resultCalculator = new ResultCalculator();
        LottoGame lottoGame = new LottoGame(inputHandler, resultCalculator, outputHandler);
        lottoGame.start();
    }
}
