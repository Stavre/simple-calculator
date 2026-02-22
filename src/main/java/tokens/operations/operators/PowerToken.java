package tokens.operations.operators;

import tokens.Token;
import tokens.operands.NumberToken;
import tokens.operations.Associativity;

import java.math.BigDecimal;
import java.util.Stack;

public class PowerToken implements Operator {

    @Override
    public NumberToken evaluate(Stack<Token> tokens) {
        BigDecimal b = tokens.pop().getValue();
        BigDecimal a = tokens.pop().getValue();

        return new NumberToken(a.pow(b.intValue()));
    }

    @Override
    public int getPrecedence() {
        return 4;
    }

    @Override
    public Associativity getAssociativity() {
        return Associativity.RIGHT;
    }
}
