package lotto.Model;

import java.util.List;

public class LottoResultChecker {
    private int confirmedMoney =0 ;
    private MoneyStatics moneyStatics = new MoneyStatics();
    private static final int MIN_MATCH_NUMBER = 3;
    private static final int FOUR_MATCH_NUMBER = 4;
    private static final int FIVE_MATCH_NUMBER = 5;
    private static final int BONUS_MATCH_NUMBER = 1;
    private static final int ALL_MATCH_NUMBER = 6;
    private static final int THREE_MATCH_MONEY = 5000;
    private static final int FOUR_MATCH_MONEY = 50000;
    private static final int FIVE_MATCH_MONEY = 1500000;
    private static final int BONUS_MATCH_MONEY = 3000000;
    private static final int ALL_MATCH_MONEY = 20000000;


    public void matchNumber(List<Lotto> lottoes, WinningLotto winningLotto) {
        for(int i=0; i<lottoes.size(); i++){
            int matchCount =0;
            int bonusCount =0;
            for(int part : lottoes.get(i).getNumbers()){
                if (winningLotto.getWinningNumbers().contains(part)){
                    matchCount += 1;
                } else if (winningLotto.getBonusNumber() == part) {
                    bonusCount+= 1;
                }
            }
            judgementMoney(matchCount, bonusCount);
        }
    }
    private void judgementMoney(int matchCount,int bonusCount) {
        if(matchCount < MIN_MATCH_NUMBER){
            confirmedMoney +=0;
        } else if (matchCount == MIN_MATCH_NUMBER) {
            confirmedMoney += THREE_MATCH_MONEY;
            moneyStatics.getCountStatics().set(0, moneyStatics.getCountStatics().get(0) +1);

        } else if (matchCount == FOUR_MATCH_NUMBER) {
            confirmedMoney += FOUR_MATCH_MONEY;
            moneyStatics.getCountStatics().set(1, moneyStatics.getCountStatics().get(1) +1);

        } else if (matchCount== FIVE_MATCH_NUMBER) {
            confirmedMoney += FIVE_MATCH_MONEY;
            moneyStatics.getCountStatics().set(2, moneyStatics.getCountStatics().get(2) +1);

        } else if (matchCount == FIVE_MATCH_NUMBER && bonusCount == BONUS_MATCH_NUMBER) {
            confirmedMoney +=  BONUS_MATCH_MONEY;
            moneyStatics.getCountStatics().set(3, moneyStatics.getCountStatics().get(3) +1);

        } else if (matchCount ==ALL_MATCH_NUMBER) {
            confirmedMoney +=  ALL_MATCH_MONEY;
            moneyStatics.getCountStatics().set(3, moneyStatics.getCountStatics().get(3) +1);
        }
    }

    public int getConfirmedMoney() {
        return confirmedMoney;
    }

    public MoneyStatics getMoneyStatics() {
        return moneyStatics;
    }
}
