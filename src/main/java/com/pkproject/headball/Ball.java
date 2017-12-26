package com.pkproject.headball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {
    private Circle ball;
    private int ballRadius = 20;

    int [] positionBall =  {900/2,550}; //first element x, second element y

    /*
     * creating ball
     */
    public void initBall() {
        ball = new Circle();
        ball.setCenterX(positionBall[0]);
        ball.setCenterY(positionBall[1]);
        ball.setRadius(ballRadius);
        ball.setFill(Color.BLUE);
    }

    public Circle getBall() {
        return ball;
    }

    public void initFaillingBall() {

    }
}
