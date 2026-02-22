package parser.states;

import parser.Parser;
import tokens.Token;

public class OperandState implements State {
    private final Parser parser;

    public OperandState(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void readToken(Token token) {
        parser.addTokenToOutput(token);
    }
}
