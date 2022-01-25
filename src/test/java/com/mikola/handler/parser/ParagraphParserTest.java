package com.mikola.handler.parser;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Composite;
import com.mikola.handler.entity.impl.Lexeme;
import com.mikola.handler.parser.impl.ParagraphParser;
import com.mikola.handler.parser.impl.SentenceParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ParagraphParserTest {
    private static final String PARAGRAPH = "First sentence. Second sentence?";
    private static final String FIRST_SENTENCE = "First sentence.";
    private static final String SECOND_SENTENCE = "Second sentence?";
    private static final List<Component> FIRST_SENTENCE_WORDS = List.of(
            Lexeme.word("First"),
            Lexeme.word("sentence.")
    );
    private static final List<Component> SECOND_SENTENCE_WORDS = List.of(
            Lexeme.word("Second"),
            Lexeme.word("sentence?")
    );


    @Test
    public void textParseShouldReturnComponentWhenTextIsValid() {
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        Component firstSentenceComponent = new Composite(FIRST_SENTENCE_WORDS);
        Component secondSentenceComponent = new Composite(SECOND_SENTENCE_WORDS);
        Mockito.when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(firstSentenceComponent);
        Mockito.when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(secondSentenceComponent);

        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        Composite expected = new Composite();
        expected.add(firstSentenceComponent);
        expected.add(secondSentenceComponent);
        Component actual = paragraphParser.parse(PARAGRAPH);
        Assertions.assertEquals(expected,actual);


    }
}
