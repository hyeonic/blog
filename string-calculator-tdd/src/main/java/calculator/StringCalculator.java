package calculator;

import java.util.Objects;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(text);
    }
}
