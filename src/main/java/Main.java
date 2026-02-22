import java.math.BigDecimal;
import java.util.List;
import parser.Parser;
import tokens.Token;
import tokens.Tokenizer;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        List<Token> tokens = Tokenizer.tokenize("1 - 0.2 + 2 / 2 + 3 * 3");
        BigDecimal res = parser.evaluate(tokens);
    }
}