package lotto.lottoAppTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.entity.Lotto;
import lotto.entity.LottoListClass;
import lotto.entity.WinLottoListClass;
import lotto.logic.Judgment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgmentTest {

    private Lotto lotto;
    private WinLottoListClass winLottoListClass;
    private LottoListClass lottoListsClass;

    @BeforeEach
    void setUp() {
        List<Integer> lottoRow = Arrays.asList(1, 2, 3, 4, 5, 7);
        lotto = new Lotto(lottoRow);
        ArrayList<Lotto> lottoLists = new ArrayList<>();
        lottoLists.add(lotto);
        lottoListsClass = new LottoListClass(lottoLists);
        List<Integer> winLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winLottoListClass = new WinLottoListClass(winLottoNumbers);
        winLottoListClass.setBonusNumber(7);
    }

    @Test
    @DisplayName("보너스 번호 판단 테스트")
    void judgeProcessTest() {
        Judgment judgment = new Judgment(lottoListsClass.getLottoLists(), winLottoListClass);

        assertThat(judgment.bonusCheck(lotto)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 한줄 비교 테스트")
    void rowCompareTest() {
        Judgment judgment = new Judgment(lottoListsClass.getLottoLists(), winLottoListClass);
        judgment.setWinLottoList(winLottoListClass);

        assertThat(judgment.rowCompare(lotto)).isEqualTo(7);
    }
}
