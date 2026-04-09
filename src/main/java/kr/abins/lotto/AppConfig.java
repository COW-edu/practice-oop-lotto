package kr.abins.lotto;

import kr.abins.lotto.controller.LottoGenerator;
import kr.abins.lotto.controller.LottoProcessor;
import kr.abins.lotto.validator.IntValidator;
import kr.abins.lotto.validator.Validator;
import kr.abins.lotto.view.LottoReader;
import kr.abins.lotto.view.LottoStatistics;
import kr.abins.lotto.view.LottoWriter;
import kr.abins.lotto.view.Reader;

public final class AppConfig {

    public Validator<Integer> validator() {
        return new IntValidator();
    }

    public Reader reader() {
        return new Reader();
    }

    public LottoReader lottoReader() {
        return new LottoReader(this.reader(), this.validator());
    }

    public LottoWriter lottoWriter() {
        return new LottoWriter();
    }

    public LottoStatistics lottoStatistics() {
        return new LottoStatistics();
    }

    public LottoGenerator lottoGenerator() {
        return new LottoGenerator(this.lottoReader(), this.lottoWriter());
    }

    public LottoProcessor lottoProcessor() {
        final LottoReader reader = this.lottoReader();
        final LottoWriter writer = this.lottoWriter();
        return new LottoProcessor(reader, writer, new LottoGenerator(reader, writer));
    }
}
