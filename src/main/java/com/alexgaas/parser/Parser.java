package com.alexgaas.parser;

public interface Parser<T> {
    T parse(ParserState state);
}
