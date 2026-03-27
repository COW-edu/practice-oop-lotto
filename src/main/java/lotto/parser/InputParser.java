package lotto.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    private InputParser() {
    }

    public static int parsePurchaseAmount(String input) {
        int purchaseAmount = parseInteger(input, "구입 금액은 숫자여야 합니다.");
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputParser::parseLottoNumber)
                .collect(Collectors.toList());
    }

    public static int parseBonusNumber(String input) {
        return parseLottoNumber(input);
    }

    private static int parseLottoNumber(String value) {
        int number = parseInteger(value, "로또 번호는 숫자여야 합니다.");
        validateLottoNumberRange(number);
        return number;
    }

    private static int parseInteger(String value, String message) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private static void validateLottoNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
