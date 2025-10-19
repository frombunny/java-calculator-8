package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String CUSTOM_DELIMITER_REGEXP = "^//(.+)\\\\n.*";
    private final CustomDelimiterHandler customDelimiterHandler;
    private final List<Character> delimiters = new ArrayList<>(List.of(',', ':'));

    public InputParser(CustomDelimiterHandler customDelimiterHandler) {
        this.customDelimiterHandler = customDelimiterHandler;
    }

    public List<Integer> parseInput(String input) {
        List<Integer> nums = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (delimiters.contains(ch)) {
                if (!buffer.isEmpty()) {
                    nums.add(Integer.parseInt(String.valueOf(buffer)));
                    buffer = new StringBuilder();
                }
            } else if (Character.isDigit(ch)) {
                buffer.append(ch);
            } else {
                throw new IllegalArgumentException();
            }
        }

        if (!buffer.isEmpty()) {
            nums.add(Integer.parseInt(String.valueOf(buffer)));
        }

        return nums;
    }

    public String refineInput(String input) {
        if (input.matches(CUSTOM_DELIMITER_REGEXP)) {
            char delimiter = customDelimiterHandler.extractCustomDelimiter(input);
            delimiters.add(delimiter);

            input = customDelimiterHandler.handleCustomDelimiter(input);
        }
        return input;
    }
}
