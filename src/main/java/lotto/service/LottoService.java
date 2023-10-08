package lotto.service;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoService {
    // MAGIC NUMBER
    private static final int PURCHASE_PRICE = 1000;
    private static final int SECOND_RANK_KEY = 7;
    // components
    private Lotto lotto;
    private List<Integer> member;


    public LottoService() {
        this.lotto = new Lotto(member);
    }

    // validation

    /**
     * [Vaildation]
     * [Input] 1000원으로 나뉘는지
     */
    public int validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        return purchaseAmount / PURCHASE_PRICE;
    }

    // func

    /**
     * [FUNC]
     * 로또 개수에 따른 로또번호 생성
     */
    public List<Lotto> createMember(int purchaseAmount) {
        return this.lotto.createLottoNum(purchaseAmount);
    }

    /**
     * [FUNC]
     * INPUT값으로 받은 당첨번호 리스트에 저장
     */
    public ArrayList<Integer> convertWinningNum(String winngingNumStr) {
        ArrayList<Integer> winningNumlist = new ArrayList<>();

        String[] tempStr = winngingNumStr.split(",");
        for (String temp : tempStr) {
            winningNumlist.add(Integer.parseInt(temp));
        }
        return winningNumlist;
    }

    /**
     * [FUNC]
     * 당첨번호와 로또번호 비교 / (조건)BONUS번호도 비교
     */
    // service part 당첨번호 확인(2개 리스트 받아서 확인 후 랭킹 리스트만 반환)
    public int[] checkNum(List<Lotto> selectedLottoNumList, List<Integer> winningNumList, int inputBonusNum) {
        List<Integer> tempList;
        int[] checkedRankList = new int[8];

        for (Lotto selectedLott : selectedLottoNumList) {
            List<Integer> tempSelected = selectedLott.getLottoList();

            tempList = tempSelected.stream().filter(o -> winningNumList.stream()
                    .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());

            checkedRankList[tempList.size()]++;

            // 5개 맞췄을 때 bonus 검증
            // BONUS넘 가져와야함
            if (tempList.size() == 5 && tempSelected.contains(inputBonusNum)) {
                checkedRankList[SECOND_RANK_KEY]++;
            }
        }
        return checkedRankList;
    }

    /**
     * [FUNC]
     * 당첨List에서 당첨금 합 / 수익률 계산
     */
    public double calEarningRate(int[] checkedRankList, int purchaseMoney) {
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
        double resultPercent = Math.round(tempSum / (double) purchaseMoney * 100.0) / 100.0 * 100;

        return resultPercent;
    }

}
