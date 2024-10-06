package lotto.repository;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryImpl implements LottoRepository {

    private static final List<Lotto> lottoStorage = new ArrayList<>();
    private static final List<WinningNumbers> winningNumbersStorage = new ArrayList<>();

    @Override
    public void saveLotto(Lotto lotto) {
        lottoStorage.add(lotto);
    }

    @Override
    public List<Lotto> findAllLotto() {
        return new ArrayList<>(lottoStorage);
    }

    @Override
    public void saveWinningNumbers(WinningNumbers winningNumbers) {
        winningNumbersStorage.add(winningNumbers); // 당첨 번호 저장
    }
    @Override
    public WinningNumbers findWinningNumbers() {
        return winningNumbersStorage.isEmpty() ? null : winningNumbersStorage.get(0); // 6개중 첫 번째 저장된 당첨 번호 반환
    }

}
