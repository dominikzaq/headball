package com.pkproject.headball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.swing.text.GapContent;

public class Ball  implements Border{
    private Circle ball;
    private int ballRadius = 20;

    int [] positionBall =  new int[2]; //first position of element x, second position of element y

    /*
     * creating ball
     */

    public Ball(int positionX, int positionY) {
        positionBall[0] = positionX;
        positionBall[1] = positionY;
    }

    public void initBall() {
        ball = new Circle();
        ball.setCenterX(positionBall[0]);
        ball.setCenterY(positionBall[1]);
        ball.setRadius(ballRadius);
        ball.setFill(Color.WHITE);
    }

    public Circle getBall() {
        return ball;
    }

    public void initFaillingBall() {

    }

    public void setCenterX(int positionX) {
        positionBall[0] = positionX;
    }

    public void setCenterY(int positionY) {
        positionBall[1] = positionY;
    }

    public void speedBall() {

    }

    public boolean isGoal() {
        return false;
    }

    public int[] getPositionBall() {
        return positionBall;
    }

    public void setPositionBall(int[] positionBall) {
        this.positionBall = positionBall;
    }

    @Override
    public void checkCollisionWithFrame() {
       // if(positionBall) {

       // }
    }

    @Override
    public void checkCollisionWithBall() {

    }
}
