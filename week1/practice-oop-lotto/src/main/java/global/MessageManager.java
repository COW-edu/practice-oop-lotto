package global;

import model.Lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        public static String formatPurchaseMessage(int price) {
            return (price / 1000) + "개를 구매했습니다.";
        }

        public static String formatLottoListMessage(List<Lotto> lottos) {
            StringBuilder sb = new StringBuilder();
            for (Lotto lotto : lottos) {
                List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
                Collections.sort(sortedNumbers); // 숫자 정렬
                sb.append(sortedNumbers).append("\n");
            }
            return sb.toString().trim();
        }

        public static String formatWinningCount(LottoRank rank) {
            return rank.toString();
        }

        public static String formatProfitRate(int price, int totalPrizeMoney) {
            double profitRate = (double) totalPrizeMoney / price * 100;
            profitRate = Math.round(profitRate * 100.0) / 100.0;
            return "총 수익률은 " + DECIMAL_FORMAT.format(profitRate) + "%입니다";
        }

        public static String formatWinningStatistics(int prizeFifth, int fifthPrize,
                                                     int prizeFourth, int fourthPrize,
                                                     int prizeThird, int thirdPrize,
                                                     int prizeSecond, int secondPrize,
                                                     int prizeFirst, int firstPrize) {
            return String.format("당첨 통계\n---\n" +
                            "3개 일치 (%d원) - %d개\n" +
                            "4개 일치 (%d원) - %d개\n" +
                            "5개 일치 (%d원) - %d개\n" +
                            "5개 일치, 보너스 볼 일치 (%d원) - %d개\n" +
                            "6개 일치 (%d원) - %d개",
                    prizeFifth, fifthPrize,
                    prizeFourth, fourthPrize,
                    prizeThird, thirdPrize,
                    prizeSecond, secondPrize,
                    prizeFirst, firstPrize);
        }
    }
}
