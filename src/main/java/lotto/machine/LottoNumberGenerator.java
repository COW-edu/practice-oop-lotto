package lotto.machine;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.repository.Memory;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    public void generateNumbers(Memory memory) {
        int ticketCount = memory.getTicketCount();

        // Stream을 사용해 티켓 개수만큼 로또 번호 생성 후 Memory에 저장
        IntStream.range(0, ticketCount)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()  // 오름차순 정렬
                        .collect(Collectors.toList()))
                .forEach(memory::saveGeneratedNumbers);  // 생성된 번호를 Memory에 저장
    }
}
