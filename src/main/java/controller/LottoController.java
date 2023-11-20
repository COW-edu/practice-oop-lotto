package controller;

import lotto.Lotto;
import domain.Reward;
import Enum.Rank;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.RandomLotto;
import view.OutputView;

public class LottoController {


    private final OutputView outputView;

    private List<Lotto> lottos;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<Lotto> makeRandomLottos(RandomLotto randomLotto, int count) {
        lottos = randomLotto.makeList(count);
        outputView.announceRandomLottos(lottos);
        return lottos;
    }

}
