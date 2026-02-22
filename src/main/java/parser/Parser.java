package parser;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;
import lombok.Getter;
import parser.states.FunctionState;
import parser.states.OperandState;
import parser.states.OperatorState;
import parser.states.ParenthesisState;
import parser.states.State;
import tokens.Token;
import tokens.TokenType;
import tokens.TokenUtils;
import tokens.operations.Operation;

public class Parser {

    State operandState = new OperandState(this);
    State operatorState = new OperatorState(this);
    State parenthesisState = new ParenthesisState(this);
    State functionState = new FunctionState(this);
    @Getter
    State currentState;

    Stack<Token> operationStack = new Stack<>();
    @Getter
    Stack<Token> outputStack = new Stack<>();

    private State getStateForToken(Token token) {
        return switch (token.getTokenType()) {
            case OPERAND -> operandState;
            case FUNCTION -> functionState;
            case OPERATOR -> operatorState;
            case PARENTHESIS -> parenthesisState;
            case COMMA -> throw new UnsupportedOperationException();
        };
    }

    public BigDecimal evaluate(List<Token> tokens) {

        for (Token token : tokens) {
            currentState = getStateForToken(token);
            this.currentState.readToken(token);
        }

        while (hasOperationStackElements()) {
            Token op = operationStack.pop();

            if (op instanceof Operation operation) {
                addTokenToOutput(operation.evaluate(outputStack));
            } else {
                throw new IllegalStateException("This is most likely parenthesis");
            }
        }
        return outputStack.pop().getValue();
    }

    public void addTokenToOutput(Token token) {
        outputStack.add(token);
    }

    public void addTokenToOperationStack(Token operation) {
        operationStack.add(operation);
    }

    public Token popOperation() {
        return operationStack.pop();
    }

    public Token peekOperation() {
        return operationStack.peek();
    }

    public boolean hasOperationStackElements() {
        return !operationStack.isEmpty();
    }

    public boolean isTopStackLeftParenthesis() {
        return TokenUtils.isTokenLeftParenthesis(peekOperation());
    }

    public boolean isTopOperationStackTokenOfType(TokenType type) {
        return operationStack.peek().getTokenType().equals(type);
    }

    public void addOperationToOutput() {
        Token poppedOperation = popOperation();
        Token newValue = poppedOperation.evaluate(getOutputStack());
        addTokenToOutput(newValue);
    }

    public void discardOperation() {
        popOperation();
    }

    public boolean hasTopOperationGreaterPrecedence(Operation b) {
        return TokenUtils.hasOperationGreaterPrecedence(peekOperation(), b);
    }

    public boolean samePrecedenceOrLeftAssociativity(Operation operation) {
        boolean samePrecedence = TokenUtils.isSamePrecedence(peekOperation(), operation);
        boolean isLeftAssociative = TokenUtils.isOperationLeftAssociativity(operation);
        return samePrecedence && isLeftAssociative;
    }
}
