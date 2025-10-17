package calculator;

import calculator.domain.Calculator;
import calculator.domain.CustomDelimiterHandler;
import calculator.domain.InputParser;
import calculator.domain.InputValidator;
import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator inputValidator = new InputValidator();
        CustomDelimiterHandler customDelimiterHandler = new CustomDelimiterHandler();
        InputParser inputParser = new InputParser(customDelimiterHandler);
        Calculator calculator = new Calculator();

        StringCalculator stringCalculator = new StringCalculator(inputView, inputValidator, inputParser, calculator,
                outputView);

        stringCalculator.run();
    }
}
