package com.mikola.handler.builder;

import com.mikola.handler.parser.impl.ParagraphParser;
import com.mikola.handler.parser.Parser;
import com.mikola.handler.parser.impl.SentenceParser;
import com.mikola.handler.parser.impl.TextParser;

public class ChainBuilder {
    public Parser build() {
        return new TextParser(new ParagraphParser(new SentenceParser(null)));
    }
}
