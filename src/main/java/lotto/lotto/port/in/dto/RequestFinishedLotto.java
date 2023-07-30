package lotto.lotto.port.in.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class RequestFinishedLotto {
    final List<Integer> winningNumbers;
    final int bonusNumber;
}
