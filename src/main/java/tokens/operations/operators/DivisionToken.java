package tokens.operations.operators;

import tokens.Token;
import tokens.operands.NumberToken;
import tokens.operations.Associativity;

import java.math.BigDecimal;
import java.util.Stack;


public class DivisionToken implements Operator {

    @Override
    public NumberToken evaluate(Stack<Token> tokens) {
        BigDecimal b = tokens.pop().getValue();
        BigDecimal a = tokens.pop().getValue();

        return new NumberToken(a.divide(b));
    }

    @Override
    public int getPrecedence() {
        return 3;
    }


}
