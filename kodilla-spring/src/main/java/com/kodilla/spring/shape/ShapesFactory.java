package com.kodilla.spring.shape;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.Random;

@Configuration
public class ShapesFactory {

    @Bean
    public Square createSquare() {
        return new Square();
    }

    @Bean
    public Shape chosenShape() {
        Shape theShape;
        Random rand = new Random();

        int chosen = rand.nextInt(3);

        theShape = switch (chosen) {
            case 0 -> new Triangle();
            case 1 -> new Circle();
            default -> new Square();
        };

        return theShape;
    }
}
