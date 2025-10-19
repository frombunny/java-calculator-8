package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void 입력이_공백이라면_예외를_던진다() {
        InputValidator inputValidator = new InputValidator();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validInput(" ");
        });
    }

    @Test
    void 입력이_빈_문자열이라면_정상_입력으로_처리한다() {
        InputValidator inputValidator = new InputValidator();

        Assertions.assertDoesNotThrow(() -> inputValidator.validInput(""));
    }
}