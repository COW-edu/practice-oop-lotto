package lotto.controller;

import lotto.Lotto;
import lotto.config.WinningPrint;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoController {

    private static int PURCHASE_PRICE = 1000;
    private static int WINNING_KEY = 7;

    private final InputView inputView;
    private final OutputView outputView;
    private Lotto lotto;

    // field Element
    private int purchaseMoney;
    public int purchaseAmount;
    public int inputBonusNum;
    private List<Integer> member;
    private List<Lotto> selectedLottoNumList;
    private List<Integer> winningNumList;
    private int[] checkedRankList;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();

        this.lotto = new Lotto(member);
        WinningPrint winningPrint;
    }


    public void lottoGameRun() {
        this.purchaseMoney = inputView.inputPurchaseMoney();
        this.purchaseAmount = validatePurchaseAmount(this.purchaseMoney);

        outputView.outputLottoAmount(this.purchaseAmount);

        createMember(this.purchaseAmount);
        this.outputView.outputSelectedLottoNum(selectedLottoNumList);

        this.winningNumList = convertWinningNum(this.inputView.inputWinningNum());
        this.inputBonusNum = inputView.inputBonus();

        // winningNum에 대한 vaildation 작성 해야함
        /*
      - validation 처리 해야 됨
      1. 정수 입력
      2. 1~45 수
      3. winningNum 중복
       */

        // 배열로 받음
        this.checkedRankList = checkNum(selectedLottoNumList, winningNumList);
        this.outputView.outputWinningStatistic(this.checkedRankList);
        this.outputView.outputMoneyPercent(calMoneyPercent(this.checkedRankList));
    }

    //service part
    private int validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        return purchaseAmount / PURCHASE_PRICE;
    }

    // service part winningNum 받은 거 리스트에 넣기
    private ArrayList<Integer> convertWinningNum(String winngingNumStr) {
        ArrayList<Integer> winningNumlist = new ArrayList<>();

        String[] tempStr = winngingNumStr.split(",");
        for (String temp : tempStr) {
            winningNumlist.add(Integer.parseInt(temp));
        }
        return winningNumlist;
    }

    // service part 당첨번호 확인(2개 리스트 받아서 확인 후 랭킹 리스트만 반환)
    public int[] checkNum(List<Lotto> selectedLottoNumList, List<Integer> winningNumList) {
        List<Integer> tempList;
        this.checkedRankList = new int[8];

        for (Lotto selectedLott : selectedLottoNumList) {
            List<Integer> tempSelected = selectedLott.getLottoList();

            tempList = tempSelected.stream().filter(o -> winningNumList.stream()
                    .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());

            checkedRankList[tempList.size()]++;

            // 5개 맞췄을 때 bonus 검증
            if (tempList.size() == 5 && tempSelected.contains(inputBonusNum)) {
                checkedRankList[WINNING_KEY]++;
            }
        }
        return checkedRankList;
    }

    // service part
    public double calMoneyPercent(int[] checkedRankList) {
        double tempSum = 0.0;
        for (int i = 3; i < checkedRankList.length; i++) {
            if (checkedRankList[i] != 0 && i == 3) {
                tempSum += checkedRankList[i] * 5000;
            }
            if (checkedRankList[i] != 0 && i == 4) {
                tempSum += checkedRankList[i] * 50000;
            }
            if (checkedRankList[i] != 0 && i == 5) {
                tempSum += checkedRankList[i] * 1500000;
            }
            if (checkedRankList[i] != 0 && i == 6) {
                tempSum += checkedRankList[i] * 2000000000;
            }
            if (checkedRankList[i] != 0 && i == 7) {
                tempSum += checkedRankList[i] * 30000000;
            }
        }
        double resultPercent = Math.round(tempSum / (double) purchaseMoney * 100) / 100.0 * 100;

        return resultPercent;
    }

    private void createMember(int purchaseAmount) {
        this.selectedLottoNumList = this.lotto.createLottoNum(purchaseAmount);
    }
}
