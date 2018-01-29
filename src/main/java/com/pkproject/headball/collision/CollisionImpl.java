package com.pkproject.headball.collision;

import com.pkproject.headball.objects.Ball;
import com.pkproject.headball.objects.Frame;
import com.pkproject.headball.objects.Player;
import com.pkproject.headball.objects.Score;
import com.pkproject.headball.settings.Settings;
import javafx.scene.shape.Circle;

public class CollisionImpl implements Collision {
    private Frame frame;

    public CollisionImpl() {
        frame = new Frame();
    }

    @Override
    public void checkCollisionWithGoal(Ball ball, Player player1, Player player2) {
        checkCollisionPlayerWithGoal(player1);
        checkCollisionPlayerWithGoal(player2);
    }

    @Override
    public boolean checkCollisionPlayerWithGoal(Player player) {
        Circle pl = player.getPlayerBall();
        if(pl.intersects(frame.getLeftGoal().getBoundsInLocal()))
            return true;


        if(pl.intersects(frame.getRightGoal().getBoundsInLocal()))
            return true;

        return false;
    }

    public void checkCollisionsBallWithFrame(Ball ball) {
        if(ball.positionBall[0] <= 0) {
            ball.positionBall[0] = ball.ballRadius;
            Ball.moveDirectionX *=-1;
        }
        if(ball.positionBall[0] >= Settings.FRAMEWIDTH) {
            ball.positionBall[0] = Settings.FRAMEWIDTH - ball.ballRadius;
            Ball.moveDirectionX *=-1;
        }
        if(ball.positionBall[1] <= 0) {
            ball.positionBall[1] = ball.ballRadius;
            Ball.moveDirectionY *=-1;
        }
        if(ball.positionBall[1] >= Settings.FRAMEHEIGHT) {
            ball.positionBall[1] = Settings.FRAMEHEIGHT - ball.ballRadius;
            Ball.moveDirectionY *=-1;
        }
    }

    @Override
    public boolean checkCollisionsBallWithPlayer(Ball ball, Player[] players) {
        if(players[0].getBall() == null && ball.getBall().intersects(players[0].getPlayerBall().getBoundsInLocal())) {
            players[0].setBall(ball);
            //player can hold ball
            if(players[1].getBall() != null) {
                players[1].setBall(null);
            }
            return true;
        }

        if(players[1].getBall() == null && ball.getBall().intersects(players[1].getPlayerBall().getBoundsInLocal())) {
            players[1].setBall(ball);
            //player can hold ball
            if(players[0].getBall() != null) {
                players[0].setBall(null);
           }
           return true;
        }
        return false;
    }

    @Override
    public boolean checkCollisionsBallWithGoal(Ball ball) {
        Circle b = ball.getBall();
        if(b.intersects(frame.getLeftGoal().getBoundsInLocal())) {
            Score.resultPlayer2 += 1;
            return true;
        }

        if(b.intersects(frame.getRightGoal().getBoundsInLocal())) {
            Score.resultPlayer1 += 1;
            return true;
        }
        return false;
    }

}
