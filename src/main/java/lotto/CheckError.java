package lotto;

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
      System.out.println("숫자를 입력해 주세요~");
      throw new IllegalArgumentException();
    }
  }

  public static void isNumRange(int num){
    if (num < 1 || num > 45){
      System.out.println("[Error] 1부터 45까지의 숫자만 입력해 주세요.");
      throw new IllegalArgumentException();
    }
  }


}
