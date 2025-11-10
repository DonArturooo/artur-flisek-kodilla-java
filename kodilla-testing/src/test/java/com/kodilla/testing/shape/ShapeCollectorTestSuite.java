package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Collector Test Suite")
class ShapeCollectorTestSuite {

    private static int testCounter = 0;
    private static final ShapeCollector shapeCollector = new ShapeCollector();

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Test adding shapes")
    class TestCircle {
        @Test
        @DisplayName("Add Circle")
        public void addCircle() {
            Circle circle = new Circle(5);

            shapeCollector.addFigure(circle);

            Assertions.assertInstanceOf(Circle.class, shapeCollector.getFigure(0));
        }

        @Test
        @DisplayName("Add Square")
        public void addSquare() {
            Square square = new Square(5);

            shapeCollector.addFigure(square);

            Assertions.assertInstanceOf(Square.class, shapeCollector.getFigure(1));
        }

        @Test
        @DisplayName("Add Triangle")
        public void addTriangle() {
            Triangle triangle = new Triangle(5, 2, 4);

            shapeCollector.addFigure(triangle);

            Assertions.assertInstanceOf(Triangle.class, shapeCollector.getFigure(2));
        }
    }

    @Nested
    @DisplayName("Test remove shape")
    class TestSquare {
        @Test
        @DisplayName("Testing to remove not exists shape on list")
        public void removeNotExistsShape() {
            Square square = new Square(15);

            Assertions.assertFalse(shapeCollector.removeFigure(square));
        }

        @Test
        @DisplayName("Remove Circle")
        public void removeCircle() {
            Circle circle = new Circle(15);

            shapeCollector.addFigure(circle);

            Assertions.assertTrue(shapeCollector.removeFigure(circle));
        }

        @Test
        @DisplayName("Add Square")
        public void removeSquare() {
            Square square = new Square(5);

            shapeCollector.addFigure(square);

            Assertions.assertTrue(shapeCollector.removeFigure(square));
        }

        @Test
        @DisplayName("Add Triangle")
        public void removeTriangle() {
            Triangle triangle = new Triangle(25, 21, 41);

            shapeCollector.addFigure(triangle);

            Assertions.assertTrue(shapeCollector.removeFigure(triangle));
        }
    }

    @DisplayName("Show Figures")
    @Test
    public void showFigures() {
        Assertions.assertEquals("Circle, Square, Triangle", shapeCollector.showFigures());
    }
}
