package kr.abins.lotto.validator;

import kr.abins.lotto.constant.ErrorMessage;

public class IntValidator implements Validator<Integer> {

    public Integer validate(final String value) throws IllegalArgumentException {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_INTEGER.toString());
        }
    }
}
