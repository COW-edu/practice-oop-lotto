package view;

public enum OutputMessage {
    AMOUNT_OUTPUT("%d개를 구매했습니다."),
    FIFTH_OUTPUT("3개 일치 (5,000원) - %d개"),
    FOURTH_OUTPUT("4개 일치 (50,000원) - %d개"),
    THIRD_OUTPUT("5개 일치 (1,500,000원) - %d개"),
    SECOND_OUTPUT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_OUTPUT("6개 일치 (2,000,000,000원) - %d개");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
