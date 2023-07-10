package Lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Console {

    public void run(Scanner scanner) {
        int[] winnerNumbers = new int[6];
        int bonus;
        int amount;

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

            Result.printPrize(matchCount, hasBonus);
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

    private static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public static int countMatchingNumbers(int[] array1, int[] array2) {
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            int num1 = array1[i];
            int num2 = array2[i];
            if (num1 == num2) {
                count++;
                break;
            }
        }
        return count;
    }
}