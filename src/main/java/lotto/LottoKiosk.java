package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException(Constant.ERROR_INVALID_AMOUNT);
                }
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // 잘못된 입력 처리 후 입력 버퍼 비우기
            }
        }
    }

    private List<Integer> requestWinningNumbers(Scanner scanner) {
        while (true) {
            try {
                System.out.println(Constant.PROMPT_WINNING_NUMBERS);
                String winningNumbersInput = scanner.next();
                return parseWinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        String[] split = input.split(",");
        List<String> errorMessages = new ArrayList<>();

        // 숫자 변환 및 예외 처리
        List<Integer> numbers = Arrays.stream(split)
                .map(String::trim)  // 공백 제거
                .map(num -> {
                    int number = Integer.parseInt(num);
                    if (number < 1 || number > 45) {
                        errorMessages.add(Constant.ERROR_INVALID_NUMBER);
                    }
                    return number;
                })
                .collect(Collectors.toList());

        // 숫자 개수 체크
        if (numbers.size() != 6) {
            errorMessages.add(Constant.ERROR_NUMBER_COUNT);
        }

        // 예외 발생: 1~45 범위를 벗어난 숫자 또는 6개 이상 입력
        if (!errorMessages.isEmpty()) {
            throw new IllegalArgumentException(String.join(" ", errorMessages));
        }

        return numbers;
    }


    private int requestBonusNumber(Scanner scanner) {
        while (true) {
            try {
                System.out.println(Constant.PROMPT_BONUS_NUMBER);
                int bonusNumber = scanner.nextInt();
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException(Constant.ERROR_INVALID_NUMBER);
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // 잘못된 입력 처리 후 입력 버퍼 비우기
            }
        }
    }
}
