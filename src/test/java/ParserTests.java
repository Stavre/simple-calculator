import org.junit.jupiter.api.Test;
import parser.Parser;
import tokens.Token;
import tokens.Tokenizer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTests {

    Parser parser = new Parser();

    @Test
    void test1() {
        List<Token> tokens = Tokenizer.tokenize("1 - 0.2");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("0.8"), res);
    }

    @Test
    void test2() {
        List<Token> tokens = Tokenizer.tokenize("1 - 1");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("0"), res);
    }

    @Test
    void test3() {
        List<Token> tokens = Tokenizer.tokenize("2 - 1");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("1"), res);
    }

    @Test
    void test4() {
        List<Token> tokens = Tokenizer.tokenize("1 - 2");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("-1"), res);
    }

    @Test
    void test5() {
//        List<Token> tokens = Tokenizer.tokenize("1 - 0.2 + 2 / 2 + 3 * 3");
        List<Token> tokens = Tokenizer.tokenize("2 / 2");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("1"), res);
    }

    @Test
    void test6() {
//        List<Token> tokens = Tokenizer.tokenize("1 - 0.2 + 2 / 2 + 3 * 3");
        List<Token> tokens = Tokenizer.tokenize("0.8 + 2 / 2");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("1.8"), res);
    }

    @Test
    void test7() {
        List<Token> tokens = Tokenizer.tokenize("-1 - 0.2 + 2 / 2 + 3 * 3");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("8.8"), res);
    }

    @Test
    void test8() {
        List<Token> tokens = Tokenizer.tokenize("1 - 0.2 + 2 / 2 * 3 - 3");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("0.8"), res);
    }

    @Test
    void test9() {
        List<Token> tokens = Tokenizer.tokenize("1 - ( 0.2 + 2 ) / 2 * ( 3 - 3 )");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("1.0"), res);
    }

    @Test
    void test10() {
        List<Token> tokens = Tokenizer.tokenize("( 2 - 1 - 1 )");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("0"), res);
    }

    @Test
    void test11() {
        List<Token> tokens = Tokenizer.tokenize("( 2 * ( 3 / 4 ) )");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("1.50"), res);
    }

    @Test
    void test12() {
        List<Token> tokens = Tokenizer.tokenize("( 2 ^ 2 )");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("4"), res);
    }

    @Test
    void test13() {
        List<Token> tokens = Tokenizer.tokenize("( sqrt ( 2 ^ 2 ) )");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("2"), res);
    }


    @Test
    void test14() {
        List<Token> tokens = Tokenizer.tokenize("( sqrt ( 2 ^ 4 ) )");
        BigDecimal res = parser.evaluate(tokens);
        assertEquals(new BigDecimal("4"), res);
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
