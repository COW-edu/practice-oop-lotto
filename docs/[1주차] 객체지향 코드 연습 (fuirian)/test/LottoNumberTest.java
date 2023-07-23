package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

  @DisplayName("로또 번호 예외 테스트")
  @Test
  public void testLottoNumbers() {
    // given
    LottoNumber lottoNumber = new LottoNumber();

    // when
    lottoNumber.addNumber(1);
    lottoNumber.addNumber(2);
    lottoNumber.addNumber(3);

    // then
    assertThat(lottoNumber.getSize()).isEqualTo(3);

    // 유효하지 않은 번호(중복 번호)를 추가하면 IllegalArgumentException이 발생해야 합니다.
    assertThatThrownBy(() -> lottoNumber.addNumber(1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("중복된 번호");

    // 유효하지 않은 번호(1보다 작은 값)를 추가하면 IllegalArgumentException이 발생해야 합니다.
    assertThatThrownBy(() -> lottoNumber.addNumber(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("유효하지 않은 번호");

    // 유효하지 않은 번호(45보다 큰 값)를 추가하면 IllegalArgumentException이 발생해야 합니다.
    assertThatThrownBy(() -> lottoNumber.addNumber(46))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("유효하지 않은 번호");
  }
}

