package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class DrawerTestSuite {

    @Test
    void testDoDrawingWithCircle() {
        Circle circle = new Circle();

        Drawer drawer = new Drawer(circle);

        assertEquals("This is a circle", drawer.doDrawing());
    }

    @Test
    void testDoDrawingWithTriangle() {
        Triangle triangle = new Triangle();

        Drawer drawer = new Drawer(triangle);

        assertEquals("This is a triangle", drawer.doDrawing());
    }
}
