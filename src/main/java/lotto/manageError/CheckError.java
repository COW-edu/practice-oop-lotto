package lotto.manageError;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckError {
 public static void dividedThousand(int price){
   if (price % 1000 != 0){
   System.out.println("[Error] 남은 동전이 없어 잔돈을 드리지 못 합니다. 다시 입력해 주세요.");
   throw new IllegalArgumentException();
 }}

  public static int isNum(String num){
    try {
      int intNum = Integer.parseInt(num);
      return intNum;
    }catch (IllegalArgumentException e){
      System.out.println("숫자를 입력해 주세요.");
      throw new IllegalArgumentException();
    }
  }

  public static void numRange(int num){
    if (num < 1 || num > 45){
      System.out.println("[Error] 1부터 45까지의 숫자만 입력해 주세요.");
      throw new IllegalArgumentException();
    }
  }

  public static void onlySixNums(List<Integer> nums){
    if (nums.size() != 6){
      System.out.println("[Error] 숫자 6개를 입력해 주세요.");
      throw new IllegalArgumentException();
    }
  }

  public static List<Integer> inputOnlyNums(String[] winningNumsArr){
   try {
     List<Integer> integerList = Arrays.stream(winningNumsArr)
         .map(Integer::parseInt)
         .collect(Collectors.toList());
     return integerList;
   } catch (IllegalArgumentException e) {
     System.out.println("[Error] 숫자를 입력해 주세요.");
     throw new IllegalArgumentException();
   }
 }
}
