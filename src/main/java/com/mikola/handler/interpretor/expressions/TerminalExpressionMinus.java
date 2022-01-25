package com.mikola.handler.interpretor.expressions;

import com.mikola.handler.interpretor.AbstractMathExpression;
import com.mikola.handler.interpretor.Context;

public class TerminalExpressionMinus extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() - context.popValue());
    }
}
