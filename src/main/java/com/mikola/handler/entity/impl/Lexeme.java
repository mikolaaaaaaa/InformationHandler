package com.mikola.handler.entity.impl;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.LexemeType;

public class Lexeme implements Component {
    private final String value;
    private final LexemeType lexemeType;

    public Lexeme(String value, LexemeType lexemeType) {
        this.value = value;
        this.lexemeType = lexemeType;
    }

    public static Lexeme word(String value) {
        return new Lexeme(value,LexemeType.WORD);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value,LexemeType.EXPRESSION);
    }

    public String getValue() {
        return value;
    }

    public LexemeType getLexemeType() {
        return lexemeType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Lexeme lexeme = (Lexeme) object;

        if (value != null ? !value.equals(lexeme.value) : lexeme.value != null) return false;
        return lexemeType == lexeme.lexemeType;

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (lexemeType != null ? lexemeType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lexeme{")
                .append("value='").append(value).append('\'')
                .append(", lexemeType=").append(lexemeType)
                .append('}');
        return stringBuilder.toString();
    }
}
