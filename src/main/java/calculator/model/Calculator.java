package calculator.model;

import java.util.List;

public class Calculator {
    public int calculateSum(List<Integer> nums) {
        int sum = 0;

        for (Integer num : nums) {
            sum += num;
        }

        return sum;
    }
}