package com.pkproject.headball;

public interface Collision {
    public void checkCollisionWithGoal(Ball ball, Player player);
    public void checkCollisionsBallWithPlayer(Ball ball,Player [] players);
    public void checkCollisionsBallWithGoal();
}