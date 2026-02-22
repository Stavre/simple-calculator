package tokens.operations;

import tokens.Token;
import java.util.Stack;

public interface Operation extends Token {
    Associativity getAssociativity();
}
