package com.stavre.calculator.tokens.operations.operators;

import java.math.BigDecimal;
import java.util.Stack;
import com.stavre.calculator.tokens.Token;
import com.stavre.calculator.tokens.operands.NumberToken;

public class MinusToken implements Operator {

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
