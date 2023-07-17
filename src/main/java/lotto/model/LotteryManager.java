package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.LotteryNumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LotteryManager {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    public static List<Integer> winningNumbers;
    public static int bonusNumber;
    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }
    public static void saveWinningNumbers(String numbers) {
        winningNumbers = splitLottoNumbersByComma(numbers);
    }
    public static void saveBonusNumber(String bonus) {
        bonusNumber = Integer.parseInt(bonus);
    }
    private static List<Integer> splitLottoNumbersByComma(String lottoNumbers) {
        StringTokenizer st = new StringTokenizer(lottoNumbers, ",");
        List<Integer> splitNumbers = new ArrayList<>();
        while(st.hasMoreTokens()) {
            String strNumber = st.nextToken();
            LotteryNumberValidator.validateNumberFormat(strNumber);
            int number = Integer.parseInt(strNumber);
            LotteryNumberValidator.validateNumberRange(number);
            splitNumbers.add(number);
        }
        return splitNumbers;
    }
}
