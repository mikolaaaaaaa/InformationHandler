package com.mikola.handler.logic;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Composite;
import com.mikola.handler.entity.impl.Lexeme;

import java.util.List;

public class LogicTestDataGenerator {
    private static final List<Component> lexemes = List.of(
            Lexeme.word("Hello"),
            Lexeme.word("hi"),
            Lexeme.word("goodbye")
    );

    private static final String TEXT = "Hello hi goodbye ";


    public static Composite createUnsortedTextCompositeForSortParagraph() {
        Component sentence = new Composite(lexemes);
        Composite firstParagraph = new Composite();
        Composite secondParagraph = new Composite();
        firstParagraph.add(sentence);
        firstParagraph.add(sentence);
        secondParagraph.add(sentence);
        Composite text = new Composite();
        text.add(firstParagraph);
        text.add(secondParagraph);
        return text;
    }

    public static Composite createSortedTextCompositeForSortParagraph() {
        Component sentence = new Composite(lexemes);
        Composite firstParagraph = new Composite();
        Composite secondParagraph = new Composite();
        firstParagraph.add(sentence);
        secondParagraph.add(sentence);
        secondParagraph.add(sentence);
        Composite text = new Composite();
        text.add(firstParagraph);
        text.add(secondParagraph);
        return text;
    }

    public static Composite createUnsortedTextCompositeForSortWords() {
        Component sentence = new Composite(lexemes);
        Composite paragraph = new Composite();
        paragraph.add(sentence);
        Composite text = new Composite();
        text.add(paragraph);
        return text;
    }

    public static Composite createSortedTextCompositeForSortWords() {
        List<Component> sortedLexemes = List.of(
                Lexeme.word("hi"),
                Lexeme.word("Hello"),
                Lexeme.word("goodbye")
        );
        Component sentence = new Composite(sortedLexemes);
        Composite paragraph = new Composite();
        paragraph.add(sentence);
        Composite text = new Composite();
        text.add(paragraph);
        return text;
    }

    public static String getStringForTestRestore() {
        return TEXT;
    }

    public static Composite createCompositeWithExpression() {
        List<Component> lexemes = List.of(
                Lexeme.expression("[3 1 2 5 x - * / +]")
        );
        Composite text = new Composite();
        Composite paragraph = new Composite();
        Composite sentence = new Composite(lexemes);
        paragraph.add(sentence);
        text.add(paragraph);
        return text;
    }

    public static Composite createCompositeWithCalculatedExpression() {
        List<Component> lexemes = List.of(
                Lexeme.word("5.0")
        );
        Composite text = new Composite();
        Composite paragraph = new Composite();
        Composite sentence = new Composite(lexemes);
        paragraph.add(sentence);
        text.add(paragraph);
        return text;
    }

}
