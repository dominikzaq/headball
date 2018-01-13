package com.pkproject.headballclientserverheadball.objects;

public class StateGame {
    public boolean startGame;
    public boolean endGame;
    public boolean running;

    public StateGame() {
      startGame = false;
      endGame = false;
      running = false;
    }

    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
