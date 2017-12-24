package com.pkproject.headball.images;

import com.sun.prism.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {
    private  Circle ball;

    public void initBall() {
        ball = new Circle();
        ball.setCenterX(150);
        ball.setCenterY(150);
        ball.setRadius(150);

    }
}
