package tokens;

import java.math.BigDecimal;

public class LeftParenthesisToken implements Token {

    @Override
    public BigDecimal getValue() {
        throw new UnsupportedOperationException("This is a left parenthesis. It does not have a value");
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.PARENTHESIS;
    }
}
