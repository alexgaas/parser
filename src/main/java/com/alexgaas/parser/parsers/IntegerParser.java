package com.alexgaas.parser.parsers;

import com.alexgaas.parser.Parser;
import com.alexgaas.parser.ParserState;
import com.alexgaas.parser.util.AllowableCharacters;

public class IntegerParser implements Parser<Integer> {
    private static final Parser<String> RAW_INT_PARSER = new RawStringParser(new AllowableCharacters() {
        @Override
        public boolean isAllowed(char character) {
            return Character.isDigit(character) || character == '-';
        }

        @Override
        public String getDescription() {
            return "Character.isDigit";
        }
    });

    @Override
    public Integer parse(ParserState inputState) {
        String str = RAW_INT_PARSER.parse(inputState);
        return str != null ? Integer.valueOf(str) : null;
    }
}
