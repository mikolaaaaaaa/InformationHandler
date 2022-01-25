package com.mikola.handler.comparator;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Lexeme;

import java.util.Comparator;

public class WordLengthComparator implements Comparator<Component> {

    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        Lexeme firstLexeme = (Lexeme) firstComponent;
        Lexeme secondLexeme = (Lexeme) secondComponent;
        return Integer.compare(
                firstLexeme.getValue().length(),
                secondLexeme.getValue().length()
        );
    }
}
