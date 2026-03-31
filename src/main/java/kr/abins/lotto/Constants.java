package kr.abins.lotto;

public interface Constants {

    /*
     * 1등: 6개 번호 일치 / 2,000,000,000원
     * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
     * 3등: 5개 번호 일치 / 1,500,000원
     * 4등: 4개 번호 일치 / 50,000원
     * 5등: 3개 번호 일치 / 5,000원
     */
    long PRIZE_1ST = 2_000_000_000;
    long PRIZE_2ND = 30_000_000;
    long PRIZE_3RD = 1_500_000;
    long PRIZE_4TH = 50_000;
    long PRIZE_5TH = 5_000;

    int LOTTO_PRICE = 1000;
    int LOTTO_NUMBER_COUNT = 6;
    int LOTTO_WINNING_NUMBER_COUNT = 6;

    int MIN_LOTTO_NUMBER = 1;
    int MAX_LOTTO_NUMBER = 45;

    String ERROR_PREFIX = "[ERROR] ";
    String ERROR_ONLY_INTEGER = ERROR_PREFIX + "숫자만 입력 가능합니다.";
    String ERROR_PURCHASE_AMOUNT_NOT_DIVISIBLE = ERROR_PREFIX + "구입 금액은 1,000원 단위여야 합니다.";
    String ERROR_PURCHASE_AMOUNT_NOT_POSITIVE = ERROR_PREFIX + "구입 금액은 0보다 커야 합니다.";
    String ERROR_LOTTO_NUMBERS_MUST_BE_SIX = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    String ERROR_WINNING_LOTTO_NUMBERS_MUST_BE_SIX = ERROR_PREFIX + "로또 당첨 번호는 6개여야 합니다.";
    String ERROR_LOTTO_NUMBER_OUT_OF_RANGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    String ERROR_LOTTO_NUMBERS_DUPLICATED = ERROR_PREFIX + "로또 번호에 중복된 숫자가 있습니다.";
    String ERROR_BONUS_NUMBER_DUPLICATED = ERROR_PREFIX + "보너스 번호는 당첨 번호와 중복되면 안 됩니다.";
}
