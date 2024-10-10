package model.data;

import model.lotto.LottoRank;

public interface LottoWinning {
    void addFirst();
    void addSecond();
    void addThird();
    void addFourth();
    void addFifth();

    int getQuantity(LottoRank lottoRank);
}
