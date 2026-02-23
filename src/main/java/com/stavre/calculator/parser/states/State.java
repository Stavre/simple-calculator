package com.stavre.calculator.parser.states;

import com.stavre.calculator.tokens.Token;

@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface State {
    void readToken(Token token);
}
