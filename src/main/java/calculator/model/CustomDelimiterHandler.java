package calculator.model;

public class CustomDelimiterHandler {
    private static final String PREFIX = "//";
    private static final String SUFFIX = "\\n";

    public String handleCustomDelimiter(String input) {
        int idx = input.indexOf(SUFFIX) + SUFFIX.length();
        input = input.substring(idx); // input에서 커스텀 구분자 지정 형식을 제거

        return input;
    }

    public char extractCustomDelimiter(String input) {
        int start = input.indexOf(PREFIX);
        int end = input.indexOf(SUFFIX);

        String delimiterFormat = input.substring(start, end + SUFFIX.length());
        delimiterFormat = delimiterFormat.replaceFirst(PREFIX, "");

        end = delimiterFormat.lastIndexOf(SUFFIX);
        delimiterFormat = delimiterFormat.substring(0, end);

        char delimiter = delimiterFormat.charAt(0);

        if (Character.isDigit(delimiter)) {
            throw new IllegalArgumentException();
        }

        return delimiter;
    }
}