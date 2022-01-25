package com.mikola.handler.interpretor;

import java.util.ArrayDeque;

public class Context {
    private final ArrayDeque<Double> contextValues = new ArrayDeque<>();

    public Double popValue() {
        return contextValues.pop();
    }

    public void pushValue(double value) {
        this.contextValues.push(value);
    }
}
