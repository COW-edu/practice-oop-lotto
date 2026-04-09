package kr.abins.lotto;

import kr.abins.lotto.controller.LottoProcessor;
import kr.abins.lotto.model.LottoResult;
import kr.abins.lotto.view.LottoStatistics;

public class Application {

    public static void main(String[] args) {
        try {
            main0();
        } catch (final RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main0() throws RuntimeException {
        final AppConfig config = new AppConfig();
        final LottoProcessor processor = config.lottoProcessor();
        final LottoResult result = processor.start();

        final LottoStatistics statistics = config.lottoStatistics();
        statistics.print(result);
    }
}
