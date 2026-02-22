# Basic calculator

This project uses the shunting yard algorithm to evaluate simple mathematical expressions.

## Available operations

- Plus (+)
- Minus (-)
- Division (/)
- Multiplication (*)
- Power (^)
- Square root function (sqrt())

## Available operand types

- Number (only normal notation)

Other types, such as boolean or numbers in scientific notation, could be added.

## Implementation overview

The program is made out of two main components: a tokenizer and a parser

### Tokenizer

Transforms an input string into a series of tokens. 

### Parser 

Evaluates a list of tokens and returns the expression's result.
The parser is made out of a number of states. Each state implements State interface and processes 
a type of token. The parser decides which state to use depending on the token type.

### Tokens

Token is an umbrella interface for all types of entities representing data in the expression.

Token is extended by Operand, Operation, Function, and Operators. These are specialised classes
for representing numbers, operations (operators + functions), functions (sqrt()), and operators (+, -, /, *, ^).

Token is implemented by CommaToken, LeftParenthesisToken, and RightParenthesisToken.

There are five token types present:
- OPERAND
- FUNCTION
- OPERATOR
- PARENTHESIS
- COMMA




