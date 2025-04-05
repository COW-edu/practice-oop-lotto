package validator;


import exception.ValidationException;

public interface Validator<T> {
    void validate(T input) throws ValidationException;
}