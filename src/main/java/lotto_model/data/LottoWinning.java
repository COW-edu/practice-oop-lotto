package lotto_model.data;

import lotto_model.lotto.LottoRank;

public interface LottoWinning {
    void addFirst();
    void addSecond();
    void addThird();
    void addFourth();
    void addFifth();

    int getQuantity(LottoRank lottoRank);
}
