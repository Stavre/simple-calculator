package parser.states;

import parser.Parser;
import tokens.Token;

public class FunctionState implements State {

    private final Parser parser;

    public FunctionState(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void readToken(Token token) {
        parser.addTokenToOperationStack(token);
    }
}
