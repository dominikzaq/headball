package com.pkproject.headballclientserverheadball.objects;

public class StateGame {
    public boolean startGame;
    public boolean endGame;

    public StateGame() {
      startGame = false;
      endGame = false;
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


}
