package calculator.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    @Test
    void 정상_입력은_숫자_리스트로_파싱된다() {
        CustomDelimiterHandler customDelimiterHandler = new CustomDelimiterHandler();
        InputParser inputParser = new InputParser(customDelimiterHandler);
        String input = inputParser.refineInput("//;\\n1;2,3:4");

        List<Integer> result = inputParser.parseInput(input);
        Assertions.assertEquals(List.of(1, 2, 3, 4), result);
    }

    @Test
    void 입력에_구분자와_양수가_아닌_문자가_존재한다면_예외를_던진다() {
        CustomDelimiterHandler customDelimiterHandler = new CustomDelimiterHandler();
        InputParser inputParser = new InputParser(customDelimiterHandler);
        String input = inputParser.refineInput("//;\\n1;2,3@4");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputParser.parseInput(input);
        });
    }
}
