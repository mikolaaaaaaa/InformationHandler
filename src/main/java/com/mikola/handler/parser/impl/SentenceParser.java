package com.mikola.handler.parser.impl;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Composite;
import com.mikola.handler.entity.impl.Lexeme;
import com.mikola.handler.parser.AbstractParser;
import com.mikola.handler.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    private static final String LEXEME_PATTERN = "(\\[[0-9 a-z*/+-]+\\])|(\\(?[A-Za-z\\-]+[,.!?...)]*)";
    private static final String EXPRESSION_PATTERN = "\\[[0-9 a-z*/+-]+\\]";

    public SentenceParser(Parser succecor) {
        super(succecor);
    }

    @Override
    public Component parse(String text) {
        Composite composite = new Composite();
        Pattern pattern = Pattern.compile(LEXEME_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String part = matcher.group();
            Lexeme lexeme = part.matches(EXPRESSION_PATTERN) ?
                    Lexeme.expression(part) : Lexeme.word(part);
            composite.add(lexeme);
        }
        return composite;
    }
}
