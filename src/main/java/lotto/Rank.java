package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    final int matchCount;
    final boolean matchBonus;
    final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == matchBonus)
                .findFirst()
                .orElseGet(() -> matchCount >= 3 ? FIFTH : MISS);
    }

    public enum ExceptionCode {
        LOTTO_NUMBER_RULE1("로또 번호는 6개의 숫자로 구성되어야 합니다."),
        LOTTO_NUMBER_RULE2("로또 번호는 1부터 45 사이의 숫자여야 합니다.");


        private final String message;

        ExceptionCode(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum UserMessage {

        PRICE_GUIDE("구입금액을 입력해 주세요."),
        PRICE_ERROR_MESSAGE("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
        NUMBER_GUIDE("당첨 번호를 입력해 주세요."),
        NUMBER_ERROR_MESSAGE1("[ERROR] 당첨 번호는 6개의 숫자여야 합니다."),
        NUMBER_ERROR_MESSAGE2("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        BONUS_NUMBER_GUIDE("보너스 번호를 입력해 주세요."),
        BONUS_NUMBER_ERROR_MESSAGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
        CURRENT_MESSAGE("%d개 일치%s (%d원) - %d개\n");




        private final String message;

        UserMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        }
}
