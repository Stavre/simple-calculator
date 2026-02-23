# Basic calculator

This project uses the shunting yard algorithm to evaluate simple mathematical expressions.

## Project

### How to build
Run:
```shell
./gradlew shadowJar
```

Then run the jar from /build/libs:
```shell
java -jar .\Calculator-1.0-SNAPSHOT-all.jar "3 + 4"
```

### Available operations
- Plus (+)
- Minus (-)
- Division (/)
- Multiplication (*)
- Power (^)
- Square root function (sqrt())

### Available operand types

- Number (only normal notation)

Other types, such as boolean or numbers in scientific notation, could be added.

### Implementation overview

The program is made out of two main components: a tokenizer and a com.stavre.calculator.parser

#### Tokenizer

Transforms an input string into a series of com.stavre.calculator.tokens. 

#### Parser 

Evaluates a list of com.stavre.calculator.tokens and returns the expression's result.
The com.stavre.calculator.parser is made out of a number of states. Each state implements State interface and processes 
a type of token. The com.stavre.calculator.parser decides which state to use depending on the token type.

#### Tokens

Token is an umbrella interface for all types of entities representing data in the expression.

Token is extended by Operand, Operation, Function, and Operators. These are specialized classes
for representing numbers, operations (operators + functions), functions (sqrt()), and operators (+, -, /, *, ^).

Token is implemented by CommaToken, LeftParenthesisToken, and RightParenthesisToken.

There are five token types present:
- OPERAND
- FUNCTION
- OPERATOR
- PARENTHESIS
- COMMA

## Quality checks

### Checkstyle
Checkstyle rule set used is taken from [Google](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml).
The following tweaks were made:
- default severity is error
- indentation level is 4 whitespaces, not 2
- disabled mandatory javadocs
- increased max line length from 100 characters to 120
- CustomImportOrder.sortImportsInGroupAlphabetically set to false

### PMD
Rules used:
- category/java/errorprone.xml
- category/java/bestpractices.xml




