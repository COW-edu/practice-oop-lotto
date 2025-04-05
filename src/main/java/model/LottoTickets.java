package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public int getTotalCount() {
        return tickets.size();
    }

    public List<List<Integer>> getLottoNumbers() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : tickets) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }
}
