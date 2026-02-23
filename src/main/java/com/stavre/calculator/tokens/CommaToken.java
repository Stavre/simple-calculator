package com.stavre.calculator.tokens;

import java.math.BigDecimal;

public class CommaToken implements Token {

    @Override
    public BigDecimal getValue() {
        throw new UnsupportedOperationException("This is a comma. It does not have a value");
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.COMMA;
    }
}
