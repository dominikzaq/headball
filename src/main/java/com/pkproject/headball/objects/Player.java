package com.pkproject.headball.objects;

import com.pkproject.headball.collision.Collision;
import com.pkproject.headball.collision.CollisionImpl;
import com.pkproject.headball.settings.Settings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player {
    private Collision collision;
    private Ball ball;
    private Circle playerBall;
    private int playerBallRadius = 35;
    private Color colorPlayer;
    int[] positionPlayer = new int[2]; //first position of element x, second position of element y
    public boolean playerShoot = false;
    public static int counterPlayer = 0;

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
        initRestartPlayerBall(positionPlayer[0], positionPlayer[1]);
        playerBall.setRadius(playerBallRadius);
        playerBall.setFill(colorPlayer);
    }


    public void initRestartPlayerBall(int positionX, int positionY) {
        positionPlayer[0] = positionX;
        positionPlayer[1] = positionY;
        playerBall.setCenterX(positionPlayer[0]);
        playerBall.setCenterY(positionPlayer[1]);
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
        int positionPlayerBallX;
        int positionPlayerBallY;

        positionPlayer[1] += y;
        checkCollisionWithFrameY(y);
        playerBall.setCenterY(positionPlayer[1]);

        if (ball != null) {
            if (y > 0) {
                positionPlayerBallY = (int) (positionPlayer[1] + ball.getBall().getRadius() + playerBallRadius + 1);
                Ball.moveDirectionY = 1;
            }
            else  {
                positionPlayerBallY = (int)(positionPlayer[1] - ball.getBall().getRadius() - playerBallRadius - 1);
                Ball.moveDirectionY = -1;

            }
            positionPlayerBallX = positionPlayer[0];
            ball.setPositionBall(new int[]{positionPlayerBallX, positionPlayerBallY});
            Ball.moveDirectionX = 0;
        }

    }

    public void moveElementX(int x) {
        positionPlayer[0] += x;
        checkCollisionWithFrameX(x);
        playerBall.setCenterX(positionPlayer[0]);
        int positionPlayerBallX;
        int positionPlayerBallY;
        //position football ball
        //check collision
        if (ball != null) {
            if (x > 0) {
                positionPlayerBallX = (int) (positionPlayer[0] + ball.getBall().getRadius() + playerBallRadius + 1);
                Ball.moveDirectionX = 1;
            }
            else {
                positionPlayerBallX = (int) (positionPlayer[0] - ball.getBall().getRadius() - playerBallRadius - 1);
                Ball.moveDirectionX = -1;
            }

            positionPlayerBallY = positionPlayer[1];
            ball.setPositionBall(new int[]{positionPlayerBallX, positionPlayerBallY});
            Ball.moveDirectionY = 0;
        }
    }

    public Circle getPlayerBall() {
        return playerBall;
    }

    public void setPlayerBall(Circle playerBall) {
        this.playerBall = playerBall;
    }

    public void checkCollisionWithFrameX(int x) {
        if(positionPlayer[0]  >= Settings.FRAMEWIDTH)
            positionPlayer[0] = Settings.FRAMEWIDTH - playerBallRadius;

        if(positionPlayer[0] <= 0)
            positionPlayer[0] = playerBallRadius;

    }

    public void checkCollisionWithFrameY(int y) {
        if(positionPlayer[1]  >= Settings.FRAMEHEIGHT)
            positionPlayer[1] = Settings.FRAMEHEIGHT - playerBallRadius;
        if(positionPlayer[1] <= 0)
            positionPlayer[1] = playerBallRadius;

    }


    public void shoot() {
        //we shoot when have ball
        if(ball != null) {
            playerShoot = true;
            ball = null;
            Ball.counterShoot = 0;
        }
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}
