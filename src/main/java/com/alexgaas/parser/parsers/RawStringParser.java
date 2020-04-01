package com.alexgaas.parser.parsers;

import com.alexgaas.parser.Parser;
import com.alexgaas.parser.ParserState;
import com.alexgaas.parser.util.AllowableCharacters;

public class RawStringParser implements Parser<String> {

    private final AllowableCharacters condition;

    public RawStringParser() {
        this(NO_WHITESPACE);
    }

    public RawStringParser(AllowableCharacters condition) {
        this.condition = condition;
    }

    private static final AllowableCharacters NO_WHITESPACE = new AllowableCharacters() {
        @Override
        public boolean isAllowed(char character) {
            return !Character.isWhitespace(character);
        }

        @Override
        public String getDescription() {
            return "NO_WHITESPACE";
        }
    };

    @Override
    public String parse(ParserState inputState) {
        StringBuilder sb = new StringBuilder();
        int curr = inputState.current();
        while (curr != -1 && condition.isAllowed((char) curr)) {
            sb.append((char) curr);
            curr = inputState.next();
        }
        return sb.length() > 0 ? sb.toString() : null;
    }
}
