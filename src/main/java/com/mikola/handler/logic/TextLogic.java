package com.mikola.handler.logic;

import com.mikola.handler.comparator.SentenceAmountComparator;
import com.mikola.handler.comparator.WordLengthComparator;
import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Composite;
import com.mikola.handler.entity.impl.Lexeme;
import com.mikola.handler.entity.LexemeType;
import com.mikola.handler.interpretor.ExpressionCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TextLogic {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SPACE = " ";

    public String restore(Component textComponent) {
        StringBuilder text = new StringBuilder();
        if (textComponent.getClass() == Composite.class) {
            Composite textComposite = (Composite) textComponent;
            List<Component> parts = textComposite.getChildren();
            for (Component part : parts) {
                text.append(restore(part));
            }
        }
        if (textComponent.getClass() == Lexeme.class) {
            Lexeme lexeme = (Lexeme) textComponent;
            text.append(lexeme.getValue()).append(SPACE);
        }
        return text.toString();
    }

    public Component calculateExpression(Component component, Map<String, Double> parameters) {
        Component newTextComponent = new Composite();
        if (component.getClass() == Composite.class) {
            Composite composite = (Composite) component;
            List<Component> parts = composite.getChildren();
            for (Component part : parts) {
                ((Composite)newTextComponent).add(calculateExpression(part,parameters));
            }
        }
        if (component.getClass() == Lexeme.class) {
            Lexeme lexeme = (Lexeme) component;
            if (lexeme.getLexemeType() == LexemeType.EXPRESSION) {
                ExpressionCalculator calculator = new ExpressionCalculator(
                        lexeme.getValue(),
                        parameters
                );
                Double expressionResult = (Double) calculator.calculate();
                LOGGER.debug(
                        "Calculation result of expression {} is {}",
                        lexeme.getValue(),
                        expressionResult
                );
                newTextComponent = Lexeme.word(expressionResult.toString());
            }
            else {
                newTextComponent = component;
            }
        }
        return newTextComponent;
    }

    public Composite sortParagraphBySentenceAmount(Composite textComposite) {
        List<Component> paragraphs = new ArrayList<>(textComposite.getChildren());
        SentenceAmountComparator comparator = new SentenceAmountComparator();
        paragraphs.sort(comparator);
        Composite sortedTextComposite = new Composite(paragraphs);
        return sortedTextComposite;
    }

    public Composite sortWordsByLength(Composite textComposite) {
        List<Component> paragraphs = textComposite.getChildren();
        Composite newText = new Composite();
        for(Component paragraph : paragraphs) {
            Composite paragraphComposite = (Composite) paragraph;
            List<Component> sentences = paragraphComposite.getChildren();
            List<Component> newSentences = new ArrayList<>();
            for(Component sentence : sentences) {
                Composite sentenceComposite = (Composite) sentence;
                List<Component> words = new ArrayList<>(sentenceComposite.getChildren());
                WordLengthComparator comparator = new WordLengthComparator();
                words.sort(comparator);
                Composite sortedSentenceComposite = new Composite(words);
                newSentences.add(sortedSentenceComposite);
            }
            Composite newParagraph = new Composite(newSentences);
            newText.add(newParagraph);
        }
        return newText;
    }
}
