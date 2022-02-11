package calculator;

import java.util.Arrays;
import java.util.Objects;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }

        String[] splitValues = text.split("[,:]");
        return sum(splitValues);
    }

    private static int sum(String[] values) {
        return Arrays.stream(values)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
