import lottocontroller.LottoController;
import lottomodel.LottoComparator;
import lottomodel.LottoGenerator;
import lottomodel.LottoRepository;
import lottomodel.LottoService;
import lottoview.LottoInput;
import lottoview.LottoOutput;

public class AppConfig {
    public LottoInput lottoInput() {
        return new LottoInput();
    }

    public LottoOutput lottoOutput() {
        return new LottoOutput();
    }

    public LottoComparator lottoComparator() {
        return new LottoComparator(lottoRepository());
    }

    public LottoGenerator lottoGenerator() {
        return new LottoGenerator(lottoRepository());
    }

    public LottoRepository lottoRepository() {
        return LottoRepository.getInstance();
    }

    public LottoService lottoService() {
        return new LottoService(lottoComparator(), lottoGenerator());
    }

    public LottoController lottoController() {
        return new LottoController(lottoInput(), lottoOutput(), lottoService());
    }

}
