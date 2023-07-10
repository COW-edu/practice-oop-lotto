package Lotto;

public class Result {

    public static void printPrize(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            System.out.println("Congratulations! You won the 1st prize! (6 numbers match)");
            System.out.println("Prize: 2,000,000,000 won");
            return;
        }
        if (matchCount == 5 && hasBonus) {
            System.out.println("Congratulations! You won the 2nd prize! (5 numbers + bonus match)");
            System.out.println("Prize: 30,000,000 won");
            return;
        }
        if (matchCount == 5) {
            System.out.println("Congratulations! You won the 3rd prize! (5 numbers match)");
            System.out.println("Prize: 1,500,000 won");
            return;
        }
        if (matchCount == 4) {
            System.out.println("Congratulations! You won the 4th prize! (4 numbers match)");
            System.out.println("Prize: 50,000 won");
            return;
        }
        if (matchCount == 3) {
            System.out.println("Congratulations! You won the 5th prize! (3 numbers match)");
            System.out.println("Prize: 5,000 won");
            return;
        }
        System.out.println("Sorry, you didn't win any prize.");
        System.out.println();
    }
}