package com.pkproject.headball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {
    private Circle ball;
    private int ballRadius = 20;

    private int positionX;
    private int positionY;
    private int velocityBallX;
    private int velocityBallY;

    int [] positionBall =  {900/2,550};

    /*
     * creating ball
     */
    public void initBall() {
        ball = new Circle();
        ball.setCenterX(positionBall[0]);
        ball.setCenterY(positionBall[1]);
        ball.setRadius(ballRadius);
        ball.setFill(Color.BLUE);
        initPosition();
    }

    public void initPosition() {
        positionX = 100;
        positionY = 200;
    }

    public Circle getBall() {
        return ball;
    }

    public void setBall(Circle ball) {
        this.ball = ball;
    }

    public void initFaillingBall() {

    }
}
