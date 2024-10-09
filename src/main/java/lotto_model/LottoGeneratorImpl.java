package lotto_model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;

import static lotto_view.OutputMessage.AMOUNT_OUTPUT;

public class LottoGeneratorImpl implements LottoGenerator {
    private final LottoRepository lottoRepository;

    public LottoGeneratorImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    int lottoAmount = 0;

    @Override
    public void printLottoSaved(int inputMoney) {
        lottoAlign(inputMoney);
        System.out.printf((AMOUNT_OUTPUT.getMessage()) + "%n", lottoAmount);
            lottoRepository.getLottoSaved().stream().forEach(item -> System.out.println(item.getNumbers()));
    }

    private void lottoAlign(int inputMoney) {
        lottoAmount = getLottoAmount(inputMoney);
        for (int i = 0; i < lottoAmount; i++) {
            Lotto generatedNumber = numberGenerate();
            lottoSave(generatedNumber);
        }
    }

    private Lotto numberGenerate() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(Unit.MIN_NUMBER.getValue(), Unit.MAX_NUMBER.getValue(), Unit.UNIT_LOTTO_NUMBER.getValue()));
        Collections.sort(lotto.getNumbers());
        return lotto;
    }

    private static int getLottoAmount(int inputMoney) {
        return inputMoney / Unit.UNIT_MONEY.getValue();
    }

    private void lottoSave(Lotto generatedNumber) {
        lottoRepository.save(generatedNumber);
    }
}
