package com.stavre.calculator.tokens;

import java.util.Map;
import lombok.NonNull;
import org.apache.commons.lang3.math.NumberUtils;
import com.stavre.calculator.tokens.operands.NumberToken;
import com.stavre.calculator.tokens.operations.functions.SquareRootFunction;
import com.stavre.calculator.tokens.operations.operators.DivisionToken;
import com.stavre.calculator.tokens.operations.operators.MinusToken;
import com.stavre.calculator.tokens.operations.operators.MultiplyToken;
import com.stavre.calculator.tokens.operations.operators.PlusToken;
import com.stavre.calculator.tokens.operations.operators.PowerToken;

public class TokenFactory {
    
    private static final Map<String, Token> types = Map.of(
            "+", new PlusToken(),
            "-", new MinusToken(),
            "/", new DivisionToken(),
            "*", new MultiplyToken(),
            "^", new PowerToken(),
            "sqrt", new SquareRootFunction(),
            ",", new CommaToken(),
            "(", new LeftParenthesisToken(),
            ")", new RightParenthesisToken()
    );

    public static Token getToken(@NonNull String exp) {
        
        if (NumberUtils.isParsable(exp)) {
            return new NumberToken(exp);
        }
        if (!types.containsKey(exp)) {
            throw new IllegalArgumentException("Symbol %s is not recognized".formatted(exp));
        }
        
        return types.get(exp);
    }
}
