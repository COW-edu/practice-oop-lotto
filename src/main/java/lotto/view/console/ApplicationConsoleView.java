package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;
import lombok.RequiredArgsConstructor;
import lotto.core.Message;
import lotto.lotto.domain.*;
import lotto.view.ApplicationView;
import lotto.view.MessageConverter;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ApplicationConsoleView implements ApplicationView {

    private static final String SEPARATOR = ",";
    private static final String LINE_BREAK = "\n";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String LOTTO_RESULTS_OUTPUT_INTRO_MESSAGE = "당첨통계\n---\n";
    private static final String BONUS_NUMBER_OUTPUT_MESSAGE = ", 보너스 볼 일치";
    private static final String PURCHASED_LOTTO_OUTPUT_INTRO_MESSAGE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String RETURN_RATE_OUTPUT_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final String MATCHED_NUMBERS_OUTPUT_MESSAGE_FORMAT = "%d개 일치";
    private static final String WINNING_PRICE_AND_MATCHED_LOTTO_OUTPUT_MESSAGE_FORMAT = " (%s원) - %d개\n";
    public static final double PERCENT_VALUE = 100.0;

    private final MessageConverter<Lotto> lottoMessageConverter;

    @Override
    public void printListLotto(List<Lotto> purchasedLotto) {
        var messageBuilder = new StringBuilder(purchasedLotto.size() * 2);
        var introMessage = String.format(PURCHASED_LOTTO_OUTPUT_INTRO_MESSAGE_FORMAT, purchasedLotto.size());
        messageBuilder.append(introMessage);

        purchasedLotto.forEach(lotto -> {
            var lottoMessage = lottoMessageConverter.convert(lotto);
            messageBuilder.append(lottoMessage);
            messageBuilder.append(LINE_BREAK);
        });

        var message = messageBuilder.toString();
        print(message);
    }

    @Override
    public void printListLottoReward(List<Lotto> allLotto) {
        var rewards = allLotto.stream().filter(Lotto::isWin).map(Lotto::getReward).collect(Collectors.toList());
        var messageBuilder = new StringBuilder();
        var matchingInfoToRewards = rewards.stream().collect(Collectors.groupingBy(LottoReward::getMatchingInfo));
        messageBuilder.append(LOTTO_RESULTS_OUTPUT_INTRO_MESSAGE);

        // 리워드 메세지
        LottoMatcher.REWARDS.stream().sorted(Comparator.comparingInt(LottoReward::getWinningPrice)).forEach(reward -> {
            messageBuilder.append(String.format(MATCHED_NUMBERS_OUTPUT_MESSAGE_FORMAT, reward.getMatchedNumbers()));

            if (reward.getMatchedBonusNumbers() != 0) {
                messageBuilder.append(BONUS_NUMBER_OUTPUT_MESSAGE);
            }

            int totalRewardCount = matchingInfoToRewards.getOrDefault(reward.getMatchingInfo(), Collections.emptyList()).size();
            String formattedPrice = NumberFormat.getInstance().format(reward.getWinningPrice());
            messageBuilder.append(String.format(WINNING_PRICE_AND_MATCHED_LOTTO_OUTPUT_MESSAGE_FORMAT, formattedPrice, totalRewardCount));
        });

        // 수익률
        var totalWinningPrice = matchingInfoToRewards.values().stream().mapToDouble(lottoRewards -> lottoRewards.get(0).getWinningPrice() * lottoRewards.size()).sum();
        var purchasePrice = allLotto.size() * LottoFactory.LOTTO_PRICE;
        var returnRate = (totalWinningPrice / purchasePrice) * PERCENT_VALUE;
        messageBuilder.append(String.format(RETURN_RATE_OUTPUT_MESSAGE_FORMAT, returnRate));

        var message = messageBuilder.toString();
        print(message);
    }

    @Override
    public void printErrorMessage(String message) {
        print(ERROR_MESSAGE_PREFIX + message);
    }

    @Override
    public int getPurchasedPrice() {
        print(Message.REQUEST_PURCHAGE_PRICE);
        return Integer.parseInt(getInput());
    }


    @Override
    public List<Integer> getWinningNumbers() {
        print(Message.REQUEST_WINNING_NUMBERS);
        var inputWinningNumbers = getInput();

        return Arrays.stream(inputWinningNumbers.split(SEPARATOR))
                     .map(Integer::valueOf)
                     .collect(Collectors.toList());
    }

    @Override
    public int getBonusNumber() {
        print(Message.REQUEST_BONUS_NUMBER);
        return Integer.parseInt(getInput());
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String getInput() {
        return Console.readLine();
    }
}
