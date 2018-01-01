package com.pkproject.headball;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameCreator {
    private Ball ball;
    private Player[] players;

    GameCreator() {
        initBall();
        initPlayers();
    }

    public void initBall() {
        ball = new Ball(Settings.POSITIONBALLX, Settings.POSITIONBALLY);
        ball.initBall();
    }


    public void initPlayers() {
        players = new Player[2];
        players[0] = new Player(Settings.POSITIONPLAYER1X, Settings.POSITIONPLAYER1Y, Color.RED);
        players[1] = new Player(Settings.POSITIONPLAYER2X, Settings.POSITIONPLAYER2Y, Color.BLUE);
        players[0].initBall();
        players[1].initBall();
    }


    public Ball getBall() {
        return ball;
    }

    public Player[] getPlayers() {
        return players;
    }
}
