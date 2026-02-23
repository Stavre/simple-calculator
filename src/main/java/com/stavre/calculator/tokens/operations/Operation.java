package com.stavre.calculator.tokens.operations;

import com.stavre.calculator.tokens.Token;

public interface Operation extends Token {
    Associativity getAssociativity();
}
