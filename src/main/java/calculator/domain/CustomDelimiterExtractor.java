package calculator.domain;

public class CustomDelimiterExtractor {
    private static final String PREFIX = "//";
    private static final String SUFFIX = "\n";

    public char extractDelimiter(String input) {
        int start = input.indexOf(PREFIX);
        int end = input.indexOf(SUFFIX);

        String delimiter = input.substring(start, end + 1);
        delimiter = delimiter.replaceFirst(PREFIX, "");

        end = delimiter.lastIndexOf(SUFFIX);
        delimiter = delimiter.substring(0, end);

        return delimiter.charAt(0);
    }
}
