package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void compare(List<List<Integer>> UserNum,int bonus,int price) {
        System.out.println("실행중");
        int result[]=new int[5];
        Arrays.fill(result,0);
        for(int i=0; i<UserNum.size(); i++){
            List<Integer> useList= UserNum.get(i);
            result = count(useList,result,bonus);
        }
        printResult(result);
        income(result,price);
    }

    private void income(int[] result, int price) {
        int income=0;
        int incomes[]= {5000,50000,1500000,30000000,2000000000};
        for(int i=0; i<result.length; i++){
            income += result[i]*incomes[i];
        }
        float incomeRate = (float) (1-(income/price));
        System.out.println("총 수익률은 "+incomeRate*100+"% 입니다.");
    }

    private void printResult(int[] result) {
        int price[]= {5000,50000,1500000,30000000,2000000000};
        for(int i=0; i<result.length-2;i++){
            System.out.println(i+3+"개 일치 ("+price[i]+"원) - "+result[i]+"개");
        }
        System.out.println("5개 일치, 보너스 볼 일치 ("+price[3]+"원) - "+result[3]+"개");
        System.out.println("6개 일치 ("+price[4]+"원) - "+result[4]+"개");

    }

    private int[] count(List<Integer> useList, int[] result, int bonus) {
        List<Integer> sumList = new ArrayList<>(12);
        sumList.addAll(useList);
        sumList.addAll(numbers);
        Set<Integer> numSet=new HashSet<>(sumList);
        int totalCount=12;
        int count= totalCount- numSet.size();
        boolean bonusCheck=false;
        if(useList.contains(bonus)){
            bonusCheck=true;
        }
        result =calculator(count,result,bonusCheck);
        return result;
    }

    private int[] calculator(int count, int[] result, boolean bonusCheck){
        if(count<3){
            return result;
        }
        if(count==5&&bonusCheck==true){
            result[3]=result[3]+1;
            return result;
        }
        result[count-3]=result[count-3]+1;
        return result;
    }
}
