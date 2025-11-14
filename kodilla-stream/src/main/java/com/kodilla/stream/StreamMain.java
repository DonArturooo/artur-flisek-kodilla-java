package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain  {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        SaySomething saySomething = new SaySomething();
        saySomething.say();

        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        Executor codeToExecute = () ->  System.out.println("This is an example text.");
        processor.execute(codeToExecute);

        processor.execute(() -> System.out.println("This is an example text."));


        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("tekst z małych", (poem -> poem.toUpperCase()));
        poemBeautifier.beautify(" taki tam sobie tekst", (poem -> "ABC" + poem + "ABC"));
        poemBeautifier.beautify("Poem Beautifier", (poem -> {
            char[] chars = poem.toCharArray();
            StringBuilder result = new StringBuilder();

            for ( int i = 0; i < chars.length; i++ ) {
                if(i % 2 == 0) {
                    result.append(Character.toUpperCase(chars[i]));
                } else{
                    result.append(chars[i]);
                }
            }

            return result.toString();
        }));
        poemBeautifier.beautify("ala ma kota, a kto ma ale", StreamMain::toCamelCase);
    }

    public static String toCamelCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String[] words = text.toLowerCase().trim().split("[^a-zA-Z0-9]+");

        if (words.length == 1) {
            return words[0];
        }

        StringBuilder sb = new StringBuilder(words[0]); // pierwsze słowo: mała litera

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > 0) {
                sb.append(Character.toUpperCase(words[i].charAt(0)))
                  .append(words[i].substring(1));
            }
        }

        return sb.toString();
    }

}
