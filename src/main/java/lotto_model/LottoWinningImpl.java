package lotto_model;

import lotto_exception.ErrorMessage;

public class LottoWinningImpl implements LottoWinning {
    int first = 0;
    int second = 0;
    int third = 0;
    int fourth = 0;
    int fifth = 0;

    @Override
    public void addFirst() {
        first++;
    }

    @Override
    public void addSecond() {
        second++;
    }

    @Override
    public void addThird() {
        third++;
    }

    @Override
    public void addFourth() {
        fourth++;
    }

    @Override
    public void addFifth() {
        fifth++;
    }

    @Override
    public int getQuantity(LottoRank lottoRank){
        if (lottoRank == LottoRank.FIRST) {
            return first;
        }
        if (lottoRank ==LottoRank.SECOND) {
            return second;
        }
        if (lottoRank == LottoRank.THIRD) {
            return third;
        }
        if (lottoRank == LottoRank.FOURTH) {
            return fourth;
        }
        if (lottoRank == LottoRank.FIFTH) {
            return fifth;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_CORRECT_LEVEL.getErrorMessage());
    }
}
