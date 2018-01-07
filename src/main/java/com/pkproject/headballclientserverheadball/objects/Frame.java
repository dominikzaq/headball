package com.pkproject.headballclientserverheadball.objects;

import com.pkproject.headballclientserverheadball.settings.Settings;
import com.pkproject.headballclientserverheadball.settings.SettingsFrame;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


public class Frame {
    private Rectangle leftGoal;
    private Rectangle rightGoal;
    private Line line;

    public Frame(){
        init();
    }


    public void init() {
        leftGoal = new Rectangle(SettingsFrame.LEFTPOSITIONRECTANGLEX, SettingsFrame.LEFTPOSITIONRECTANGLEY, SettingsFrame.GOALWIDTHRECTANGLE, SettingsFrame.GOALHEIGHTRECTANGLE);
        rightGoal = new Rectangle(SettingsFrame.RIGHTPOSITIONRECTANGLEX, SettingsFrame.RIGHTPOSITIONRECTANGLEY, SettingsFrame.GOALWIDTHRECTANGLE, SettingsFrame.GOALHEIGHTRECTANGLE);
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
