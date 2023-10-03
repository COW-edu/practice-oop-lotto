package lotto;

public class BonusNum {
    private final int bonusNumber;

    public BonusNum(String bonusNumberInput) {
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
        Validate.validate_Bonus(String.valueOf(bonusNumber));
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
