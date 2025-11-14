package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String poem, PoemDecorator poemDecorator) {
        System.out.println("Beautify poem: " + poemDecorator.decorate(poem));
    }
}
