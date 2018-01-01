package com.pkproject.headball;

import javafx.scene.shape.Circle;

public class CollisionImpl implements Collision {
    @Override
    public void checkCollisionWithGoal(Ball ball, Player player) {
        playerWithGoal(player);
        ballWithGoal(ball);
    }

    public void playerWithGoal(Player player) {
        Circle p = player.getPlayerBall();
        /*if(p.intersects(bo)) {

        }*/

    }

    public void ballWithGoal(Ball ball) {
        Circle b = ball.getBall();


    }

    @Override
    public void checkCollisionsBallWithPlayer(Ball ball,Player [] players) {
        if(players[0].getBall() == null && ball.getBall().intersects(players[0].getPlayerBall().getBoundsInLocal())) {
           players[0].setBall(ball.getBall());
            //player can hold ball
            if(players[1].getBall() != null) {
                players[1].setBall(null);
            }
        }

        if(players[1].getBall() == null && ball.getBall().intersects(players[1].getPlayerBall().getBoundsInLocal())) {
            players[1].setBall(ball.getBall());
            //player can hold ball
            if(players[0].getBall() != null) {
                players[0].setBall(null);
           }
        }
    }

    @Override
    public void checkCollisionsBallWithGoal() {

    }
}
