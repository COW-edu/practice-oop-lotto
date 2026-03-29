package domain;
import enums.ErrorMessage;

public class BonusNumber {
    private final int number;

    public BonusNumber(String bonus, Lotto winLotto) {
        int parsed = parse(bonus);
        validateRange(parsed);
        validateDuplicate(parsed, winLotto);
        this.number = parsed;
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input.trim());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validateRange(int number) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.NOT_RANGE.getMessage());
            }
    }
    private void validateDuplicate(int number, Lotto winLotto) {
        if (winLotto.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}