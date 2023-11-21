package model;

public class WinningLottoRepository {

    private WinningLotto winningLotto;

    private static final WinningLottoRepository instance = new WinningLottoRepository();

    public static WinningLottoRepository getInstance() {
        return instance;
    }
    public void save(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningLotto getWinningLotto() {
        return this.winningLotto;
    }
}
