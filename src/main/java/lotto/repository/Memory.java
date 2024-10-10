package lotto.repository;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private int ticketCount;
    private List<List<Integer>> generatedNumbers = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int totalPrize = 0;  // 총 상금

    // 티켓 개수 저장
    public void saveTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    // 티켓 개수 가져오기
    public int getTicketCount() {
        return ticketCount;
    }

    // 로또 번호 저장
    public void saveGeneratedNumbers(List<Integer> numbers) {
        this.generatedNumbers.add(numbers);
    }

    // 생성된 로또 번호 가져오기
    public List<List<Integer>> getGeneratedNumbers() {
        return generatedNumbers;
    }

    // 당첨 번호 저장
    public void saveWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // 저장된 당첨 번호 가져오기
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    // 보너스 번호 가져오기
    public int getBonusNumber() {
        return bonusNumber;
    }

    // 총 상금 가져오기
    public int getTotalPrize() {
        return totalPrize;
    }

    // 총 상금 저장
    public void setTotalPrize(int totalPrize) {
        this.totalPrize = totalPrize;
    }
}
