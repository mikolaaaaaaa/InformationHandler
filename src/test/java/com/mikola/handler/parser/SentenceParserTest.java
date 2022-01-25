package com.mikola.handler.parser;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Composite;
import com.mikola.handler.entity.impl.Lexeme;
import com.mikola.handler.parser.impl.SentenceParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SentenceParserTest {
    private static final String SENTENCE = "Hello world.";
    private static final Composite SENTENCE_COMPOSITE =
            new Composite(List.of(
                    Lexeme.word("Hello"),
                    Lexeme.word("world.")
            ));

    @Test
    public void testParseShouldReturnComponentWhenTextIsCorrect() {
        SentenceParser sentenceParser = new SentenceParser(null);
        Composite expected = SENTENCE_COMPOSITE;
        Component actual = sentenceParser.parse(SENTENCE);
        Assertions.assertEquals(expected,actual);
    }
}
