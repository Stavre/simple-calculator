package tokens.operations.functions;

import tokens.TokenType;
import tokens.operations.Operation;

import java.math.BigDecimal;

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
        throw new UnsupportedOperationException("This is a function. It does not have a value. Maybe you are looking for evaluate() method");
    }
}
