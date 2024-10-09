package lotto.machine;

import lotto.view.LottoKiosk;
import lotto.repository.Memory;

public class KioskStarter {
    public static void main(String[] args) {
        LottoSeller lottoSeller = new LottoSeller();
        Memory memory = new Memory();
        WinningSystem winningSystem = new WinningSystem(memory);
        LottoKiosk kiosk = new LottoKiosk(lottoSeller, winningSystem);

        kiosk.start();
    }
}
