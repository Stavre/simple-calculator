# Basic calculator

This project uses the shunting yard algorithm to evaluate simple mathematical expressions.

## Project

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

The program is made out of two main components: a tokenizer and a parser

#### Tokenizer

Transforms an input string into a series of tokens. 

#### Parser 

Evaluates a list of tokens and returns the expression's result.
The parser is made out of a number of states. Each state implements State interface and processes 
a type of token. The parser decides which state to use depending on the token type.

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

### PMD
Rules used:
- category/java/errorprone.xml
- category/java/bestpractices.xml




