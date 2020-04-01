package com.alexgaas.parser.parsers;

import com.alexgaas.parser.Parser;
import com.alexgaas.parser.ParserState;
import com.alexgaas.parser.enums.ParserResult;

public final class StringParser implements Parser<ParserResult> {

    private final String input;

    public StringParser(String input){
        this.input = input;
    }

    @Override
    public ParserResult parse(ParserState state) {
        StringBuilder sb = new StringBuilder();
        int curr = state.current();
        while (curr != -1 && sb.length() < input.length()) {
            sb.append((char) curr);
            curr = state.next();
        }

        if (sb.toString().equals(input)) return ParserResult.CORRECT;
        else return ParserResult.INCORRECT;
    }
}
