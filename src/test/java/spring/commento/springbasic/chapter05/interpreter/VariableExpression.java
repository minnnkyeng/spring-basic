package spring.commento.springbasic.chapter05.interpreter;

import java.util.Map;

public class VariableExpression implements PostfixExpression{
    
    private final Character variable;

    public VariableExpression(Character variable) {
        this.variable = variable;
    }

    @Override
    public int interpret(Map<Character, Integer> context) {
        return context.get(variable);
    }
}