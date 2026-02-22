package parser.states;

import tokens.Token;

@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface State {
    void readToken(Token token);
}
