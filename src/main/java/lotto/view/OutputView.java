package lotto.view;

public class OutputView {
    private static final String TICKET_COUNT = "개를 구매했습니다.";
    private static final String INPUT_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printTicketCount(int count) {
        System.out.println(count + TICKET_COUNT);
    }

    public static void printInputLottoPriceMessage() {
        System.out.println(INPUT_LOTTO_PRICE);
    }

    public static void printInputLottoWinningMessage() {
        System.out.println(INPUT_LOTTO_WINNING);
    }

    public static void printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printErrorMessage(ErrorMessage errorMessage) {
        System.out.println(errorMessage.getMessage());
    }

}
