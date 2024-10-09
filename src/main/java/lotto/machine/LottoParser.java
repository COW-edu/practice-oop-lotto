package lotto.machine;

import lotto.constant.Error;

import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {

    private static final String NUMBER_SEPARATOR = ",";

    public static List<Integer> parseWinningNumbers(String input) {
        String[] split = input.split(NUMBER_SEPARATOR);

        List<Integer> numbers;
        try {
            numbers = List.of(split).stream()
                    .map(String::trim)  // 공백 제거
                    .map(Integer::parseInt)  // 문자열을 정수로 변환
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            // Error enum을 사용해 예외 메시지 출력
            throw new IllegalArgumentException(Error.ERROR_INVALID_NUMBER.getMessage());
        }

        // 유효성 검사는 Lotto 객체에 맡김
        return new Lotto(numbers).getNumbers();
    }
}
