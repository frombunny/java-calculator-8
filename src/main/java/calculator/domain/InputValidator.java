package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private static final String CUSTOM_DELIMITER_REGEXP = "^//(.)\\\\n.*";
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private static final String SUFFIX = "\\n";
    private final List<Character> delimiters = new ArrayList<>(List.of(':', ','));
    private final List<Integer> nums = new ArrayList<>();

    public InputValidator(CustomDelimiterExtractor customDelimiterExtractor) {
        this.customDelimiterExtractor = customDelimiterExtractor;
    }

    public void validInput(String input) {
        if (input.equals(" ")) {
            throw new IllegalArgumentException();
        }

        if (input.matches(CUSTOM_DELIMITER_REGEXP)) {
            char customDelimiter = customDelimiterExtractor.extractDelimiter(input);

            if (Character.isDigit(customDelimiter)) {
                throw new IllegalArgumentException();
            }
            delimiters.add(customDelimiter); // 구분자에 커스텀 구분자 추가

            int idx = input.indexOf(SUFFIX) + SUFFIX.length();
            input = input.substring(idx); // input에서 커스텀 구분자 지정 형식을 제거
        }
        parseInput(input);
    }

    private void parseInput(String input) {
        StringBuilder sb = new StringBuilder(input);
        StringBuilder num = new StringBuilder();

        while (!sb.isEmpty()) {
            char ch = sb.charAt(0);

            if (delimiters.contains(ch)) {
                if (!num.isEmpty()) {
                    nums.add(Integer.parseInt(String.valueOf(num)));
                    num = new StringBuilder();
                }
            } else if (Character.isDigit(ch)) {
                num.append(ch);
            } else {
                throw new IllegalArgumentException();
            }
            sb.deleteCharAt(0);
        }

        if (!num.isEmpty()) {
            nums.add(Integer.parseInt(String.valueOf(num)));
        }

        for (Integer i : nums) {
            System.out.println(i);

        }
    }


}