package lotto;

import lotto.constants.Message;
import lotto.controller.LotteryHost;
import lotto.validation.LotteryNumberValidator;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        LotteryHost lh = new LotteryHost();
        Output.print(Message.INPUT_AMOUNT.getMessage());
        try {
            user.buyLotto();
            // LotteryHost 에서 로또 생성 후 User 의 LottoTickets 필드에 저장
            user.saveLotto(lh.generateAndSaveLottoTickets(user.getNumberOfLottery()));
            // 로또 매수와 번호 출력
            Output.printLottoNumbersAndQuantity(user.getLottoTickets(), user.getNumberOfLottery());
            // 당첨 번호 입력받기
            Output.print(Message.INPUT_WINNING_NUMBERS.getMessage());
            lh.inputWinningNumbers();
            // 보너스 번호 입력받기
            Output.print(Message.INPUT_BONUS_NUMBER.getMessage());
            lh.inputBonusNumber();
            lh.compareLottoNumbersAndWinningNumbers(user.getLottoTickets());
            // 당첨 통계 출력
            Output.printResult(lh, user.getNumberOfLottery());
        } catch (IllegalArgumentException e) {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
