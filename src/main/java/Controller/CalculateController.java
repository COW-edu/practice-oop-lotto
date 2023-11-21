package Controller;

import Entity.*;
import Repository.LottoRepository;
import Service.Calculator;
import View.OutputView;

import java.util.List;

public class CalculateController implements Controllable{
    private static final LottoRepository lottoRepository = LottoRepository.getInstance();
    Calculator calculator = new Calculator();
    OutputView outputView = new OutputView();

    @Override
    public void process(){
        List<Lotto> lottos = lottoRepository.findAll();
        List<Prize> prizeList = calculator.calculateResult(lottos, BonusNum.getBonusNumber());
        outputView.printResult(calculator.setPrize(prizeList));

        double totalProfitRate = calculator.calculateProfit(prizeList, Money.getMoney());
        outputView.printProfit(totalProfitRate);
    }
}
