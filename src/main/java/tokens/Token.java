package tokens;


import java.math.BigDecimal;
import java.util.Stack;

public interface Token {
    BigDecimal getValue();
    TokenType getTokenType();
    default Token evaluate(Stack<Token> tokens) {
        throw new UnsupportedOperationException();
    }
    default int getPrecedence() {
        throw new UnsupportedOperationException();
    }
}
