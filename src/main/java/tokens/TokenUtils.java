package tokens;

import lombok.experimental.UtilityClass;
import tokens.operations.Associativity;
import tokens.operations.Operation;

@UtilityClass
public class TokenUtils {

    public boolean isSamePrecedence(Token a, Token b) {
        return a.getPrecedence() == b.getPrecedence();
    }

    public boolean isOperationLeftAssociativity(Operation operation) {
        return operation.getAssociativity().equals(Associativity.LEFT);
    }

    public boolean hasOperationGreaterPrecedence(Token a, Token b) {
        return a.getPrecedence() > b.getPrecedence();
    }

    public boolean isTokenLeftParenthesis(Token token) {
        return (token instanceof LeftParenthesisToken);
    }
}
