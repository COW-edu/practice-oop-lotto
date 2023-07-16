package controller;

import java.util.Scanner;

public class Bonus {
    private Scanner scanner;

    public Bonus() {
        scanner = new Scanner(System.in);
    }

    public int readBonusNumber() {
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
}
