package lotto;

public class LottoRank {
    int firstPrize;
    int secondPrize;
    int thirdPrize;
    int fourthPrize;
    int fifthPrize;

    public LottoRank(int [] rank) {
        this.firstPrize = rank[0];
        this.secondPrize = rank[1];
        this.thirdPrize = rank[2];
        this.fourthPrize = rank[3];
        this.fifthPrize = rank[4];
    }

    @Override
    public String toString() {
        int prizeFirst = 2000000000;
        int prizeSecond = 30000000;
        int prizeThird = 1500000;
        int prizeFourth = 50000;
        int prizeFifth = 5000;

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
