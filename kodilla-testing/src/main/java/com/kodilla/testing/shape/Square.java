package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    int x;

    public Square(int x) {
        this.x = x;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return x * x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return x == square.x;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x);
    }
}
