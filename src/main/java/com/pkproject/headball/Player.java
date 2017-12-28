package com.pkproject.headball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player implements Border{
    private Circle ball;
    private int ballRadius = 35;

    int[] positionPlayer = new int[2]; //first position of element x, second position of element y

    /*
     * creating ball
     */

    public Player(int positionX, int positionY) {
        positionPlayer[0] = positionX;
        positionPlayer[1] = positionY;
    }

    public void initBall() {
        ball = new Circle();
        ball.setCenterX(positionPlayer[0]);
        ball.setCenterY(positionPlayer[1]);
        ball.setRadius(ballRadius);
        ball.setFill(Color.RED);
    }

    public Circle getBall() {
        return ball;
    }

    public void initFaillingBall() {

    }

    public void setCenterX(int positionX) {
        positionPlayer[0] = positionX;
    }

    public void setCenterY(int positionY) {
        positionPlayer[1] = positionY;
    }

    public void speedBall() {
    }

    public void moveElementY(int y) {
       // checkCollisionWithFrame(y);
        positionPlayer[1] -= y;

        ball.setCenterY(positionPlayer[1]);
    }

    public void moveElementX(int x) {
        positionPlayer[0] -= x;

       //checkCollisionWithFrame

        ball.setCenterX(positionPlayer[0]);
    }


    @Override
    public void checkCollisionWithFrame() {
       // if(positionPlayer[0] -  >=) {

       // }
    }

    @Override
    public void checkCollisionWithBall() {

    }
}
