package lotto_model;

public interface LottoWinning {
    void addFirst();
    void addSecond();
    void addThird();
    void addFourth();
    void addFifth();

    int getQuantity(LottoRank lottoRank);
}
