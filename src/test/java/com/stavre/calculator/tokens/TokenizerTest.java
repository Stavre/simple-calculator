package com.stavre.calculator.tokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.stavre.calculator.tokens.operands.NumberToken;
import com.stavre.calculator.tokens.operations.functions.SquareRootFunction;
import com.stavre.calculator.tokens.operations.operators.MinusToken;
import com.stavre.calculator.tokens.operations.operators.PlusToken;
import com.stavre.calculator.tokens.operations.operators.MultiplyToken;
import com.stavre.calculator.tokens.operations.operators.DivisionToken;
import com.stavre.calculator.tokens.operations.operators.PowerToken;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class TokenizerTest {

    @Test
    public void tokenizeNegativeNumber() {
        List<Token> actual = Tokenizer.tokenize("-2");
        List<Token> expected = List.of(new NumberToken("-2"));
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeNegativeFloatingPointNumber() {
        List<Token> actual = Tokenizer.tokenize("-2.002");
        List<Token> expected = List.of(new NumberToken("-2.002"));
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeNegativeFloatingPointNumberLessThan1() {
        List<Token> actual = Tokenizer.tokenize("-0.002");
        List<Token> expected = List.of(new NumberToken("-0.002"));
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimplePlusOperation() {
        List<Token> actual = Tokenizer.tokenize("2 + 4");
        List<Token> expected = List.of(
                new NumberToken("2"),
                new PlusToken(),
                new NumberToken("4")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimpleMinusOperation() {
        List<Token> actual = Tokenizer.tokenize("2 - 4");
        List<Token> expected = List.of(
                new NumberToken("2"),
                new MinusToken(),
                new NumberToken("4")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimpleMultiplicationOperation() {
        List<Token> actual = Tokenizer.tokenize("2 * 4");
        List<Token> expected = List.of(
                new NumberToken("2"),
                new MultiplyToken(),
                new NumberToken("4")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimpleDivisionOperation() {
        List<Token> actual = Tokenizer.tokenize("2 / 4");
        List<Token> expected = List.of(
                new NumberToken("2"),
                new DivisionToken(),
                new NumberToken("4")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimplePowerOperation() {
        List<Token> actual = Tokenizer.tokenize("2 ^ 4");
        List<Token> expected = List.of(
                new NumberToken("2"),
                new PowerToken(),
                new NumberToken("4")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimpleSquareRootOperation() {
        List<Token> actual = Tokenizer.tokenize("sqrt ( 4 )");
        List<Token> expected = List.of(
                new SquareRootFunction(),
                new LeftParenthesisToken(),
                new NumberToken("4"),
                new RightParenthesisToken()
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeComplexOperation() {
        List<Token> expected = new ArrayList<>();
        expected.add(new LeftParenthesisToken());
        expected.add(new SquareRootFunction());
        expected.add(new LeftParenthesisToken());
        expected.add(new NumberToken("2"));
        expected.add(new PowerToken());
        expected.add(new NumberToken("2"));
        expected.add(new MinusToken());
        expected.add(new NumberToken("6"));
        expected.add(new PlusToken());
        expected.add(new NumberToken("2"));
        expected.add(new MultiplyToken());
        expected.add(new NumberToken("3"));
        expected.add(new LeftParenthesisToken());
        expected.add(new MinusToken());
        expected.add(new NumberToken("2"));
        expected.add(new LeftParenthesisToken());
        expected.add(new DivisionToken());
        expected.add(new NumberToken("2"));
        List<Token> actual = Tokenizer.tokenize("( sqrt ( 2 ^ 2 - 6 + 2 * 3 ) - 2 ) / 2");

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimplePlusOperationWithFloatingNumbers() {
        List<Token> actual = Tokenizer.tokenize("2.0 + 4.34");
        List<Token> expected = List.of(
                new NumberToken("2.0"),
                new PlusToken(),
                new NumberToken("4.34")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimpleMinusOperationWithFloatingNumbers() {
        List<Token> actual = Tokenizer.tokenize("2.002 - 4.9");
        List<Token> expected = List.of(
                new NumberToken("2.002"),
                new MinusToken(),
                new NumberToken("4.9")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimpleMultiplicationOperationWithFloatingNumbers() {
        List<Token> actual = Tokenizer.tokenize("2.9008 * 4.6");
        List<Token> expected = List.of(
                new NumberToken("2.9008"),
                new MultiplyToken(),
                new NumberToken("4.6")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimpleDivisionOperationWithFloatingNumbers() {
        List<Token> actual = Tokenizer.tokenize("2.5058 / 4.862");
        List<Token> expected = List.of(
                new NumberToken("2.5058"),
                new DivisionToken(),
                new NumberToken("4.862")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimplePowerOperationWithFloatingNumbers() {
        List<Token> actual = Tokenizer.tokenize("2.9 ^ 4.6");
        List<Token> expected = List.of(
                new NumberToken("2.9"),
                new PowerToken(),
                new NumberToken("4.6")
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeSimpleSquareRootOperationWithFloatingNumbers() {
        List<Token> actual = Tokenizer.tokenize("sqrt ( 4.6 )");
        List<Token> expected = List.of(
                new SquareRootFunction(),
                new LeftParenthesisToken(),
                new NumberToken("4.6"),
                new RightParenthesisToken()
        );

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void tokenizeComplexOperationWithFloatingNumbers() {
        List<Token> expected = new ArrayList<>();
        expected.add(new LeftParenthesisToken());
        expected.add(new SquareRootFunction());
        expected.add(new LeftParenthesisToken());
        expected.add(new NumberToken("2.0"));
        expected.add(new PowerToken());
        expected.add(new NumberToken("2.1"));
        expected.add(new MinusToken());
        expected.add(new NumberToken("6.2"));
        expected.add(new PlusToken());
        expected.add(new NumberToken("2.3"));
        expected.add(new MultiplyToken());
        expected.add(new NumberToken("3.4"));
        expected.add(new LeftParenthesisToken());
        expected.add(new MinusToken());
        expected.add(new NumberToken("2.5"));
        expected.add(new LeftParenthesisToken());
        expected.add(new DivisionToken());
        expected.add(new NumberToken("2.55"));
        List<Token> actual = Tokenizer.tokenize("( sqrt ( 2.0 ^ 2.1 - 6.2 + 2.3 * 3.4 ) - 2.5 ) / 2.55");

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void tokenizerThrowsExceptionWhenParenthesisDoNotMatch1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Tokenizer.tokenize("( ( sqrt ( 2 ^ 4 ) )"),
                "Should have detected more ( parenthesis than ) ones "
        );
    }

    @Test
    void tokenizerThrowsExceptionWhenParenthesisDoNotMatch2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Tokenizer.tokenize("( sqrt ( 2 ^ 4 ) ) )"),
                "Should have detected more ) parenthesis than ( ones "
        );
    }
}
