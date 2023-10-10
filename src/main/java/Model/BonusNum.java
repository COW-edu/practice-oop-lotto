package Model;

public class BonusNum {
    private final int bonusNumber;

    public BonusNum(String bonusNumberInput) {
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
        Validator.validateBonus(String.valueOf(bonusNumber));
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
