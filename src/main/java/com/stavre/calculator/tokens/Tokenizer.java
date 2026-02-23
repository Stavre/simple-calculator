package com.stavre.calculator.tokens;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Tokenizer {
    public static List<Token> tokenize(String expression) {
        validateNumberOfParenthesis(expression);
        return Arrays
                .stream(expression.split(" "))
                .filter(x -> !x.isBlank())
                .map(TokenFactory::getToken)
                .toList();
    }

    private static void validateNumberOfParenthesis(String expression) {
        long leftParenthesis = StringUtils.countMatches(expression, "(");
        long rightParenthesis = StringUtils.countMatches(expression, ")");

        if (leftParenthesis != rightParenthesis) {
            throw new IllegalArgumentException("Expression contains %s left parenthesis but only %s right parenthesis."
                    .formatted(leftParenthesis, rightParenthesis));
        }
    }
}
