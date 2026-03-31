package kr.abins.lotto.view;

import kr.abins.lotto.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface LottoReader extends Reader {

    static int readPurchaseAmount() throws IllegalArgumentException {
        return Reader.readInt(number -> {
            if (number <= 0) {
                throw new IllegalArgumentException(Constants.ERROR_PURCHASE_AMOUNT_NOT_POSITIVE);
            }
            if (number % 1000 == 0) {
                return;
            }

            throw new IllegalArgumentException(Constants.ERROR_PURCHASE_AMOUNT_NOT_DIVISIBLE);
        });
    }
}
