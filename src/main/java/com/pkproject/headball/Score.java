package com.pkproject.headball;

public class Score {
    public static int countScore = 0;
    public static int resultPlayer1;
    public static int resultPlayer2;

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
        return !(resultPlayer1 > 2 || resultPlayer2 > 2);
    }
    public String whoWon() {
        return resultPlayer1 > 2? "Player 1 won" : "Player 2 won";
    }
    public void saveResult() { }
}
