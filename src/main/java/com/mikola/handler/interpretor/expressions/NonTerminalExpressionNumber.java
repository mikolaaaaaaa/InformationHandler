package com.mikola.handler.interpretor.expressions;

import com.mikola.handler.interpretor.AbstractMathExpression;
import com.mikola.handler.interpretor.Context;

public class NonTerminalExpressionNumber extends AbstractMathExpression {
    private final double number;

    public NonTerminalExpressionNumber(double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        NonTerminalExpressionNumber that = (NonTerminalExpressionNumber) object;

        return Double.compare(that.number, number) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(number);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NonterminalExpressionNumber{")
                .append("number=").append(number)
                .append('}');
        return stringBuilder.toString();
    }
}
