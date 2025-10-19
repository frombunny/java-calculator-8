package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomDelimiterHandlerTest {
    @Test
    void 정상_입력의_경우_커스텀_구분자를_정상적으로_추출한다() {
        CustomDelimiterHandler customDelimiterHandler = new CustomDelimiterHandler();
        char delimiter = customDelimiterHandler.extractCustomDelimiter("//;\\n1;2,3:4");

        Assertions.assertEquals(';', delimiter);
    }

    @Test
    void 커스텀_구분자가_역슬래시일_경우_커스텀_구분자를_정상적으로_추출한다() {
        CustomDelimiterHandler customDelimiterHandler = new CustomDelimiterHandler();
        char delimiter = customDelimiterHandler.extractCustomDelimiter("//\\\\n2\\3:4");

        Assertions.assertEquals('\\', delimiter);
    }

    @Test
    void 커스텀_구분자가_공백일_경우_커스텀_구분자를_정상적으로_추출한다() {
        CustomDelimiterHandler customDelimiterHandler = new CustomDelimiterHandler();
        char delimiter = customDelimiterHandler.extractCustomDelimiter("// \\n2 3 4");

        Assertions.assertEquals(' ', delimiter);
    }

    @Test
    void 커스텀_구분자가_문자열일_경우_예외를_던진다() {
        CustomDelimiterHandler customDelimiterHandler = new CustomDelimiterHandler();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            customDelimiterHandler.extractCustomDelimiter("//;;\\n2;3;4");
        });
    }

    @Test
    void 커스텀_구분자가_숫자일_경우_예외를_던진다() {
        CustomDelimiterHandler customDelimiterHandler = new CustomDelimiterHandler();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            customDelimiterHandler.extractCustomDelimiter("//2\\n2;3;4");
        });
    }
}
