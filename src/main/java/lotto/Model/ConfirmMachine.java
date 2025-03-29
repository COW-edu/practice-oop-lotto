package lotto.Model;

import java.util.List;

public class ConfirmMachine {
    private int confirmedMoney =0 ;
    private MoneyStatics moneyStatics = new MoneyStatics();
    public void matchNumber(List<Lotto> lottoes, WinningLotto winningLotto){
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
    public void judgementMoney(int matchCount,int bonusCount){
        if(matchCount <3){
            confirmedMoney +=0;
        } else if (matchCount ==3) {
            confirmedMoney += 5000;
            moneyStatics.getCountStatics().set(0, moneyStatics.getCountStatics().get(0) +1);

        } else if (matchCount ==4) {
            confirmedMoney += 50000;
            moneyStatics.getCountStatics().set(1, moneyStatics.getCountStatics().get(1) +1);

        } else if (matchCount==5) {
            confirmedMoney += 1500000;
            moneyStatics.getCountStatics().set(2, moneyStatics.getCountStatics().get(2) +1);

        } else if (matchCount ==4 && bonusCount == 1) {
            confirmedMoney +=  3000000;
            moneyStatics.getCountStatics().set(3, moneyStatics.getCountStatics().get(3) +1);

        } else if (matchCount ==6) {
            confirmedMoney +=  200000000;
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
