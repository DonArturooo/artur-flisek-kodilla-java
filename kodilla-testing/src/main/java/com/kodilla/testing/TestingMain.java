package com.kodilla.testing;

import java.util.ArrayList;

public class TestingMain  {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        ArrayList<Character> vowels = findVowels("Adam");

        vowels.forEach(System.out::print);
    }

    public static ArrayList<Character> findVowels(String string){
        String vowels = "aeiouAEIOU";
        ArrayList<Character> vowelsList = new ArrayList<>();
        for(char c : vowels.toCharArray()){
            vowelsList.add(c);
        }

        ArrayList<Character> findVowels = new ArrayList<>();

        for(Character c : string.toCharArray()){
            if(vowelsList.contains(c)){
                findVowels.add(c);
            }
        }

        return findVowels;
    }
}
