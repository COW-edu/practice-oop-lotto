package lotto;

import java.util.*;

public class Lotto {
    private final Scanner scanner = new Scanner(System.in);

    List<Integer> numbers;

    public Lotto() {
    }

    public Lotto(List<Integer> integers) {
        numbers = integers;
    }

    public void run() {
        int purchaseAmount = readPurchaseAmount();
        LottoTicket ticket = new LottoTicket(purchaseAmount);
        ticket.printLottos();

        WinningLotto winningLotto = readWinningLotto();
        LottoResult result = new LottoResult(ticket, winningLotto);
        result.printResults(purchaseAmount);

        scanner.close();
    }

    private int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(scanner.nextLine().trim());
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        return amount;
    }

    private WinningLotto readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = parseNumbers(scanner.nextLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine().trim());
        return new WinningLotto(numbers, bonusNumber);
    }

    private List<Integer> parseNumbers(String input) {
        String[] split = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num : split) {
            numbers.add(Integer.parseInt(num.trim()));
        }
        return numbers;
    }
}