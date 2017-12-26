package com.pkproject.headball;

import javafx.scene.image.Image;

public class Player {
    private String namePlayer;
    private int positionX;
    private int positionY;
    private Score result;
    private Image image;

    public Player(String url, int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        image = new Image(url);
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Score getResult() {
        return result;
    }

    public void setResult(Score result) {
        this.result = result;
    }

    public Image getImage() {
        return image;
    }

    public void moveElementUP(int x, int y) {
        positionX += 0;
        positionY -= y;
    }

    public void moveElementLeft(int x, int y) {
        positionX -= x;
        positionY += 0;
    }
    public void moveElementRight(int x, int y) {
        positionX += x;
        positionY += 0;
    }

    public void checkBorder() {
        positionX = positionX > Settings.FRAMEHEIGHT? positionX-Settings.VECOLITYPLAYERX :
                positionX < 0?positionX+Settings.VECOLITYPLAYERX: positionX;
    }
}
