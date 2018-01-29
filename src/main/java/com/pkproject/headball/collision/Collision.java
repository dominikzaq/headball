package com.pkproject.headball.collision;

import com.pkproject.headball.objects.Ball;
import com.pkproject.headball.objects.Player;

public interface Collision {
    public boolean checkCollisionsBallWithPlayer(Ball ball, Player[] players);

    public boolean checkCollisionsBallWithGoal(Ball ball);

    public void checkCollisionWithGoal(Ball ball, Player player1, Player player2);

    boolean checkCollisionPlayerWithGoal(Player player);
    void checkCollisionsBallWithFrame(Ball ball);
}