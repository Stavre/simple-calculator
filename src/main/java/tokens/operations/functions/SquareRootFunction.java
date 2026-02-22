package tokens.operations.functions;

import tokens.Token;
import tokens.TokenType;
import tokens.operands.NumberToken;
import tokens.operations.Associativity;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

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
