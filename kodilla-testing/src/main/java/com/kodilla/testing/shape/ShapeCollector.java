package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int index) {
        if (index < 0 || index >= shapes.size()){
            return null;
        }

        return shapes.get(index);
    }

    public String showFigures() {
        StringBuilder str = new StringBuilder();

        for  (int index = 0; index < shapes.size(); index++){
            Shape shape = shapes.get(index);

            str.append(shape.getShapeName());

            if (index < shapes.size() - 1){
                str.append(", ");
            }
        }

        return str.toString();
    }
}
