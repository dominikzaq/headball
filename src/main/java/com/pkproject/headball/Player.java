package com.pkproject.headball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player implements Border{
    private Circle ball;
    private int ballRadius = 35;
    private Color colorPlayer;
    int[] positionPlayer = new int[2]; //first position of element x, second position of element y

    /*
     * creating ball
     */

    public Player(int positionX, int positionY, Color color) {
        positionPlayer[0] = positionX;
        positionPlayer[1] = positionY;
        colorPlayer = color;
    }

    public void initBall() {
        ball = new Circle();
        ball.setCenterX(positionPlayer[0]);
        ball.setCenterY(positionPlayer[1]);
        ball.setRadius(ballRadius);
        ball.setFill(colorPlayer);
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
        positionPlayer[1] -= y;
        checkCollisionWithFrameY(y);
        ball.setCenterY(positionPlayer[1]);
    }

    public void moveElementX(int x) {
        positionPlayer[0] -= x;
        checkCollisionWithFrameX(x);

        ball.setCenterX(positionPlayer[0]);
    }


    public void checkCollisionWithFrameX(int x) {
        if((positionPlayer[0]  >= Settings.FRAMEWIDTH) || (positionPlayer[0] <= 0) ){
            positionPlayer[0] += x;
        }
    }

    public void checkCollisionWithFrameY(int y) {
        if((positionPlayer[1]  >= Settings.FRAMEHEIGHT) || (positionPlayer[1] <= 0) ){
            positionPlayer[1] += y;
        }
    }

    @Override
    public void checkCollisionWithFrame() {

    }

    @Override
    public void checkCollisionWithBall() {

    }
}
