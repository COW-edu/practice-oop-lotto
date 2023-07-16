// LottoView.java
package view;

import java.util.Arrays;

public class LottoView {

    public void displayLottoNumber(int[] numbers, int index) {
        System.out.println("Lotto number " + index + ": " + Arrays.toString(numbers));
    }

    public void displayPrize(String prize) {
        System.out.println(prize);
    }
}
