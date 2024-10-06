package lotto.view;

public class OutputView {
    private static final String TICKET_COUNT = "개를 구매했습니다.";
    private static final String INPUT_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MINIMUM_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 최소 1,000원이 필요합니다.";
    private static final String ERROR_INVALID_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호를 6개 입력해 주세요.";
    private static final String ERROR_INVALID_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

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

    public static void printMinimumPurchaseMessage() {
        System.out.println(ERROR_MINIMUM_PURCHASE_AMOUNT);
    }

    public static void printInvalidPurchaseMessage() {
        System.out.println(ERROR_INVALID_PURCHASE_AMOUNT);
    }

    public static void printErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }

    public static void printErrorMessageInvalidNumber() {
        System.out.println(ERROR_INVALID_NUMBER);
    }
}
