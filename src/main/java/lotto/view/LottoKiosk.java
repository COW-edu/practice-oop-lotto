package lotto.view;

import lotto.machine.LottoSeller;
import lotto.machine.WinningSystem;
import lotto.constant.Constant;
import lotto.machine.Lotto;

import java.util.List;
import java.util.Scanner;

public class LottoKiosk {
    private final LottoSeller lottoSeller;
    private final WinningSystem winningSystem;

    public LottoKiosk(LottoSeller lottoSeller, WinningSystem winningSystem) {
        this.lottoSeller = lottoSeller;
        this.winningSystem = winningSystem;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        // 구입 금액 입력
        int amount = requestAmount(scanner);

        // 로또 발행
        List<Lotto> tickets = lottoSeller.sellLotto(amount);
        System.out.printf(Constant.PURCHASED_TICKETS, tickets.size());
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }

        // 당첨 번호 입력
        List<Integer> winningNumbers = requestWinningNumbers(scanner);

        // 보너스 번호 입력
        int bonusNumber = requestBonusNumber(scanner);

        // 당첨 확인
        winningSystem.checkWinning(tickets, winningNumbers, bonusNumber);
    }

    private int requestAmount(Scanner scanner) {
        while (true) {
            try {
                System.out.println(Constant.PROMPT_PURCHASE_AMOUNT);
                int amount = scanner.nextInt();
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(Constant.ERROR_INVALID_AMOUNT);
                scanner.nextLine(); // 잘못된 입력 처리 후 입력 버퍼 비우기
            }
        }
    }

    private List<Integer> requestWinningNumbers(Scanner scanner) {
        while (true) {
            try {
                System.out.println(Constant.PROMPT_WINNING_NUMBERS);
                String winningNumbersInput = scanner.next();
                // 입력된 번호를 Lotto 객체에서 처리
                return Lotto.parseWinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int requestBonusNumber(Scanner scanner) {
        while (true) {
            try {
                System.out.println(Constant.PROMPT_BONUS_NUMBER);
                int bonusNumber = scanner.nextInt();
                // 보너스 번호 유효성 검사는 Lotto 클래스에서 처리
                Lotto.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // 잘못된 입력 처리 후 입력 버퍼 비우기
            }
        }
    }
}
