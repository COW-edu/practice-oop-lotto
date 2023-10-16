package Model;

import static Model.Validator.validateBonus;

public class BonusNum {
    private static int bonusNumber = 0;

    public BonusNum(String bonusNumberInput) {
        bonusNumber = Integer.parseInt(bonusNumberInput);
    }
    public void validate_Bonus(String bonusNumberInput){
        validateBonus(bonusNumberInput);
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }
}
