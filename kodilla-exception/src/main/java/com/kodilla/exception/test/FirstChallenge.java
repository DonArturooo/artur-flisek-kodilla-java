package com.kodilla.exception.test;

public class FirstChallenge {
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public int pow(int a, int b) throws ArithmeticException {
        if (a < 0 || b < 0) {
            throw new ArithmeticException("Numbers should be bigger then 0");
        }

        if(a == 0){
            return 0;
        }

        if(b == 0){
            return 1;
        }

        if(b == 1){
            return a;
        }

        return (int)Math.pow(a, b);
    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e){
            System.out.println("nie dzielimy przez 0");
        }

        try {
            int result = firstChallenge.pow(25, 3);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
