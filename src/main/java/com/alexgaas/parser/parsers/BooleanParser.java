package com.alexgaas.parser.parsers;

import com.alexgaas.parser.Parser;
import com.alexgaas.parser.ParserState;

public class BooleanParser implements Parser<Boolean> {
    @Override
    public Boolean parse(ParserState state) {
        String value = new RawStringParser().parse(state);
        return value.equalsIgnoreCase("true") ||
                value.equalsIgnoreCase("1");
    }
}
