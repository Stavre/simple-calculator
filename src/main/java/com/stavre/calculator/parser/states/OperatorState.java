package com.stavre.calculator.parser.states;

import com.stavre.calculator.parser.Parser;
import com.stavre.calculator.tokens.Token;
import com.stavre.calculator.tokens.TokenType;
import com.stavre.calculator.tokens.operations.Operation;

public class OperatorState implements State {
    private final Parser parser;

    public OperatorState(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void readToken(Token token) {
        Operation operation = (Operation) token;

        while (parser.hasOperationStackElements()) {

            if (parser.isTopStackLeftParenthesis()) {
                break;
            }

            if (!(parser.isTopOperationStackTokenOfType(TokenType.OPERATOR))) {
                throw new IllegalStateException("TopStack should have been an operation");
            }

            boolean greaterPrecedence = parser.hasTopOperationGreaterPrecedence(operation);
            boolean samePrecedenceOrLeftAssociativity =
                    parser.samePrecedenceOrLeftAssociativity(operation);

            if (!(greaterPrecedence || samePrecedenceOrLeftAssociativity)) {
                break;
            }

            parser.addOperationToOutput();
        }
        parser.addTokenToOperationStack(operation);
    }
}
