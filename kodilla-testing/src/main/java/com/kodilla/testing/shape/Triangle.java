package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        double s = (double) (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return a == triangle.a && b == triangle.b && c == triangle.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
