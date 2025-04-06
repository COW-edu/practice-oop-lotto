package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<String, Integer> results = new HashMap<>();

    public LottoResult(List<LottoCompare.MatchResult> matchResults) {
        System.out.println("당첨 통계");
        System.out.println("---");

        results.put("3", 0);
        results.put("4", 0);
        results.put("5", 0);
        results.put("5+bonus", 0);
        results.put("6", 0);

        for (LottoCompare.MatchResult result : matchResults) {
            int matchCount = result.getMatchCount();
            boolean bonusMatch = result.isBonusMatch();

            if (matchCount == 6) { results.put("6", results.get("6") + 1); }
            if (matchCount == 5 && bonusMatch) { results.put("5+bonus", results.get("5+bonus") + 1); }
            if (matchCount == 5) { results.put("5", results.get("5") + 1); }
            if (matchCount == 4) { results.put("4", results.get("4") + 1); }
            if (matchCount == 3) { results.put("3", results.get("3") + 1); }
        }
    }
    public Map<String, Integer> getResults() {
        return results;
    }
}