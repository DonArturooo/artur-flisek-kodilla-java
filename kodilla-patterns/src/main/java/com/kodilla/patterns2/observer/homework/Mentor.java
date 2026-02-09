package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int totalTaskToCheck;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Kursant kursant) {
        int taksSize = kursant.getTasks()
                              .size();
        boolean moreThenOneTask = taksSize > 1;
        System.out.println("Kursant: " + kursant.getName() + " ma do sprawdzenia " + taksSize + (moreThenOneTask ? " zadania" : " zadanie") + ".");
        totalTaskToCheck++;
    }

    public String getName() {
        return name;
    }

    public int getTotalTaskToCheck() {
        return totalTaskToCheck;
    }
}
