package com.mikola.handler.interpretor;

import com.mikola.handler.exception.InformationHandlingException;
import com.mikola.handler.interpretor.expressions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpressionCalculator {
    private final List<AbstractMathExpression> listExpression;
    private static final String EXPRESSION_DELIMITER = "\\p{Blank}+";
    private static final String BRACKETS_TEMPLATE = "[\\[\\]]";
    private static final String EMPTY_STRING = "";

    public ExpressionCalculator(String expression, Map<String,Double> parameters) {
        listExpression = new ArrayList<>();
        parse(expression,parameters);
    }

    public void parse(String expression,Map<String,Double> parameters) {
        expression = removeBrackets(expression);
        for (String lexeme : expression.split(EXPRESSION_DELIMITER)) {
            if (!lexeme.isEmpty()) {
                char temp = lexeme.charAt(0);
                switch (temp) {
                    case '+' -> {
                        listExpression.add(new TerminalExpressionPlus());
                    }
                    case '-' -> {
                        listExpression.add(new TerminalExpressionMinus());
                    }
                    case '*' -> {
                        listExpression.add(new TerminalExpressionMultiply());
                    }
                    case '/' -> {
                        listExpression.add(new TerminalExpressionDivide());
                    }
                    default -> {
                        Scanner scanner = new Scanner(lexeme);
                        if (scanner.hasNextDouble()) {
                                double number = scanner.nextDouble();
                                listExpression.add(new NonTerminalExpressionNumber(number));
                        }
                        else {
                            String key = scanner.next();
                            if (parameters.containsKey(key)) {
                                double number = parameters.get(key);
                                listExpression.add(new NonTerminalExpressionNumber(number));
                            }
                        }
                    }
                }
            }
        }
    }

    public String removeBrackets(String expression) {
        return expression.replaceAll(BRACKETS_TEMPLATE,EMPTY_STRING);
    }

    public Number calculate() {
        Context context = new Context();
        for(AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

}
