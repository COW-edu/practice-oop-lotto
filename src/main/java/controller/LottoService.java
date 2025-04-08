package controller;

import model.*;
import view.*;
import java.util.*;

public class LottoService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String moneyInput = inputView.inputMoney();
        LottoCounter lottoPurchase = new LottoCounter(moneyInput);
        int count = lottoPurchase.getCount();

        LottoNumberCreater generator = new LottoNumberCreater(outputView);
        List<List<Integer>> lottoDigits = generator.generate(count);

        LottoWinNumberCreater lottoWinDigits = new LottoWinNumberCreater(inputView);
        lottoWinDigits.readWinNumbers();

        Lotto lotto = new Lotto(lottoWinDigits.getWinNumbers());
        LottoResult result = lotto.compareDigits(lottoDigits, lottoWinDigits.getBonus(), lottoPurchase.getMoney());

        outputView.printStatistics(result.getResult(), result.getProfitRate());
    }
}