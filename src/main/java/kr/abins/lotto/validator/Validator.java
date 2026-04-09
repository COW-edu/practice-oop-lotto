package kr.abins.lotto.validator;

public interface Validator<T> {

    T validate(final String value);
}
