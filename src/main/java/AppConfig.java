import controller.LottoController;
import controller.LottoControllerImpl;
import model.comparator.LottoComparator;
import model.comparator.LottoComparatorImpl;
import model.data.LottoRepository;
import model.data.LottoRepositoryImpl;
import model.data.LottoWinning;
import model.data.LottoWinningImpl;
import model.generator.LottoGenerator;
import model.generator.LottoGeneratorImpl;
import model.service.LottoService;
import model.service.LottoServiceImpl;
import view.LottoInput;
import view.LottoInputImpl;
import view.LottoOutput;
import view.LottoOutputImpl;

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
