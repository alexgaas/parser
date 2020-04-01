package com.alexgaas.parser.unit;

import com.alexgaas.parser.Parser;
import com.alexgaas.parser.ParserState;
import com.alexgaas.parser.ParserStringState;
import com.alexgaas.parser.parsers.IntegerParser;
import org.junit.jupiter.api.Test;

class IntegerParserTest {
    @Test
    void testIntegerParser() {
        Parser<Integer> intParser = new IntegerParser();

        // initial test
        ParserState state = new ParserStringState("1");
        Integer result1 = intParser.parse(state);
        assert(result1 == 1);

        // negative test
        state = new ParserStringState("-1");
        Integer result2 = intParser.parse(state);
        assert(result2 == -1);

        String max = Integer.toString(Integer.MAX_VALUE);
        state = new ParserStringState(max);
        Integer result3 = intParser.parse(state);
        assert(result3 == Integer.MAX_VALUE);

        // incorrect value test
        state = new ParserStringState("incorrect_value");
        Integer result4 = intParser.parse(state);
        assert(result4 == null);
    }
}
