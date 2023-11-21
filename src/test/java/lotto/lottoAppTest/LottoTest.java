package lotto.lottoAppTest;

import static lotto.constant.LottoRule.LOTTO_ROW_SIZE;

import java.util.List;
import java.util.stream.Stream;
import lotto.entity.Lotto;
import lotto.logic.LottoMachineImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또 머신 테스트")
    @Test
    void lottoNumberSizeTest() {
        LottoMachineImpl lottoMachineImpl = new LottoMachineImpl();
        int count = 1;
        List<Lotto> lottoList;

        lottoList = lottoMachineImpl.playLotto(count);
        Stream<Lotto> lottoStream = lottoList.stream();

        lottoStream.forEach(lotto ->
            Assertions.assertEquals(LOTTO_ROW_SIZE, lotto.getNumbers().size())
        );
    }
}
