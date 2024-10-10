package lotto.machine;

import lotto.repository.Memory;

public class LottoSeller {

    private static final int PRICE_PER_TICKET = 1000;
    private static final String PRICE_INFORMATION = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";

    public void sellLotto(int amount, Memory memory) {
        if (amount % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException(PRICE_INFORMATION);
        }
        int ticketCount = amount / PRICE_PER_TICKET;

        // Memory에 티켓 개수 저장
        memory.saveTicketCount(ticketCount);
    }
}
