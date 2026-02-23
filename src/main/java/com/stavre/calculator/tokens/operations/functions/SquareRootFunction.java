package com.stavre.calculator.tokens.operations.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;
import com.stavre.calculator.tokens.Token;
import com.stavre.calculator.tokens.TokenType;
import com.stavre.calculator.tokens.operands.NumberToken;
import com.stavre.calculator.tokens.operations.Associativity;

public class SquareRootFunction implements Function {

    @Override
    public NumberToken evaluate(Stack<Token> tokens) {
        BigDecimal a = tokens.pop().getValue();

        return new NumberToken(a.sqrt(new MathContext(4, RoundingMode.HALF_EVEN)));
    }

    @Override
    public Associativity getAssociativity() {
        return Associativity.RIGHT;
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.FUNCTION;
    }
}
