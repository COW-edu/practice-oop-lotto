import lotto_controller.LottoController;
import lotto_model.LottoComparator;
import lotto_model.LottoGenerator;
import lotto_model.LottoRepository;
import lotto_model.LottoService;
import lotto_view.LottoInput;
import lotto_view.LottoOutput;

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
