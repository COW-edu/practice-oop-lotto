package lotto.view.converter;

import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoNumber;
import lotto.view.MessageConverter;

import java.util.Comparator;
import java.util.stream.Collectors;

public class LottoMessageConverter implements MessageConverter<Lotto> {

    public static final int SIZE_COVER_MESSAGE = 2;

    public static final String PREFIX_MESSAGE = "[";
    public static final String SUFFIX_MESSAGE = "]";
    public static final String NUMBER_DELIMITER = ", ";

    @Override
    public String convert(Lotto lotto) {
        var numbers = lotto.getNumbers();
        var capacity = numbers.size() + SIZE_COVER_MESSAGE;
        var messageBuilder = new StringBuilder(capacity);

        messageBuilder.append(PREFIX_MESSAGE);
        var joinNumberString = numbers.stream()
                                      .sorted(Comparator.comparingInt(LottoNumber::getValue))
                                      .map(lottoNumber -> String.valueOf(lottoNumber.getValue()))
                                      .collect(Collectors.joining(NUMBER_DELIMITER));
        messageBuilder.append(joinNumberString);
        messageBuilder.append(SUFFIX_MESSAGE);

        return messageBuilder.toString();
    }
}
