package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.LottoRepository;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController implements Controller{

    private static final LottoRepository lottoRepository = LottoRepository.getInstance();

    private static final int LOTTO_PRICE = 1000;

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private int calculateLottoAmount(int amount) {
        return amount / LOTTO_PRICE;
    }

    @Override
    public void service(InputView inputView, OutputView outputView) {
        int lottoAmount = calculateLottoAmount(inputView.requestAmount());

        List<Lotto> lottos = IntStream.rangeClosed(1, lottoAmount)
                .mapToObj(i -> makeLotto())
                .collect(Collectors.toList());

        lottoRepository.save(lottos);
        outputView.showOrder(lottoRepository.findAll());
    }
}
