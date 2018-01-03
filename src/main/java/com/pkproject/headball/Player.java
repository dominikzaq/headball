package com.pkproject.headball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player {
    private Collision collision;
    private Ball ball;
    Circle circleBall;
    private Circle playerBall;
    private int playerBallRadius = 35;
    private Color colorPlayer;
    int[] positionPlayer = new int[2]; //first position of element x, second position of element y
    boolean playerShoot = false;

    /*
     * creating ball
     */

    public Player(int positionX, int positionY, Color color) {
        positionPlayer[0] = positionX;
        positionPlayer[1] = positionY;
        colorPlayer = color;
        ball = null;
        collision = new CollisionImpl();
    }

    public void initBall() {
        playerBall = new Circle();
        playerBall.setCenterX(positionPlayer[0]);
        playerBall.setCenterY(positionPlayer[1]);
        playerBall.setRadius(playerBallRadius);
        playerBall.setFill(colorPlayer);
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
        positionPlayer[1] += y;
        checkCollisionWithFrameY(y);
        playerBall.setCenterY(positionPlayer[1]);

        if (ball != null) {
            if (y > 0) {
                ball.getBall().setCenterY(positionPlayer[1] + ball.getBall().getRadius() + playerBallRadius + 1);
                ball.moveDirectionX = -1;
            }
            else  {
                ball.getBall().setCenterY(positionPlayer[1] - ball.getBall().getRadius() - playerBallRadius - 1);
                ball.moveDirectionX = 1;
            }
            ball.getBall().setCenterX(positionPlayer[0]);
            ball.moveDirectionY = 0;
        }

    }

    public void moveElementX(int x) {
        positionPlayer[0] += x;
        checkCollisionWithFrameX(x);
        playerBall.setCenterX(positionPlayer[0]);

        if (ball != null) {
            if (x > 0) {
                ball.getBall().setCenterX(positionPlayer[0] + ball.getBall().getRadius() + playerBallRadius + 1);
                ball.moveDirectionX = 1;
            }
            else {
                ball.getBall().setCenterX(positionPlayer[0] - ball.getBall().getRadius() - playerBallRadius - 1);
                ball.moveDirectionX = -1;
            }
            ball.getBall().setCenterY(positionPlayer[1]);
            ball.moveDirectionY = 0;
        }


    }

    public Circle getPlayerBall() {
        return playerBall;
    }

    public void setPlayerBall(Circle playerBall) {
        this.playerBall = playerBall;
    }

    public void checkCollisionWithFrameX(int x) {

        if((positionPlayer[0]  >= Settings.FRAMEWIDTH) || (positionPlayer[0] <= 0) ){
            positionPlayer[0] -= x;
        }
    }

    public void checkCollisionWithFrameY(int y) {

        if((positionPlayer[1]  >= Settings.FRAMEHEIGHT) || (positionPlayer[1] <= 0)){
            positionPlayer[1] -= y;
        }
    }

    public void checkCollisionWithFrame() {

    }

    public void checkCollisionWithBall(Ball ball) {

    }

    public void shoot() {
        playerShoot = true;
       // ball.moveDirectionX =
        //we shoot when have ball
        if(ball != null) {
            ball = null;
        }

    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}
