package com.pkproject.headball;

public class Score {

    public static int i = 0;
    int resultPlayer1;
    int resultPlayer2;

    public int getResultPlayer1() {
        return resultPlayer1;
    }

    public void setResultPlayer1(int resultPlayer1) {
        this.resultPlayer1 = resultPlayer1;
    }

    public int getResultPlayer2() {
        return resultPlayer2;
    }

    public void setResultPlayer2(int resultPlayer2) {
        this.resultPlayer2 = resultPlayer2;
    }

    // if false game is not complete otherwise the end game
    public boolean checkEndGame() {
        return i > 4;
    }

    public void saveResult() { }
}
