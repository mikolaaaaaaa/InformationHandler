package com.mikola.handler.logic;

import com.mikola.handler.entity.impl.Composite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TextLogicTest {
    private static final TextLogic textLogic = new TextLogic();

    @Test
    public void testSortParagraphBySentenceAmountShouldReturnSortedComposite() {
        Composite unsortedTextComposite = LogicTestDataGenerator.createUnsortedTextCompositeForSortParagraph();
        Composite expected = LogicTestDataGenerator.createSortedTextCompositeForSortParagraph();
        Composite actual = textLogic.sortParagraphBySentenceAmount(unsortedTextComposite);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSortWordsByLengthShouldReturnSortedComposite() {
        Composite unsortedTextComposite = LogicTestDataGenerator.createUnsortedTextCompositeForSortWords();
        Composite expected = LogicTestDataGenerator.createSortedTextCompositeForSortWords();
        Composite actual = textLogic.sortWordsByLength(unsortedTextComposite);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRestoreShouldReturnStringFromComposite() {
        Composite textComposite = LogicTestDataGenerator.createUnsortedTextCompositeForSortWords();
        String expected = LogicTestDataGenerator.getStringForTestRestore();
        String actual = textLogic.restore(textComposite);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateExpressionShouldReturnCompositeWithCalculatedExpression() {
        Composite compositeWithExpression = LogicTestDataGenerator.createCompositeWithExpression();
        Composite expected = LogicTestDataGenerator.createCompositeWithCalculatedExpression();
        Map<String,Double> parameters = new HashMap<>();
        parameters.put("x", 6.0);
        Composite actual = (Composite) textLogic.calculateExpression(compositeWithExpression, parameters);
        Assertions.assertEquals(expected, actual);
    }
}
