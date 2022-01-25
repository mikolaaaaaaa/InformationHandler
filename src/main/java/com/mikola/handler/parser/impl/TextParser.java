package com.mikola.handler.parser.impl;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Composite;
import com.mikola.handler.parser.AbstractParser;

import java.util.List;

public class TextParser extends AbstractParser {

    private final String PARAGRAPH_DELIMITER = "\n";

    public TextParser(AbstractParser succecor) {
        super(succecor);
    }

    @Override
    public Component parse(String text) {
        List<String> parts = List.of(text.split(PARAGRAPH_DELIMITER));
        Composite composite = new Composite();
        for(String part : parts) {
            Component paragraph = getSuccessor().parse(part);
            composite.add(paragraph);
        }
        return composite;
    }
}
