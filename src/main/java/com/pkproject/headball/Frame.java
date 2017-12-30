package com.pkproject.headball;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Frame {
    private Rectangle leftGoal;
    private Rectangle rightGoal;
    private Line line;

    Frame(){
        init();
    }


    public void init() {
        leftGoal = new Rectangle(0,0,50,200);
        rightGoal = new Rectangle(250,250, 200,  250);
        leftGoal.setFill(Color.WHITE);
        rightGoal.setFill(Color.WHITE);
        line = new Line(Settings.FRAMEWIDTH/2, 0,   Settings.FRAMEWIDTH/2, Settings.FRAMEHEIGHT);
        line.setStroke(Color.WHITE);
    }


    public Rectangle getLeftGoal() {
        return leftGoal;
    }

    public void setLeftGoal(Rectangle leftGoal) {
        this.leftGoal = leftGoal;
    }

    public Rectangle getRightGoal() {
        return rightGoal;
    }

    public void setRightGoal(Rectangle rightGoal) {
        this.rightGoal = rightGoal;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    class Goal {

    }

}
