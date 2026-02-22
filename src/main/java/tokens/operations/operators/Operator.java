package tokens.operations.operators;

import tokens.TokenType;
import tokens.operations.Associativity;
import tokens.operations.Operation;

import java.math.BigDecimal;


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
        throw new UnsupportedOperationException("This is an operator. It does not have a value. Maybe you are looking for evaluate() method");
    }
}
