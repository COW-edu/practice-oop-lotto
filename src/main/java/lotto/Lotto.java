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

    public void compare(List<List<Integer>> UserNum) {
        System.out.println("실행중");
        int result[]=new int[5];
        Arrays.fill(result,0);
        for(int i=0; i<UserNum.size(); i++){
            List<Integer> useList= UserNum.get(i);
            result = count(useList,result);
        }
        printResult(result);
    }

    private void printResult(int[] result) {
        int price[]= {5000,50000,1500000,30000000,2000000000};
        for(int i=0; i<result.length;i++){
            System.out.println(i+3+"개 일치 ("+price[i]+"원) - "+result[i]+"개");
        }
    }

    private int[] count(List<Integer> useList, int[] result) {
        List<Integer> sumList = new ArrayList<>(12);
        sumList.addAll(useList);
        sumList.addAll(numbers);
        Set<Integer> numSet=new HashSet<>(sumList);
        int totalCount=12;
        int count= totalCount- numSet.size();
        result =calculator(count,result);
        return result;
    }

    private int[] calculator(int count, int[] result){
        if(count<3){
            return result;
        }
        result[count-3]=result[count-3]+1;
        return result;
    }
}
