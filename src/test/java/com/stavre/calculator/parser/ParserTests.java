package com.stavre.calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.stavre.calculator.tokens.Token;
import com.stavre.calculator.tokens.Tokenizer;

class ParserTests {

    Parser parser = new Parser();

    @Test
    void test1() {
        List<Token> tokens = Tokenizer.tokenize("1 - 0.2");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("0.8")).isEqualTo(res);
    }

    @Test
    void test2() {
        List<Token> tokens = Tokenizer.tokenize("1 - 1");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("0")).isEqualTo(res);
    }

    @Test
    void test3() {
        List<Token> tokens = Tokenizer.tokenize("2 - 1");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("1")).isEqualTo(res);
    }

    @Test
    void test4() {
        List<Token> tokens = Tokenizer.tokenize("1 - 2");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("-1")).isEqualTo(res);
    }

    @Test
    void test5() {
        List<Token> tokens = Tokenizer.tokenize("2 / 2");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("1")).isEqualTo(res);
    }

    @Test
    void test6() {
        List<Token> tokens = Tokenizer.tokenize("0.8 + 2 / 2");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("1.8")).isEqualTo(res);
    }

    @Test
    void test7() {
        List<Token> tokens = Tokenizer.tokenize("-1 - 0.2 + 2 / 2 + 3 * 3");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("8.8")).isEqualTo(res);
    }

    @Test
    void test8() {
        List<Token> tokens = Tokenizer.tokenize("1 - 0.2 + 2 / 2 * 3 - 3");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("0.8")).isEqualTo(res);
    }

    @Test
    void test9() {
        List<Token> tokens = Tokenizer.tokenize("1 - ( 0.2 + 2 ) / 2 * ( 3 - 3 )");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("1.0")).isEqualTo(res);
    }

    @Test
    void test10() {
        List<Token> tokens = Tokenizer.tokenize("( 2 - 1 - 1 )");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("0")).isEqualTo(res);
    }

    @Test
    void test11() {
        List<Token> tokens = Tokenizer.tokenize("( 2 * ( 3 / 4 ) )");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("1.50")).isEqualTo(res);
    }

    @Test
    void test12() {
        List<Token> tokens = Tokenizer.tokenize("( 2 ^ 2 )");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("4")).isEqualTo(res);
    }

    @Test
    void test13() {
        List<Token> tokens = Tokenizer.tokenize("( sqrt ( 2 ^ 2 ) )");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("2")).isEqualTo(res);
    }

    @Test
    void test14() {
        List<Token> tokens = Tokenizer.tokenize("( sqrt ( 2 ^ 4 ) )");
        BigDecimal res = parser.evaluate(tokens);
        assertThat(new BigDecimal("4")).isEqualTo(res);
    }

    @Test
    void test15() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Tokenizer.tokenize("( ( sqrt ( 2 ^ 4 ) )"),
                "Should have detected more ( parenthesis than ) ones "
        );
    }

    @Test
    void test16() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Tokenizer.tokenize("( sqrt ( 2 ^ 4 ) ) )"),
                "Should have detected more ) parenthesis than ( ones "
        );
    }
}
