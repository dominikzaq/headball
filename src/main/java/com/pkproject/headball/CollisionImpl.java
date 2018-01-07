package com.pkproject.headball;

import javafx.scene.shape.Circle;

public class CollisionImpl implements Collision {
    private Frame frame;

    CollisionImpl() {
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
        if(pl.intersects(frame.getLeftGoal().getBoundsInLocal())) {
            return true;
        }

        if(pl.intersects(frame.getRightGoal().getBoundsInLocal())) {
            return true;
        }
        return false;
    }


    @Override
    public void checkCollisionWithGoal(Ball ball, Player player) {

    }

    @Override
    public void checkCollisionsBallWithPlayer(Ball ball,Player [] players) {
        if(players[0].getBall() == null && ball.getBall().intersects(players[0].getPlayerBall().getBoundsInLocal())) {
            players[0].setBall(ball);
            //player can hold ball
            if(players[1].getBall() != null) {
                players[1].setBall(null);
            }
        }

        if(players[1].getBall() == null && ball.getBall().intersects(players[1].getPlayerBall().getBoundsInLocal())) {
            players[1].setBall(ball);
            //player can hold ball
            if(players[0].getBall() != null) {
                players[0].setBall(null);
           }
        }
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
