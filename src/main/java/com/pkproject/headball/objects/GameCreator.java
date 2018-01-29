package com.pkproject.headball.objects;

import com.pkproject.headball.settings.Settings;
import javafx.scene.paint.Color;

public class GameCreator {
    private Ball ball;
    private Player[] players;

    public GameCreator() {
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


    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Ball getBall() {
        return ball;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void restartGame(Ball ball, Player[] players) {
        ball.setBall(Settings.POSITIONBALLX, Settings.POSITIONBALLY);
        players[0].initRestartPlayerBall(Settings.POSITIONPLAYER1X, Settings.POSITIONPLAYER1Y);
        players[1].initRestartPlayerBall(Settings.POSITIONPLAYER2X, Settings.POSITIONPLAYER2Y);
    }
}
