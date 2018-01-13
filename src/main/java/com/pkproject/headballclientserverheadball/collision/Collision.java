package com.pkproject.headballclientserverheadball.collision;

import com.pkproject.headballclientserverheadball.objects.Ball;
import com.pkproject.headballclientserverheadball.objects.Player;

public interface Collision {
    public void checkCollisionWithGoal(Ball ball, Player player);

    public boolean checkCollisionsBallWithPlayer(Ball ball, Player[] players);

    public boolean checkCollisionsBallWithGoal(Ball ball);

    public void checkCollisionWithGoal(Ball ball, Player player1, Player player2);

    boolean checkCollisionPlayerWithGoal(Player player);
    void checkCollisionsBallWithFrame(Ball ball);
}