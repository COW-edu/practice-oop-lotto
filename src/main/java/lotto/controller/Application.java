package lotto.controller;

import lotto.model.*;
import lotto.view.*;

public class Application {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        lottoInput.readPurchaseAmount();
        LottoDraw lottoDraw = new LottoDraw(lottoInput.getAmount());
        lottoInput.readWinningLotto();
        LottoCompare lottoCompare = new LottoCompare(lottoDraw, lottoInput);
        LottoResult lottoResult = new LottoResult(lottoCompare.getMatchCount(), lottoCompare.getBonusMatchCount(), lottoInput.getAmount());
    }
}