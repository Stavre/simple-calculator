package tokens;

//import validation.ValidateInput;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {
    public static List<Token> tokenize(String expression) {
        validateNumberOfParenthesis(expression);
        return Arrays
                .stream(expression.split(" "))
                .filter(x -> !x.isEmpty() && !x.isBlank())
                .map(TokenFactory::getToken)
                .toList();
    }

    private static void validateNumberOfParenthesis(String expression) {
        long leftParenthesis = StringUtils.countMatches(expression, "(");
        long rightParenthesis = StringUtils.countMatches(expression, ")");

        if (leftParenthesis != rightParenthesis) {
            throw new IllegalArgumentException("Expression contains %s left parenthesis but only %s right parenthesis.".formatted(leftParenthesis, rightParenthesis));
        }
    }
}
