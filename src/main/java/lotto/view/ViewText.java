package lotto.view;

public enum ViewText {
    INPUT_PURCHASE_PRICE("구입 금액을 입력해 주세요."),
    OUTPUT_PURCHASE_AMOUNT("개를 구매했습니다."),
    INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_WIN_STATISTICS_TITLE("당첨 통계"),
    OUTPUT_DIVISION_LINE("---"),
    OUTPUT_THREE_ACCORD_NUMBERS("3개 일치 (5,000원) - "),
    OUTPUT_FOUR_ACCORD_NUMBERS("4개 일치 (50,000원) - "),
    OUTPUT_FIVE_ACCORD_NUMBERS("5개 일치 (1,500,000원) - "),
    OUTPUT_FIVE_ACCORD_NUMBERS_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    OUTPUT_SIX_ACCORD_NUMBERS("6개 일치 (2,000,000,000원) - "),
    OUTPUT_ACCORD_NUMBERS_TAIL("개"),
    OUTPUT_TOTAL_PROFIT_RATE_HEAD("총 수익률은 "),
    OUTPUT_TOTAL_PROFIT_RATE_TAIL("%입니다.");

    private final String data;
    ViewText(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
