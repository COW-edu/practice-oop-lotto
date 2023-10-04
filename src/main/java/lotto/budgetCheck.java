package lotto;

public class budgetCheck {
    public int check(int budget)  {
        if ((budget%1000)==0){
            System.out.println();
            return budget/1000;
        }
        try {
            throw new IllegalAccessException("[ERROR] 1000원으로 나뉘어 떨어져야합니다.");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
