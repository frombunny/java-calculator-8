package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final InputView inputView;
    private final InputValidator inputValidator;
    private final InputParser inputParser;
    private final Calculator calculator;
    private final OutputView outputView;

    private List<Character> delimiters = new ArrayList<>(List.of(',', ':'));
    private List<Integer> nums = new ArrayList<>();

    public StringCalculator(InputView inputView, InputValidator inputValidator, InputParser inputParser,
                            Calculator calculator, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
        this.calculator = calculator;
        this.outputView = outputView;
    }

    public void run() {
        String input = inputView.readInput();

        input = inputValidator.validInput(input);

        nums = inputParser.parseInput(input, delimiters);
        int sum = calculator.calculateSum(nums);

        outputView.printOutput(sum);
    }
}
