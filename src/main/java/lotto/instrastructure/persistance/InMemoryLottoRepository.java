package lotto.instrastructure.persistance;

import lotto.lotto.domain.Lotto;
import lotto.lotto.port.out.LottoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryLottoRepository implements LottoRepository {

    private final Map<String, Lotto> db = new ConcurrentHashMap<>();

    @Override
    public void saveAll(List<Lotto> purchasedLotto) {
        purchasedLotto.forEach(lotto -> db.put(lotto.getId(), lotto));
    }

    @Override
    public List<Lotto> findAll() {
        return db.values().stream().sorted(Comparator.comparing(Lotto::getId)).collect(Collectors.toList());
    }
}
