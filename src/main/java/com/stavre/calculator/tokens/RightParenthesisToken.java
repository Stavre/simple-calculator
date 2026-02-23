package com.stavre.calculator.tokens;

import java.math.BigDecimal;

public class RightParenthesisToken implements Token {

    @Override
    public BigDecimal getValue() {
        throw new UnsupportedOperationException("A right parenthesis does not have a value");
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.PARENTHESIS;
    }
}
