package com.stavre.calculator.parser.states;

import com.stavre.calculator.parser.Parser;
import com.stavre.calculator.tokens.Token;

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
