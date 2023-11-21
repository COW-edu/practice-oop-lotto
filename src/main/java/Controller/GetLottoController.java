package Controller;

import Entity.Lotto;
import Repository.LottoRepository;
import View.OutputView;

import java.util.List;

public class GetLottoController implements Controllable{
    private static final LottoRepository lottoRepository = LottoRepository.getInstance();
    OutputView outputView = new OutputView();

    @Override
    public void process(){
        List<Lotto> lottos = lottoRepository.findAll();
        outputView.printLottos(lottos);
    }
}
