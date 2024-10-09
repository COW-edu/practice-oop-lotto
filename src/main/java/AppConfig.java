import lotto_controller.LottoController;
import lotto_controller.LottoControllerImpl;
import lotto_model.comparator.LottoComparator;
import lotto_model.comparator.LottoComparatorImpl;
import lotto_model.data.LottoRepository;
import lotto_model.data.LottoRepositoryImpl;
import lotto_model.data.LottoWinning;
import lotto_model.data.LottoWinningImpl;
import lotto_model.generator.LottoGenerator;
import lotto_model.generator.LottoGeneratorImpl;
import lotto_model.service.LottoService;
import lotto_model.service.LottoServiceImpl;
import lotto_view.LottoInput;
import lotto_view.LottoInputImpl;
import lotto_view.LottoOutput;
import lotto_view.LottoOutputImpl;

public class AppConfig {
    public LottoInput lottoInput() {
        return new LottoInputImpl();
    }

    public LottoOutput lottoOutput() {
        return new LottoOutputImpl(lottoWinning());
    }

    public LottoComparator lottoComparator() {
        return new LottoComparatorImpl(lottoRepository(), lottoWinning());
    }

    public LottoGenerator lottoGenerator() {
        return new LottoGeneratorImpl(lottoRepository());
    }

    public LottoRepository lottoRepository() {
        return LottoRepositoryImpl.getInstance();
    }

    public LottoWinning lottoWinning() {
        return LottoWinningImpl.getInstance();
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoComparator(), lottoGenerator());
    }

    public LottoController lottoController() {
        return new LottoControllerImpl(lottoInput(), lottoOutput(), lottoService());
    }

}
