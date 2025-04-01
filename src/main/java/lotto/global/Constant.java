package lotto.global;

public class Constant {

    public static class ValidatorConstant{
        private static final String ERROR = "[ERROR] ";
        private static final String NO_BLANK = "공백을 입력하셨습니다.";
        private static final String NUMBER = "숫자를 입력해주세요.";
        private static final String UNIT_MONEY = "원 단위로 입력해주세요.";
        private static final String DUPLICATION = "중복된 숫자가 있습니다.";
        private static final String RANGE_MIN= "부터 ";
        private static final String RANGE_MAX= "까지의 숫자를 입력해주세요.";
        private static final String COUNT = "개의 숫자를 입력해주세요.";
        private static final String BONUS_DUPLICATE = "로또 번호와 중복되는 번호입니다.";

        public static String BlankError() {
            return ERROR + NO_BLANK;
        }
        public static String rangeError(int min, int max) {
            return ERROR + min + RANGE_MIN + max + RANGE_MAX;
        }
        public static String countError(int count) {
            return ERROR + count + COUNT;
        }
        public static String unitError(int unit) {
            return ERROR + unit + UNIT_MONEY;
        }
        public static String numberError() {
            return ERROR + NUMBER;
        }
        public static String blankError() {
            return ERROR + NO_BLANK;
        }
        public static String duplicationError() {
            return ERROR + DUPLICATION;
        }
        public static String bonusDuplicateError() {
            return ERROR + BONUS_DUPLICATE;
        }

    }

    public static class LottoConstant{
        public static final int LOTTO_COUNT = 6;
        public static final int LOTTO_MIN = 1;
        public static final int LOTTO_MAX = 45;
    }

    public static class ControllerConstant{
        public static final String INPUT_MONEY = "구입금액을 입력해주세요";
        public static final String INPUT_CORRECTNUMBER = "당첨 번호를 입력해주세요";
        public static final String INPUT_BONUSNUMBER = "보너스 번호를 입력해주세요";
        public static final int UNIT =10;
    }

    public static class ViewConstant{
        public static final String STATISTICS = "당첨 통계 \n-------";
        public static final String TOTAL_PROFIT_RATE_PREFIX = "총 수익률은 ";
        public static final String TOTAL_PROFIT_RATE_SUFFIX = "%입니다.";
        public static final String PURCHASED_COUNT_MESSAGE = "개를 구매했습니다.";
        public static String resultMessage(String prizeText, int count) {
            return prizeText+" - "+count+"개";
        }
    }
    
}
