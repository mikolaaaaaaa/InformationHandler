package com.mikola.handler.parser;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Composite;
import com.mikola.handler.entity.impl.Lexeme;
import com.mikola.handler.parser.impl.ParagraphParser;
import com.mikola.handler.parser.impl.TextParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


public class TextParserTest {
    private static final String TEXT = "First paragraph.\nSecond paragraph!";
    private static final String FIRST_PARAGRAPH = "First paragraph.";
    private static final String SECOND_PARAGRAPH = "Second paragraph!";
    private static final Component FIRST_PARAGRAPH_COMPONENT =
            new Composite(List.of(
                    Lexeme.word("First"),
                    Lexeme.word("paragraph.")
            ));
    private static final Component SECOND_PARAGRAPH_COMPONENT =
            new Composite(List.of(
                    Lexeme.word("Second"),
                    Lexeme.word("paragraph!")
            ));


    @Test
    public void testParseShouldReturnComponentWhenTextIsValid() {
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        Mockito.when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(FIRST_PARAGRAPH_COMPONENT);
        Mockito.when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(SECOND_PARAGRAPH_COMPONENT);

        TextParser textParser = new TextParser(paragraphParser);
        Composite expected = new Composite();
        expected.add(FIRST_PARAGRAPH_COMPONENT);
        expected.add(SECOND_PARAGRAPH_COMPONENT);
        Component actual = textParser.parse(TEXT);
        Assertions.assertEquals(expected, actual);
    }
}
