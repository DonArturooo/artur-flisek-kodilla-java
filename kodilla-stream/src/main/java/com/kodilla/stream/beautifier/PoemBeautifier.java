package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String poem, PoemDecorator poemDecorator) {
        System.out.println("Beautify poem: " + poemDecorator.decorate(poem));
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
