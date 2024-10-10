package lotto.machine;

import lotto.repository.Memory;
import lotto.view.LottoKiosk;

public class KioskStarter {
    public static void main(String[] args) {
        LottoSeller lottoSeller = new LottoSeller();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(); // LottoNumberGenerator 생성
        Memory memory = new Memory();
        WinningSystem winningSystem = new WinningSystem(memory);

        // LottoKiosk에 모든 인자 전달
        LottoKiosk kiosk = new LottoKiosk(lottoSeller, lottoNumberGenerator, winningSystem, memory);

        // 게임 시작
        kiosk.start();
    }
}
