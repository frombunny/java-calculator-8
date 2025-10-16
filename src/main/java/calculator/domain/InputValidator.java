package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private static final String CUSTOM_DELIMITER_REGEXP = "^//(.)\\\\n.*";
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final InputParser inputParser;
    private static final String SUFFIX = "\\n";
    public final List<Character> delimiters = new ArrayList<>(List.of(':', ','));

    public InputValidator(CustomDelimiterExtractor customDelimiterExtractor, InputParser inputParser) {
        this.customDelimiterExtractor = customDelimiterExtractor;
        this.inputParser = inputParser;
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

        inputParser.parseInput(input, delimiters);
    }
}