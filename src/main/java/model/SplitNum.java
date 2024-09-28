package model;

import java.util.ArrayList;
import java.util.List;

public class SplitNum {
    // String 분리하여 배열에 저장하고 배열을 리턴하는 메서드
    private static List<Integer> SplitNum(String numbers) {
        List<Integer> result = new ArrayList<>();

        String[] number = numbers.split(",");
        for (int i = 0; i < number.length; i++) {
            result.add(Integer.parseInt(number[i]));
        }

        return result;
    }

}
