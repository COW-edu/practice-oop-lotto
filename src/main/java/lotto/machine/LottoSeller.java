package lotto.machine;

import lotto.repository.Memory;

public class LottoSeller {

    private static final int PRICE_PER_TICKET = 1000;

    public void sellLotto(int amount, Memory memory) {
        if (amount % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        int ticketCount = amount / PRICE_PER_TICKET;

        // Memory에 티켓 개수 저장
        memory.saveTicketCount(ticketCount);
    }
}
