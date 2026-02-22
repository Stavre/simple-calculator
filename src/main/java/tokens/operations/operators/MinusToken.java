package tokens.operations.operators;

import tokens.Token;
import tokens.operands.NumberToken;
import tokens.operations.Associativity;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.Stack;

public class MinusToken implements Operator {
//    private final TokenType type = TokenType.MINUS;

    @Override
    public NumberToken evaluate(Stack<Token> tokens) {
        BigDecimal b = tokens.pop().getValue();
        BigDecimal a = tokens.pop().getValue();

        return new NumberToken(a.subtract(b));
    }

    @Override
    public int getPrecedence() {
        return 2;
    }

}
