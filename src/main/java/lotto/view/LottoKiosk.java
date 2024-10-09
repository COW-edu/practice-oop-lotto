package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Error;
import lotto.constant.Prompt;
import lotto.constant.Rank.RankEnum;
import lotto.machine.*;

import java.util.List;
import java.util.Map;

public class LottoKiosk {
    private final LottoSeller lottoSeller;
    private final WinningSystem winningSystem;

    public LottoKiosk(LottoSeller lottoSeller, WinningSystem winningSystem) {
        this.lottoSeller = lottoSeller;
        this.winningSystem = winningSystem;
    }

    public void start() {
        // 구입 금액 입력
        int amount = requestAmount();

        // 로또 발행
        List<Lotto> tickets = lottoSeller.sellLotto(amount);
        System.out.println(Prompt.purchasedTickets(tickets.size()));  // 동적 메시지 생성
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));

        // 당첨 번호 입력
        List<Integer> winningNumbers = requestWinningNumbers();

        // 보너스 번호 입력
        int bonusNumber = requestBonusNumber();

        // 당첨 확인 및 결과 출력
        Map<RankEnum, Integer> matchCount = winningSystem.checkWinning(tickets, winningNumbers, bonusNumber);
        printResult(matchCount);
    }

    private int requestAmount() {
        while (true) {
            try {
                System.out.println(Prompt.PROMPT_PURCHASE_AMOUNT.getMessage());
                // Console API로 사용자 입력 처리
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println(Error.ERROR_INVALID_AMOUNT);
            }
        }
    }

    private List<Integer> requestWinningNumbers() {
        while (true) {
            try {
                System.out.println(Prompt.PROMPT_WINNING_NUMBERS.getMessage());
                String input = Console.readLine();
                return LottoParser.parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int requestBonusNumber() {
        while (true) {
            try {
                System.out.println(Prompt.PROMPT_BONUS_NUMBER.getMessage());
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input);
                BonusNumberValidator.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResult(Map<RankEnum, Integer> matchCount) {
        System.out.println(Prompt.WINNING_STATISTICS.getMessage());
        System.out.println("---");
        for (RankEnum rank : RankEnum.values()) {
            if (rank != RankEnum.NONE) {
                System.out.println(Prompt.countCorrect(rank.getMatchCount(), rank.getPrize(), matchCount.getOrDefault(rank, 0)));
            }
        }
    }
}
