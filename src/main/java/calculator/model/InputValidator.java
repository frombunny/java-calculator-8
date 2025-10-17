package calculator.model;

public class InputValidator {
    public void validInput(String input) {
        if (!input.isEmpty() && input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}