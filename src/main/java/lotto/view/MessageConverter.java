package lotto.view;

@FunctionalInterface
public interface MessageConverter<T> {
    String convert(T obj);
}
