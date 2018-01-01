package com.pkproject.headball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.swing.text.GapContent;

public class Ball {
    private Circle ball;
    private int ballRadius = 20;
    int [] positionBall =  new int[2]; //first position of element x, second position of element y
    boolean movingRight = true;
    boolean movingDown = true;
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

    public void moveBall(int x, int y) {
        positionBall[0] += x;
        positionBall[1] += y;
        checkCollisionWithFrame(x, y);
        ball.setCenterX(positionBall[0]);
        ball.setCenterY(positionBall[1]);
    }


    public void checkCollisionWithFrame(int x, int y) {
        if(positionBall[0] <= 0) positionBall[0] -= x;
        if(positionBall[0] >= Settings.FRAMEWIDTH) positionBall[0] -= x;
        if(positionBall[1] <= 0) positionBall[0] -= y;
        if(positionBall[1] >= Settings.FRAMEHEIGHT) positionBall[0] -= y;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    //@Override
    public void checkCollisionWithBall() {

    }

    public void doRotate(Player player) {

    }
}
