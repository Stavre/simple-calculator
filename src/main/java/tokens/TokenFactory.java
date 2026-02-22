package tokens;

import lombok.NonNull;
import org.apache.commons.lang3.math.NumberUtils;
import tokens.operands.NumberToken;
import tokens.operations.functions.SquareRootFunction;
import tokens.operations.operators.*;

import java.util.Map;

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
