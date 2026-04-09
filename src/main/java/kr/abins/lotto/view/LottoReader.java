package kr.abins.lotto.view;

import kr.abins.lotto.validator.Validator;

import java.util.List;

public class LottoReader {

    private final Reader reader;
    private final Validator<Integer> validator;

    public LottoReader(final Reader reader, final Validator<Integer> validator) {
        this.reader = reader;
        this.validator = validator;
    }

    public int readPurchaseAmount() throws IllegalArgumentException {
        return this.reader.readInt(this.validator);
    }

    public List<Integer> readWinningNumbers() throws IllegalArgumentException {
        return this.reader.readInts(this.validator);
    }

    public int readBonusNumber() throws IllegalArgumentException {
        return this.reader.readInt(this.validator);
    }
}
