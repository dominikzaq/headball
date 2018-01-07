package com.pkproject.headballclientserverheadball.objects;

public class StateGame {
    private boolean startGame = false;
    private boolean endGame  = false;

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
