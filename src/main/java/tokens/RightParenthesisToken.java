package tokens;

import java.math.BigDecimal;

public class RightParenthesisToken implements Token {

    @Override
    public BigDecimal getValue() {
        throw new UnsupportedOperationException("This is a right parenthesis. It does not have a value");
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.PARENTHESIS;
    }
}
