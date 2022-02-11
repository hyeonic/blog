package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }

        return sum(split(text));
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split("[,:]");
    }

    private static int sum(String[] values) {
        return Arrays.stream(values)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
