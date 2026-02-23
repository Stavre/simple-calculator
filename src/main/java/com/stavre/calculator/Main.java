package com.stavre.calculator;

import java.io.Console;
import java.math.BigDecimal;
import java.util.List;
import com.stavre.calculator.parser.Parser;
import com.stavre.calculator.tokens.Token;
import com.stavre.calculator.tokens.Tokenizer;

public class Main {

    public static void main(String[] args) {
        if (invalidArguments(args)) {
            throw new IllegalArgumentException("Invalid number of arguments. Expected exactly one argument.");
        }
        Console console = System.console();
        Parser parser = new Parser();
        List<Token> tokens = Tokenizer.tokenize(args[0]);
        BigDecimal res = parser.evaluate(tokens);
        console.printf("result is: %s", res);
    }

    private static boolean invalidArguments(String... args) {
        return args.length != 1;
    }
}