package com.stavre.calculator.tokens.operations.operators;

import java.math.BigDecimal;
import com.stavre.calculator.tokens.TokenType;
import com.stavre.calculator.tokens.operations.Associativity;
import com.stavre.calculator.tokens.operations.Operation;

public interface Operator extends Operation {
    @Override
    default TokenType getTokenType() {
        return TokenType.OPERATOR;
    }

    @Override
    default Associativity getAssociativity() {
        return Associativity.LEFT;
    }

    @Override
    default BigDecimal getValue() {
        throw new UnsupportedOperationException("An operator does not have a value");
    }
}
