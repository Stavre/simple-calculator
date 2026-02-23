package com.stavre.calculator.tokens.operations.functions;

import java.math.BigDecimal;
import com.stavre.calculator.tokens.TokenType;
import com.stavre.calculator.tokens.operations.Operation;

@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface Function extends Operation {
    @Override
    default TokenType getTokenType() {
        return TokenType.FUNCTION;
    }

    @Override
    default int getPrecedence() {
        return 4;
    }

    @Override
    default BigDecimal getValue() {
        throw new UnsupportedOperationException("A function does not have a value");
    }
}
