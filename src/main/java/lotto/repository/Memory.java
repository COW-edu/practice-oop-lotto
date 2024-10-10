package lotto.repository;

import lotto.machine.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private List<Lotto> tickets = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    // 로또 티켓 저장
    public void saveTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    // 당첨 번호 저장
    public void saveWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // 저장된 로또 티켓 반환
    public List<Lotto> getTickets() {
        return tickets;
    }

    // 저장된 당첨 번호 반환
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    // 저장된 보너스 번호 반환
    public int getBonusNumber() {
        return bonusNumber;
    }
}
