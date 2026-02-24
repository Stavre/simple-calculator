package com.stavre.calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.stavre.calculator.tokens.LeftParenthesisToken;
import com.stavre.calculator.tokens.RightParenthesisToken;
import com.stavre.calculator.tokens.operands.NumberToken;
import com.stavre.calculator.tokens.operations.functions.SquareRootFunction;
import com.stavre.calculator.tokens.operations.operators.MinusToken;
import com.stavre.calculator.tokens.operations.operators.PlusToken;
import com.stavre.calculator.tokens.operations.operators.MultiplyToken;
import com.stavre.calculator.tokens.operations.operators.DivisionToken;
import com.stavre.calculator.tokens.operations.operators.PowerToken;
import org.junit.jupiter.api.Test;
import com.stavre.calculator.tokens.Token;

class ParserTest {

    Parser parser = new Parser();

    @Test
    void evaluateSimplePlusOperation() {
        List<Token> tokens = List.of(
                new NumberToken("2"),
                new PlusToken(),
                new NumberToken("4")
        );
        BigDecimal expected = new BigDecimal(6);
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void evaluateSimpleMinusOperation() {
        List<Token> tokens = List.of(
                new NumberToken("2"),
                new MinusToken(),
                new NumberToken("4")
        );

        BigDecimal expected = new BigDecimal(-2);
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void evaluateSimpleMultiplicationOperation() {
        List<Token> tokens = List.of(
                new NumberToken("2"),
                new MultiplyToken(),
                new NumberToken("4")
        );

        BigDecimal expected = new BigDecimal(8);
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void evaluateSimpleDivisionOperation() {
        List<Token> tokens = List.of(
                new NumberToken("4"),
                new DivisionToken(),
                new NumberToken("2")
        );

        BigDecimal expected = new BigDecimal(2);
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void evaluateSimpleDivisionOperationWithFloatingPointResult() {
        List<Token> tokens = List.of(
                new NumberToken("1"),
                new DivisionToken(),
                new NumberToken("2")
        );

        BigDecimal expected = new BigDecimal("0.5");
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }
    //    TODO: Fix bug and then uncomment test
    //    @Test
    //    public void evaluateSimpleDivisionOperationWithNonTerminatingDecimalExpansionResult() {
    //        List<Token> tokens = List.of(
    //                new NumberToken("1"),
    //                new DivisionToken(),
    //                new NumberToken("3")
    //        );
    //        BigDecimal expected = new BigDecimal("0.333333");
    //        BigDecimal actual = parser.evaluate(tokens);
    //        assertThat(actual).isEqualTo(expected);
    //    }

    @Test
    void evaluateSimplePowerOperation() {
        List<Token> tokens = List.of(
                new NumberToken("2"),
                new PowerToken(),
                new NumberToken("4")
        );

        BigDecimal expected = new BigDecimal(16);
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void evaluateSimpleSquareRootOperation() {
        List<Token> tokens = List.of(
                new SquareRootFunction(),
                new LeftParenthesisToken(),
                new NumberToken("4"),
                new RightParenthesisToken()
        );

        BigDecimal expected = new BigDecimal(2);
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void evaluateComplexOperation() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new LeftParenthesisToken());
        tokens.add(new SquareRootFunction());
        tokens.add(new LeftParenthesisToken());
        tokens.add(new NumberToken("2"));
        tokens.add(new PowerToken());
        tokens.add(new NumberToken("2"));
        tokens.add(new MinusToken());
        tokens.add(new NumberToken("6"));
        tokens.add(new PlusToken());
        tokens.add(new NumberToken("2"));
        tokens.add(new MultiplyToken());
        tokens.add(new NumberToken("3"));
        tokens.add(new RightParenthesisToken());
        tokens.add(new MinusToken());
        tokens.add(new NumberToken("2"));
        tokens.add(new RightParenthesisToken());
        tokens.add(new DivisionToken());
        tokens.add(new NumberToken("2"));

        BigDecimal expected = new BigDecimal("0");
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void evaluateSimplePlusOperationWithFloatingNumbers() {
        List<Token> tokens = List.of(
                new NumberToken("2.0"),
                new PlusToken(),
                new NumberToken("4.34")
        );

        BigDecimal expected = new BigDecimal("6.34");
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void evaluateSimpleMinusOperationWithFloatingNumbers() {
        List<Token> tokens = List.of(
                new NumberToken("2.002"),
                new MinusToken(),
                new NumberToken("4.9")
        );

        BigDecimal expected = new BigDecimal("-2.898");
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void evaluateSimpleMultiplicationOperationWithFloatingNumbers() {
        List<Token> tokens = List.of(
                new NumberToken("2.9008"),
                new MultiplyToken(),
                new NumberToken("4.6")
        );

        BigDecimal expected = new BigDecimal("13.34368");
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }

    //    TODO: Fix bug and then uncomment test
    //    @Test
    //    public void evaluateSimpleDivisionOperationWithFloatingNumbers() {
    //        List<Token> tokens = List.of(
    //                new NumberToken("2.5058"),
    //                new DivisionToken(),
    //                new NumberToken("4.862")
    //        );
    //        BigDecimal expected = new BigDecimal("0.5153846153846154");
    //        BigDecimal actual = parser.evaluate(tokens);
    //        assertThat(actual).isEqualTo(expected);
    //    }
    //    TODO: Fix bug and then uncomment test
    //    @Test
    //    public void evaluateSimplePowerOperationWithFloatingNumbers() {
    //        List<Token> tokens = List.of(
    //                new NumberToken("2.9"),
    //                new PowerToken(),
    //                new NumberToken("4.6")
    //        );
    //        BigDecimal expected = new BigDecimal("133.97716703424636304");
    //        BigDecimal actual = parser.evaluate(tokens);
    //        assertThat(actual).isEqualTo(expected);
    //    }

    @Test
    void evaluateSimpleSquareRootOperationWithFloatingNumbers() {
        List<Token> tokens = List.of(
                new SquareRootFunction(),
                new LeftParenthesisToken(),
                new NumberToken("4.6"),
                new RightParenthesisToken()
        );

        BigDecimal expected = new BigDecimal("2.145");
        BigDecimal actual = parser.evaluate(tokens);

        assertThat(actual).isEqualTo(expected);
    }
}
