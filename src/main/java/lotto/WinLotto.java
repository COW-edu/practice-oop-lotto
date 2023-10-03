package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {
    public List<Integer> winningLotto;

    public WinLotto(){
        this.winningLotto = new ArrayList<>();

    }
    public List<Integer> draw() {
        drawNumber(); // 6개의 번호를 입력 받는다.
        drawBonus(); // 보너스 번호를 받는다.
        return winningLotto;
    }

    private void drawBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        addBonus(checkRange(Integer.parseInt(Console.readLine())));
    }

    private void drawNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNum = Console.readLine().split(",");
        checkListRange(winningNum);
        for (String number : winningNum) {this.winningLotto.add(checkRange(Integer.parseInt(number.trim())));
        }
    }

    private boolean checkListRange(String[] winningNum) {
        if (winningNum.length==6){
            return true;
        }
        try {
            throw new IllegalAccessException("[ERROR] 로또 번호는 6개를 입력해야합니다.");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBonus(int bonus){
        this.winningLotto.add(bonus);
    }
    public int checkRange(int number){
        if ((number>0) && (number<46)){
            return number;
        }
        try {
            throw new IllegalAccessException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

