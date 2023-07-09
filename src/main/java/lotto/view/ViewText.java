package lotto.view;

public enum ViewText {
    INPUT_PURCHASE_PRICE("구입 금액을 입력해 주세요."),
    INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_WIN_STATISTICS_TITLE("당첨 통계"),
    OUTPUT_DIVISION_LINE("---");

    private final String data;
    ViewText(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
