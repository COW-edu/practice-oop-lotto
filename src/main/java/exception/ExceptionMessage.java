package exception;

public class ExceptionMessage {

    public static void outOfBuyingRange() {
        System.out.println("[ERROR] 구입 금액은 1000원 단위입니다.");
    }

    public static void duplicate() {
        System.out.println("[ERROR] 선택한 6개의 숫자와 보너스 숫자가 중복입니다.");
    }

    public static void outOfRange() { System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."); }

    public static void outOfLottoLength() { System.out.println("[ERROR] 로또 번호는 6개만 입력할 수 있습니다."); }

    public static void catchString() { System.out.println("[ERROR] 로또 번호는 숫자만 입력 가능합니다."); }

    public static void catchBonusNumber() { System.out.println("[ERROR] 보너스 번호는 숫자만 입력 가능합니다."); }
}