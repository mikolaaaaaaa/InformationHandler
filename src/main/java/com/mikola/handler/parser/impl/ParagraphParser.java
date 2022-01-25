package com.mikola.handler.parser.impl;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Composite;
import com.mikola.handler.parser.AbstractParser;
import com.mikola.handler.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final String SENTENCE_PATTERN = "[A-Z][A-Za-z 0-9-(),\\[\\]*+/]+[.?!...]";

    public ParagraphParser(Parser succecor) {
        super(succecor);
    }

    @Override
    public Component parse(String text) {
        Composite composite = new Composite();
        Pattern pattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String part = matcher.group();
            Component sentence = getSuccessor().parse(part);
            composite.add(sentence);
        }
        return composite;
    }
}
