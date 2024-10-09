package lotto_model.data;

import lotto_exception.ErrorMessage;
import lotto_model.lotto.LottoRank;

public class LottoWinningImpl implements LottoWinning {
    private final static LottoWinningImpl instance = new LottoWinningImpl();

    public static LottoWinningImpl getInstance() {
        return instance;
    }


    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

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
