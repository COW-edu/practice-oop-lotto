package forexception;

import model.LottosData;
import model.WinData;

public class CheckedException {
    private LottosData lottosData;
    private WinData winData;

    public CheckedException(LottosData lottosData, WinData winData) {
        this.lottosData = lottosData;
        this.winData = winData;
    }
    public void checkedThousand() {
        if(lottosData.getUseMoney()%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
    }
}
