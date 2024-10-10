package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.constant.PromptMessage;
import lotto.constant.Rank;
import lotto.machine.*;
import lotto.repository.Memory;

import java.util.List;
import java.util.Map;

public class LottoKiosk {
    private final LottoSeller lottoSeller;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final WinningSystem winningSystem;
    private final Memory memory;
    private int purchaseAmount;

    public LottoKiosk(LottoSeller lottoSeller, LottoNumberGenerator lottoNumberGenerator, WinningSystem winningSystem, Memory memory) {
        this.lottoSeller = lottoSeller;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.winningSystem = winningSystem;
        this.memory = memory;
    }

    public void start() {
        // 구입 금액 입력 및 예외 처리 추가
        while (true) {
            try {
                purchaseAmount = requestAmount();
                lottoSeller.sellLotto(purchaseAmount, memory);  // 1,000원 단위 예외 처리
                break;  // 예외가 없으면 루프 탈출
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());  // 예외 메시지 출력 후 재입력 요구
            }
        }

        // 로또 번호 생성 및 출력
        lottoNumberGenerator.generateNumbers(memory);
        printGeneratedTickets();

        // 당첨 번호 입력
        List<Integer> winningNumbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumber();
        memory.saveWinningNumbers(winningNumbers, bonusNumber);

        // 당첨 확인 및 결과 출력
        Map<Rank.RankEnum, Integer> matchCount = winningSystem.checkWinning();
        printResult(matchCount);

        // 수익률 계산 및 출력
        double profitRate = winningSystem.calculateProfitRate(purchaseAmount);
        printProfitRate(profitRate);  // 수익률 출력
    }

    // 구입 금액 입력 처리
    private int requestAmount() {
        while (true) {
            try {
                System.out.println(PromptMessage.PROMPT_PURCHASE_AMOUNT.getMessage());
                String input = Console.readLine();
                return Integer.parseInt(input); // 금액이 정수가 아니면 예외 발생
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERROR_INVALID_AMOUNT.getMessage()); // 입력값이 잘못된 경우 처리
            }
        }
    }

    // 당첨 번호 입력 처리
    private List<Integer> requestWinningNumbers() {
        while (true) {
            try {
                System.out.println(PromptMessage.PROMPT_WINNING_NUMBERS.getMessage());
                String input = Console.readLine();
                return LottoParser.parseWinningNumbers(input); // 번호 파싱 및 유효성 검증
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 유효하지 않은 번호에 대한 예외 처리
            }
        }
    }

    // 보너스 번호 입력 처리
    private int requestBonusNumber() {
        while (true) {
            try {
                System.out.println(PromptMessage.PROMPT_BONUS_NUMBER.getMessage());
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input);
                Lotto.validateBonusNumber(bonusNumber); // 보너스 번호 유효성 검증
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERROR_INVALID_NUMBER.getMessage()); // 잘못된 형식 처리
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 유효하지 않은 번호 처리
            }
        }
    }

    private void printGeneratedTickets() {
        System.out.println("구매한 로또 번호:");
        List<List<Integer>> tickets = memory.getGeneratedNumbers();
        tickets.forEach(ticket -> System.out.println(ticket));
    }

    private void printResult(Map<Rank.RankEnum, Integer> matchCount) {
        System.out.println(PromptMessage.WINNING_STATISTICS.getMessage());
        System.out.println("---");

        // Stream API를 사용하여 결과 출력
        java.util.Arrays.stream(Rank.RankEnum.values())
                .filter(rank -> rank != Rank.RankEnum.NONE)
                .forEach(rank -> System.out.println(
                        PromptMessage.countCorrect(rank.getMatchCount(), rank.getPrize(), matchCount.getOrDefault(rank, 0))
                ));
    }

    // 수익률 출력 메서드
    private void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
