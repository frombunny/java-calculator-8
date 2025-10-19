package calculator.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void 정상적으로_수_리스트가_생성되었을_경우_합을_정상적으로_반환한다() {
        Calculator calculator = new Calculator();
        int sum = calculator.calculateSum(List.of(1, 2, 3, 4));

        Assertions.assertEquals(10, sum);
    }

    @Test
    void 리스트의_크기가_0일_경우_합을_정상적으로_반환한다() {
        Calculator calculator = new Calculator();
        List<Integer> emptyList = new ArrayList<>();
        int sum = calculator.calculateSum(emptyList);

        Assertions.assertEquals(0, sum);
    }
}
