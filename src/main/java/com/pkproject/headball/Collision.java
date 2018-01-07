package com.pkproject.headball;

public interface Collision {
    public void checkCollisionWithGoal(Ball ball, Player player);

    public void checkCollisionsBallWithPlayer(Ball ball, Player[] players);

    public boolean checkCollisionsBallWithGoal(Ball ball);

    public void checkCollisionWithGoal(Ball ball, Player player1, Player player2);

    boolean checkCollisionPlayerWithGoal(Player player);
}