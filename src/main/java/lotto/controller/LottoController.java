package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;


    // field Element

    private static final int LOTTO_NUMBER_RANGE_FRONT = 1;
    private static final int LOTTO_NUMBER_RANGE_BACK = 45;
    private static final int LOTTO_LIST_SIZE = 6;

    private final LottoRepository lottoRepository;


    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoRepository = new LottoRepository();
    }

    @Override
    public void service(Map<String, Object> model) {
        int purchaseAmount = (int) model.get("Purchase");

        List<Lotto> selectedLottoNumList = createLottoMember(purchaseAmount);
        outputView.outputSelectedLottoNum(selectedLottoNumList);

        model.put("Lotto", selectedLottoNumList);
    }


    public List<Lotto> createLottoMember(int purchaseAmount) {
        List<Lotto> selectedLottoNumber = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> member = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_FRONT, LOTTO_NUMBER_RANGE_BACK, LOTTO_LIST_SIZE);
            Lotto lotto = new Lotto(member);

            lottoRepository.save(lotto);
            selectedLottoNumber.add(lotto);
        }
        return selectedLottoNumber;
    }


}
