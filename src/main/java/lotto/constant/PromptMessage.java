package lotto.constant;

public enum PromptMessage {
    PROMPT_PURCHASE_AMOUNT("구입 금액을 입력해 주세요: "),
    PROMPT_WINNING_NUMBERS("당첨 번호를 입력해 주세요. (1~45 숫자 6개를 쉼표로 구분해서 입력)"),
    PROMPT_BONUS_NUMBER("보너스 번호를 입력해 주세요. (1~45 사이 숫자)"),
    WINNING_STATISTICS("당첨 통계");

    private final String message;

    // 생성자를 통해 메시지를 설정
    PromptMessage(String message) {
        this.message = message;
    }

    // 동적 값이 필요한 경우에는 별도의 메서드로 처리
    public static String purchasedTickets(int count) {
        return String.format("%d개를 구매했습니다.", count);
    }

    public static String countCorrect(int correctCount, int prize, int matchCount) {
        return String.format("%d개 일치 (%d원) - %d개", correctCount, prize, matchCount);
    }

    // 메시지를 반환하는 메서드
    public String getMessage() {
        return message;
    }
}
