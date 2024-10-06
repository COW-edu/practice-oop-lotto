package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoSeller {
    public List<Lotto> sellLotto(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(Constant.ERROR_INVALID_AMOUNT);
        }
        int ticketCount = amount / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new Lotto(generateRandomNumbers()));
        }
        return lottoTickets;
    }

    private List<Integer> generateRandomNumbers() {
        Random random = new Random();
        return random.ints(1, 46)  // 1 ~ 45 사이의 난수 생성
                .distinct()             // 중복 제거
                .limit(6)               // 6개의 숫자만 선택
                .boxed()                // int형을 Integer로 변환
                .collect(Collectors.toList());  // 리스트로 수집
    }
}

