package model;

import java.util.Arrays;
import java.util.Random;

public class LottoModel {
    private int[] winnerNumbers;
    private int bonus;
    private int amount;

    public LottoModel() {
        winnerNumbers = new int[6];
    }

    public int[] getWinnerNumbers() {
        return winnerNumbers;
    }

    public int getBonus() {
        return bonus;
    }

    public int getAmount() {
        return amount;
    }

    public void setWinnerNumbers(int[] winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int[] generateLottoNumbers() {
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

    private boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public int countMatchingNumbers(int[] array1, int[] array2) {
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            int num1 = array1[i];
            int num2 = array2[i];
            if (num1 == num2) {
                count++;
            }
        }
        return count;
    }
}
