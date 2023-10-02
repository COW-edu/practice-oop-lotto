package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private List<Integer> lottoNumbers;
    private List<Integer> lotto = new ArrayList<>();

    public LottoNumbers() {
        // 로또 번호 랜덤 생성 및 exception 처리
    }

    public List<Lotto> makeList(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<count; i++) {
            lottos.add(makeLottos());
        }
        return lottos;
    }

    private Lotto makeLottos() {
        lotto = selecting();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    public List<Integer> selecting() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    // 로또 번호 범위 확인
    public Lotto checkOutOfRange(Lotto userLottoNumber) {
        List<Integer> userLottoNum = userLottoNumber.getLottoNumbers();
        for(int i=0; i<userLottoNum.size();i++) {
            if(userLottoNum.get(i) < 1 || userLottoNum.get(i) > 45) {
                ExceptionMessage.outOfRange();
                throw new IllegalArgumentException();
            }
        }
        return userLottoNumber;
    }

    // 선택한 6개의 숫자와 보너스 숫자 중복 확인 로직
    public int checkDuplication(Lotto selectNumber, int bonusNumber) {
        List<Integer> selectLottoNum = selectNumber.getLottoNumbers();
        if(selectLottoNum.contains(bonusNumber)) {
            ExceptionMessage.duplicate();
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

}