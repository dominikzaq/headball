package com.pkproject.headballclientserverheadball.objects;

import com.pkproject.headballclientserverheadball.settings.Settings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {
    private Circle ball;
    private int ballRadius = 20;
    public int [] positionBall =  new int[2]; //first position of element x, second position of element y
    public boolean shootBall = false;

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
    }


    public void checkPositionBall() {
        if(moveDirectionX < 0) {
            positionBall[0] += (-1)* Settings.VECOLITYBALLX;
        }
        if(moveDirectionX > 0) {
            positionBall[0] += Settings.VECOLITYBALLX;
        }

        if(moveDirectionY < 0) {
            positionBall[1] += (-1)* Settings.VECOLITYBALLY;
        }
        if(moveDirectionX > 0) {
            positionBall[1] += Settings.VECOLITYBALLY;
        }
        checkCollisionWithFrame(moveDirectionX, moveDirectionY);
        ball.setCenterX(positionBall[0]);
        ball.setCenterY(positionBall[1]);
    }


    public void checkCollisionWithFrame(int x, int y) {
        if(positionBall[0] <= 0) positionBall[0] = ballRadius;
        if(positionBall[0] >= Settings.FRAMEWIDTH) positionBall[0] = Settings.FRAMEWIDTH - ballRadius;
        if(positionBall[1] <= 0) positionBall[1] = ballRadius;
        if(positionBall[1] >= Settings.FRAMEHEIGHT) positionBall[0] = Settings.FRAMEHEIGHT - ballRadius;
    }

    //@Override
    public void checkCollisionWithBall() {

    }

    public void doRotate(Player player) {

    }




    public void moveBallXY(int vecolityballX, int vecolityballY) {

        positionBall[0] +=  (moveDirectionX * vecolityballX);
        positionBall[1] +=  (moveDirectionY * vecolityballY);

        ball.setCenterX(positionBall[0]);
        ball.setCenterY(positionBall[1]);
    }
}
