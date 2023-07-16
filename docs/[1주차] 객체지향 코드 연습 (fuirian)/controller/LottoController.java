// LottoController.java
package controller;

import model.LottoModel;
import view.LottoView;

import java.util.Scanner;

public class LottoController {
    private LottoModel lottoModel;
    private LottoView lottoView;
    private Scanner scanner;

    public LottoController(LottoModel lottoModel, LottoView lottoView) {
        this.lottoModel = lottoModel;
        this.lottoView = lottoView;
        scanner = new Scanner(System.in);
    }

    public void run() {
        int[] winnerNumbers = readWinnerNumbers();
        int bonus = readBonusNumber();
        int amount = readAmount();

        lottoModel.setWinnerNumbers(winnerNumbers);
        lottoModel.setBonus(bonus);
        lottoModel.setAmount(amount);

        int count = amount / 1000;

        for (int i = 0; i < count; i++) {
            int[] lottoNumbers = lottoModel.generateLottoNumbers();
            lottoView.displayLottoNumber(lottoNumbers, i + 1);

            int matchCount = lottoModel.countMatchingNumbers(winnerNumbers, lottoNumbers);
            boolean hasBonus = contains(lottoNumbers, bonus);

            String prize = calculatePrize(matchCount, hasBonus);
            lottoView.displayPrize(prize);
        }

        scanner.close();
    }

    private int[] readWinnerNumbers() {
        int[] winnerNumbers = new int[6];
        System.out.println("Enter the winner numbers (6 numbers, separated by spaces):");
        String input = scanner.nextLine();
        String[] numberStrings = input.split(" ");

        if (numberStrings.length != 6) {
            System.out.println("Invalid input. Please enter exactly 6 numbers.");
            return readWinnerNumbers();
        }

        for (int i = 0; i < 6; i++) {
            try {
                winnerNumbers[i] = Integer.parseInt(numberStrings[i]);
                if (winnerNumbers[i] < 1 || winnerNumbers[i] > 45) {
                    System.out.println("Invalid number. Please enter a number between 1 and 45.");
                    return readWinnerNumbers();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
                return readWinnerNumbers();
            }
        }
        return winnerNumbers;
    }

    private int readBonusNumber() {
        System.out.println("Enter the bonus number:");
        String input = scanner.nextLine();
        try {
            int bonus = Integer.parseInt(input);
            if (bonus < 1 || bonus > 45) {
                System.out.println("Invalid number. Please enter a number between 1 and 45.");
                return readBonusNumber();
            }
            return bonus;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return readBonusNumber();
        }
    }

    private int readAmount() {
        System.out.println("Enter the amount:");
        return scanner.nextInt();
    }

    private boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    private String calculatePrize(int matchCount, boolean hasBonus) {
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
