package lotto.constant;

public class Constant {
    // Error Messages
    public static final String ERROR_INVALID_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String ERROR_INVALID_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 중복된 번호가 존재합니다.";
    public static final String ERROR_NUMBER_COUNT = "[ERROR] 로또 번호는 정확히 6개를 입력해야 합니다.";

    // User Prompt Messages
    public static final String PROMPT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    public static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요. (1~45 숫자 6개를 쉼표로 구분해서 입력)";
    public static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요. (1~45 사이 숫자)";
    public static final String PURCHASED_TICKETS = "%d개를 구매했습니다.";

    // Rank Enumeration
    public enum Rank {
        FIRST(6, false, 2_000_000_000),
        SECOND(5, true, 30_000_000),
        THIRD(5, false, 1_500_000),
        FOURTH(4, false, 50_000),
        FIFTH(3, false, 5_000),
        NONE(0, false, 0);

        private final int matchCount;
        private final boolean matchBonus;
        private final int prize;

        Rank(int matchCount, boolean matchBonus, int prize) {
            this.matchCount = matchCount;
            this.matchBonus = matchBonus;
            this.prize = prize;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public static Rank findRank(int matchCount, boolean matchBonus) {
            for (Rank rank : values()) {
                if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                    return rank;
                }
            }
            return NONE;
        }

        public int getPrize() {
            return prize;
        }
    }
}
