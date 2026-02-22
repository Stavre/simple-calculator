package tokens.operands;

import java.math.BigDecimal;
import lombok.ToString;
import tokens.Token;
import tokens.TokenType;

@ToString
public class NumberToken implements Token {

    private final BigDecimal value;

    public NumberToken(BigDecimal value) {
        this.value = value;
    }

    public NumberToken(String value) {
        this.value = new BigDecimal(value);
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.OPERAND;
    }
}
