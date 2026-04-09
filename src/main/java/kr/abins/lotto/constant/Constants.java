package kr.abins.lotto.constant;

public class Constants {

    private Constants() {
        throw new IllegalStateException("cannot be instantiated for constants class");
    }

    /*
     * 1등: 6개 번호 일치 / 2,000,000,000원
     * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
     * 3등: 5개 번호 일치 / 1,500,000원
     * 4등: 4개 번호 일치 / 50,000원
     * 5등: 3개 번호 일치 / 5,000원
     */
    public final static long PRIZE_1ST = 2_000_000_000;
    public final static long PRIZE_2ND = 30_000_000;
    public final static long PRIZE_3RD = 1_500_000;
    public final static long PRIZE_4TH = 50_000;
    public final static long PRIZE_5TH = 5_000;

    public final static int LOTTO_PRICE = 1000;
    public final static int LOTTO_NUMBER_COUNT = 6;

    public final static int MIN_LOTTO_NUMBER = 1;
    public final static int MAX_LOTTO_NUMBER = 45;
}
