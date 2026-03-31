package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - %d개\n"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - %d개\n"),
    MISS(0, false, 0, "");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;
    private final String message;

    Rank(int matchCount, boolean matchBonus, int prizeMoney, String message) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    // else 없이 당첨 등급을 반환하는 로직 (Early Return & Stream 활용)
    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank != SECOND)
                .findFirst()
                .orElse(MISS);
    }

    public int getPrizeMoney() { return prizeMoney; }
    public String getMessage() { return message; }
}
