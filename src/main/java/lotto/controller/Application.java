package lotto.controller;

import lotto.model.*;
import lotto.view.*;

public class Application {
    public static void main(String[] args) {
        AmountInput amountInput = new AmountInput();
        LottoDraw lottoDraw = new LottoDraw(amountInput.getAmount());
        LottoInput lottoInput = new LottoInput();
        LottoCompare lottoCompare = new LottoCompare(lottoDraw, lottoInput);
        LottoResult lottoResult = new LottoResult(lottoCompare.getMatchResults());
        PrintResult printResult = new PrintResult(lottoResult.getResults(), amountInput.getAmount());
    }
}