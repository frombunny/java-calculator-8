package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public List<Integer> parseInput(String input, List<Character> delimiters) {
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
}
