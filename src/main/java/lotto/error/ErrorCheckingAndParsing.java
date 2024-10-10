package lotto.error;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ErrorCheckingAndParsing {

  static final int THOUSAND_PLACE = 1000;
  static final int MINIMUM_NUMBER_RANGE = 1;
  static final int MAXIMUM_NUMBER_RANGE = 45;
  static final int LOTTO_NUM_COUNT = 6;

 public static int isDividedThousand(int price){

   if (price % THOUSAND_PLACE != 0){
   throw new IllegalArgumentException("[Error] 남은 동전이 없어 잔돈을 드리지 못 합니다. 다시 입력해 주세요.");
   }

   return price / THOUSAND_PLACE;
 }

  public static int isNum(String lottoPrice){
    try {
      int price = Integer.parseInt(lottoPrice);

      return price;
    }catch (IllegalArgumentException e){
      throw new IllegalArgumentException("숫자를 입력해 주세요.");
    }

  }

  public static void confirmNumRange(int lottoNum){
    if (lottoNum < MINIMUM_NUMBER_RANGE || lottoNum > MAXIMUM_NUMBER_RANGE){
      throw new IllegalArgumentException("[Error] 1부터 45까지의 숫자만 입력해 주세요.");
    }

  }

  public static void isOnlySixNums(List<Integer> winNums){
    if (winNums.size() != LOTTO_NUM_COUNT){
      throw new IllegalArgumentException("[Error] 숫자 6개를 입력해 주세요.");
    }
  }

  public static List<Integer> isNumsAsString(String[] winNumbersAsStrings){
   try {
     List<Integer> winNums = Arrays.stream(winNumbersAsStrings)
         .map(Integer::parseInt)
         .collect(Collectors.toList());

     return winNums;
   } catch (IllegalArgumentException e) {
     throw new IllegalArgumentException("[Error] 숫자를 입력해 주세요.");
   }
 }

}
