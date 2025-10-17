package calculator.contoroller;

import calculator.model.Calculator;
import calculator.model.InputParser;
import calculator.model.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class StringCalculator {
    private final InputView inputView;
    private final InputValidator inputValidator;
    private final InputParser inputParser;
    private final Calculator calculator;
    private final OutputView outputView;

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

        inputValidator.validInput(input);

        input = inputParser.refineInput(input);
        List<Integer> nums = inputParser.parseInput(input);
        int sum = calculator.calculateSum(nums);

        outputView.printOutput(sum);
    }
}
