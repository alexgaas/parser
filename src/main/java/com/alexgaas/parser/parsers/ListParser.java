package com.alexgaas.parser.parsers;

import com.alexgaas.parser.Parser;
import com.alexgaas.parser.ParserState;
import java.util.ArrayList;
import java.util.List;

public class ListParser<T> implements Parser<List<T>> {

    private final Parser<?> separator;
    private final Parser<T> valueParser;

    public ListParser(Parser<T> valueParser, Parser<?> separator) {
        this.valueParser = valueParser;
        this.separator = separator;
    }

    private static <T> Parser<T> parseStack(final Parser<T> parser) {
        return input -> {
            input.push();
            T result = parser.parse(input);
            if (result != null) input.pop();
            else input.popAndGetBackItsPosition();
            return result;
        };
    }

    @Override
    public List parse(ParserState state) {
        List<T> results = new ArrayList<>();
        do {
            T val = parseStack(valueParser).parse(state);
            if (val != null) {
                results.add(val);
            } else {
                break;
            }
        } while (parseStack(separator).parse(state) != null);
        return results;
    }
}
