package lotto;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <T> ArrayList<T> toArrayList(List<T> list) {
        return new ArrayList<>(list);
    }
}
