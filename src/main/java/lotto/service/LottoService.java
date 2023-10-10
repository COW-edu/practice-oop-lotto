package lotto.service;

import lotto.Domain.Lotto;
import lotto.config.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoService {
    // MAGIC NUMBER
    private static final int PURCHASE_PRICE = 1000;
    private static final int SECOND_RANK_KEY = 7;
    // components


    public LottoService() {

    }

    // validation

    /**
     * [VALIDATION]
     * [INPUT] 1000원으로 나뉘는지 / 1000원보다 큰지
     */
    public void validatePurchaseAmount(int purchaseMoney) {
        if (purchaseMoney % PURCHASE_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASEMONEY_NO_DIVISION.getErrorMessage());
        }
        if (purchaseMoney < PURCHASE_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASEMONEY_UNDER_1000.getErrorMessage());
        }
    }

    /**
     * [VALIDATION]
     * [INPUT] 6개입력 / 범위 1 ~ 45 / 중복 수
     */
    private void validateInputWinningNum(List<Integer> winningNumList) {
        if (winningNumList.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_LOTTONUM_COUNT.getErrorMessage());
        }
        for (int checkNum : winningNumList) {
            if (checkNum < 1 && checkNum > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_WINNINGNUMBER_UNREASONABLE_RANGE.getErrorMessage());
            }
        }
        if (winningNumList.size() != winningNumList.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_LOTTONUM_DUPLICATE.getErrorMessage());
        }
    }

    /**
     * [VALIDATION]
     * [INPUT] 정수 입력 / 1 ~ 45의 수 / winningNumList 중복확인
     */
    private void validateInputBonusNum(int bounusNum, List<Integer> winningNumList) {
        if (bounusNum < 1 && bounusNum > 45) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WINNINGNUMBER_UNREASONABLE_RANGE.getErrorMessage());
        }
       if(winningNumList.contains(bounusNum)){
           throw new IllegalArgumentException(ErrorMessage.ERROR_BONUSNUM_DUPLICATE.getErrorMessage());
       }
    }

    // func

    /**
     * [FUNC]
     * 구입금액을 통한 개수 계산
     */
    public int calculatePurchaseAmount(int purchaseMoney) {
        validatePurchaseAmount(purchaseMoney);
        return purchaseMoney / PURCHASE_PRICE;
    }

    /**
     * [FUNC]
     * 로또 개수에 따른 로또번호 생성
     */
    public List<Lotto> createMember(int purchaseAmount) {
        List<Lotto> selectedLottoNum = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> member = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(member);
            selectedLottoNum.add(lotto);
        }
        return selectedLottoNum;
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

        validateInputWinningNum(winningNumlist);
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
