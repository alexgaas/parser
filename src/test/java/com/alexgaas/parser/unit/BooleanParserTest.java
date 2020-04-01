package com.alexgaas.parser.unit;

import com.alexgaas.parser.Parser;
import com.alexgaas.parser.ParserState;
import com.alexgaas.parser.ParserStringState;
import com.alexgaas.parser.parsers.BooleanParser;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BooleanParserTest {
    @Test
    void validateBooleanParser() {
        Parser<Boolean> parser = new BooleanParser();

        // Check on true
        ParserState state1 = new ParserStringState("1");
        ParserState state_true = new ParserStringState("true");

        Boolean result1 = parser.parse(state1);
        assertTrue(result1);

        Boolean result2 = parser.parse(state_true);
        assertTrue(result2);

        // Check any other value
        ParserState state_false = new ParserStringState("test");

        Boolean result3 = parser.parse(state_false);
        assertFalse(result3);
    }
}
