package com.alexgaas.parser.unit;

import com.alexgaas.parser.ParserState;
import com.alexgaas.parser.ParserStringState;
import com.alexgaas.parser.enums.ParserResult;
import com.alexgaas.parser.parsers.StringParser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StringParserTest {
    @Test
    void validateStringParser() {
        StringParser parser = new StringParser("test");

        ParserState state1 = new ParserStringState("abc");
        assertEquals(parser.parse(state1), ParserResult.INCORRECT);

        ParserState state2 = new ParserStringState("test");
        assertEquals(parser.parse(state2), ParserResult.CORRECT);
    }
}
