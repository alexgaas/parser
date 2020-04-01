package com.alexgaas.parser;

public interface ParserState {
    // get current character in string
    int current();
    // get next character in string
    int next();

    // get position of current character
    int getPosition();

    // push character to stack
    void push();
    // pop character from stack
    void pop();

    void popAndGetBackItsPosition();
}
