package kr.abins.lotto;

import kr.abins.lotto.model.LottoResult;
import kr.abins.lotto.controller.LottoProcessor;
import kr.abins.lotto.model.LottoSession;
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
        // 의존성 주입 패턴이라면 LottoReader를 인터페이스로 안만들고 객체화 했을 것 같습니다.
        // 제가 생각하기에 상태를 가질 이유가 없어 인터페이스로 객체화없이 구현했습니다.

        final LottoSession session = new LottoSession();
        final LottoProcessor processor = new LottoProcessor(session);
        processor.start();

        final LottoResult result = new LottoResult(processor.recipes());
        LottoStatistics.print(result);
    }
}
