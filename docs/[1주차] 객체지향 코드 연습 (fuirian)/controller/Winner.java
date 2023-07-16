package controller;

import java.util.Scanner;

public class Winner {
    private Scanner scanner;

    public Winner() {
        scanner = new Scanner(System.in);
    }

    public int[] readWinnerNumbers() {
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
}
