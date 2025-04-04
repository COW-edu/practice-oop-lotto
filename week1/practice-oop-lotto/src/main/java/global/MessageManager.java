package global;

import java.text.DecimalFormat;


import static global.Constants.*;

public class MessageManager {
    public enum MessageType {
        INPUT_LOTTO_PRICE("구입금액을 입력해 주세요."),
        INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        MessageType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class MessageFormatter {

        private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0");

        public static String formatPurchaseCount(int purchaseCount) {
            return String.format("%d개를 구매했습니다.", purchaseCount);
        }

        public static String formatProfitRate(double profitRate) {
            return String.format("총 수익률은 %s%%입니다", DECIMAL_FORMAT.format(profitRate));
        }

        public static String formatWinningStatistics(int fifthPrize, int fourthPrize, int thirdPrize, int secondPrize, int firstPrize) {
            return String.format("당첨 통계\n---\n" +
                            "3개 일치 (%d원) - %d개\n" +
                            "4개 일치 (%d원) - %d개\n" +
                            "5개 일치 (%d원) - %d개\n" +
                            "5개 일치, 보너스 볼 일치 (%d원) - %d개\n" +
                            "6개 일치 (%d원) - %d개",
                    FIFTH_PRIZE, fifthPrize,
                    FOURTH_PRIZE, fourthPrize,
                    THIRD_PRIZE, thirdPrize,
                    SECOND_PRIZE, secondPrize,
                    FIRST_PRIZE, firstPrize);
        }
    }
}
