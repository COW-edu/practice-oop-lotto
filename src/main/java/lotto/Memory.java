package lotto;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private List<Lotto> tickets = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void saveTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public void saveWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
