package calculator.domain;

public class InputValidator {
    private static final String CUSTOM_DELIMITER_REGEXP = "^//(.)\\\\n.*";
    private final CustomDelimiterHandler customDelimiterHandler;

    public InputValidator(CustomDelimiterHandler customDelimiterHandler) {
        this.customDelimiterHandler = customDelimiterHandler;
    }

    public String validInput(String input) {
        if (!input.isEmpty() && input.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (input.matches(CUSTOM_DELIMITER_REGEXP)) {
            input = customDelimiterHandler.handleCustomDelimiter(input);
        }
        return input;
    }
}