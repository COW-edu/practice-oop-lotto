package Cow;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        int[] winnerNumbers = new int[6];
        int bonus;
        int amount;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the winner numbers (6 numbers):");
        for (int i = 0; i < 6; i++) {
            winnerNumbers[i] = scanner.nextInt();
        }

        System.out.println("Enter the bonus number:");
        bonus = scanner.nextInt();

        System.out.println("Enter the amount:");
        amount = scanner.nextInt();

        int count = amount / 1000;

        for (int i = 0; i < count; i++) {
            int[] lottoNumbers = generateLottoNumbers();
            System.out.println("Lotto number " + (i + 1) + ": " + Arrays.toString(lottoNumbers));

            int matchCount = countMatchingNumbers(winnerNumbers, lottoNumbers);
            boolean hasBonus = contains(lottoNumbers, bonus);

            printPrize(matchCount, hasBonus);
        }
    }

    public static int[] generateLottoNumbers() {
        int[] numbers = new int[6];
        Random random = new Random();

        int index = 0;
        while (index < 6) {
            int number = random.nextInt(45) + 1;
            if (!contains(numbers, number)) {
                numbers[index] = number;
                index++;
            }
        }

        Arrays.sort(numbers);
        return numbers;
    }

    public static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public static int countMatchingNumbers(int[] array1, int[] array2) {
        int count = 0;
        for (int num1 : array1) {
            for (int num2 : array2) {
                if (num1 == num2) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

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