package spring.commento.springbasic.chapter05.interpreter;

import java.util.Map;


public class InterpreterMain {
    public static void main(String[] args) {
       PostfixExpression expression=PostfixParser.parse("xyz+-");
       int result=expression.interpret(Map.of(
           'x', 1, 'y', 2, 'z', 3));
        System.out.println(result);
    }
}