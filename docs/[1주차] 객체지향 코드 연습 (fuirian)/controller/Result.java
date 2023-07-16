// Result.java
package controller;

public class Result {
    public String calculatePrize(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return "Congratulations! You won the 1st prize! (6 numbers match)\nPrize: 2,000,000,000 won";
        }
        if (matchCount == 5 && hasBonus) {
            return "Congratulations! You won the 2nd prize! (5 numbers + bonus match)\nPrize: 30,000,000 won";
        }
        if (matchCount == 5) {
            return "Congratulations! You won the 3rd prize! (5 numbers match)\nPrize: 1,500,000 won";
        }
        if (matchCount == 4) {
            return "Congratulations! You won the 4th prize! (4 numbers match)\nPrize: 50,000 won";
        }
        if (matchCount == 3) {
            return "Congratulations! You won the 5th prize! (3 numbers match)\nPrize: 5,000 won";
        }
        return "Sorry, you didn't win any prize.";
    }
}
