package com.pkproject.headball.objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {
    private Circle ball;
    public  int ballRadius = 20;
    public int [] positionBall =  new int[2]; //first position of element x, second position of element y
    private boolean shoot = false;
    public static int counterShoot = 150;
    //just move
    public static int moveDirectionX = 0; //0 not moving 1 right -1 moving left
    public static int moveDirectionY = 0; //0 not moving 1 moving up -1 moving down
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
    public void setBall(int positionX, int positionY) {
        positionBall[0] = positionX;
        positionBall[1] = positionY;

        ball.setCenterX(positionBall[0]);
        ball.setCenterY(positionBall[1]);
        ball.setRadius(ballRadius);
        ball.setFill(Color.WHITE);
    }

    public Circle getBall() {
        return ball;
    }


    public boolean isGoal() {
        return false;
    }

    public int[] getPositionBall() {
        return positionBall;
    }

    public void setPositionBall(int[] positionBall) {
        this.positionBall = positionBall;
        ball.setCenterX(positionBall[0]);
        ball.setCenterY(positionBall[1]);
    }

    public void moveBallXY(int vecolityballX, int vecolityballY) {
        System.out.println("pxb"+positionBall[0]);
        System.out.println("pyb"+positionBall[1]);

        positionBall[0] += (moveDirectionX *vecolityballX);
        positionBall[1] += (moveDirectionY * vecolityballY);
        ball.setCenterX(positionBall[0]);
        ball.setCenterY(positionBall[1]);


        System.out.println("pxb"+positionBall[0]);
        System.out.println("pyb"+positionBall[1]);
    }

    public boolean isShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public int getCounterShoot() {
        return counterShoot;
    }

    public void setCounterShoot(int counterShoot) {
        this.counterShoot = counterShoot;
    }
}
