package view;

import camp.nextstep.edu.missionutils.Console;
import global.enums.ErrorMessage;

public class InputView {
    public int getPurchaseAmount(){
        while(true){
            try{
                System.out.println("구입 금액을 입력해주세요.");
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        try {
            if (purchaseAmount <= 0) {
                throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
            }
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }
}
