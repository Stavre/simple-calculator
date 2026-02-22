package parser.states;

import parser.Parser;
import tokens.LeftParenthesisToken;
import tokens.Token;
import tokens.TokenType;

public class ParenthesisState implements State {

    private final Parser parser;

    public ParenthesisState(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void readToken(Token token) {
        if (!token.getTokenType().equals(TokenType.PARENTHESIS)) {
            throw new IllegalArgumentException("Token should have been of parenthesis type");
        }

        if (token instanceof LeftParenthesisToken) {
            parser.addTokenToOperationStack(token);
            return;
        }

        while (!parser.isTopStackLeftParenthesis()) {
            parser.addOperationToOutput();
        }

        parser.discardOperation();

        if (parser.hasOperationStackElements() && parser.isTopOperationStackTokenOfType(TokenType.FUNCTION)) {
            parser.addOperationToOutput();
        }
    }
}
