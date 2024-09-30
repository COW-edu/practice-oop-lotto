package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {
	//
    private static final int LOTTO_PRICE = 1000;

    //method
    public void start() {
    	//구성요소 
        int money = getMoney();
        int lottoCount = getLottoCount(money);
        List<Lotto> boughtLottos = buyLottos(lottoCount);
        printLottos(boughtLottos);
        
        // 사용자가 당첨 번호와 보너스 번호 입력
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        // Lotto 클래스에서 자동 생성된 번호와 비교
        calculateResults(boughtLottos, winningNumbers, bonusNumber);
    }

    //Input
    //입금
    private int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return validateMoney(input);
    }
    //잘못된 입금 시 에러 처리
    private int validateMoney(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요.");
        }
        int money = Integer.parseInt(input);
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
        return money;
    }
    // how many bought lottos
    private int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
    // generate lotto (manually) 
    private List<Lotto> buyLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseWinningNumbers(input);
    }
    
    //,로 파싱 => indentation 수정 예정
    private List<Integer> parseWinningNumbers(String input) {
        String[] tokens = input.split(",");
        if (tokens.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이여야 합니다.");
            }
            numbers.add(number);
        }
        if (HasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
        return numbers;
    }

    private boolean HasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input.trim());
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않는 번호여야 합니다.");
        }
        return bonusNumber;
    }

    
    //Output
    // 얼마나 구입했는지 출력
    private void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    
    //로또 결과 출력
    private void calculateResults(List<Lotto> boughtLottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[7];
        for (Lotto lotto : boughtLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = (lotto.getBonusNumber() == bonusNumber);
            matchCounts[getResultIndex(matchCount, bonusMatch)]++;
        }
        printStatistics(matchCounts);
    }

    //로또 맞은 개수 출력
    private int getMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
    //1등과 2등 구분
    private int getResultIndex(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return 6;
        if (matchCount == 5 && bonusMatch) return 5;
        return matchCount;
    }
    
    //통계 출력
    private void printStatistics(int[] matchCounts) {
        System.out.println("3개 일치 (5,000원) - " + matchCounts[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts[5] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[6] + "개");
        calculateProfit(matchCounts);
    }
    
    //수익률 출력
    private void calculateProfit(int[] matchCounts) {
        double totalPrize = matchCounts[3] * 5000 + matchCounts[4] * 50000 + matchCounts[5] * 1500000 + matchCounts[6] * 2000000000;
        double profitRate = (totalPrize / (matchCounts.length * LOTTO_PRICE)) * 100;
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
