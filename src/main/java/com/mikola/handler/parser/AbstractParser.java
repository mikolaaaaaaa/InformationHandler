package com.mikola.handler.parser;

public abstract class AbstractParser implements Parser{

    private final Parser successor;

    public AbstractParser(Parser succecor) {
        this.successor = succecor;
    }

    public Parser getSuccessor() {
        return successor;
    }
}
