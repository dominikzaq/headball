package com.pkproject.headball;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main extends Application  /*implements EventHandler <KeyEvent> */{
    private Canvas canvas;
    private Group root;
    private Player [] player;
    private Ball ball;

    private GraphicsContext gc;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("headball");
        initBall();
        initPlayers();
        initUI(stage);
    }

    private void initUI(Stage stage) throws FileNotFoundException {
        root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        canvas = new Canvas(Settings.FRAMEWIDTH, Settings.FRAMEHEIGHT);
        root.getChildren().add(canvas);

        root.getChildren().add(ball.getBall());

        gc = canvas.getGraphicsContext2D();


        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);

        //start game
        AnimationTimer timer = new MyTimer();
        timer.start();

        stage.show();
    }

    public void initBall() {
        ball = new Ball(Settings.POSITIONBALL2X, Settings.POSITIONBALL1Y);
        ball.initBall();
    }


    public void initPlayers() {
        player = new Player[2];
        player[0] = new Player(Settings.URL, Settings.POSITIONPLAYER1X, Settings.POSITIONPLAYER1Y);
        player[1] = new Player(Settings.URL,Settings.POSITIONPLAYER2X, Settings.POSITIONPLAYER2Y);
    }

    private class MyTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
           doHandle();
        }

        public void doHandle() {
            player[0].checkBorder();
            player[1].checkBorder();

            gc.setFill( Color.BLACK );
            gc.fillRect(0,0, Settings.FRAMEWIDTH,Settings.FRAMEHEIGHT);

            gc.drawImage(player[0].getImage(),player[0].getPositionX(),player[0].getPositionY());
            gc.drawImage(player[1].getImage(),player[1].getPositionX(),player[1].getPositionY());

             //ball.setCenterX(10);
            //ball.setCenterY();
        }
    }


    void checkCollisions() {

    }

    private EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case W: player[0].moveElementUP(Settings.VECOLITYPLAYERX, Settings.VECOLITYPLAYERY); break;
                case A: player[0].moveElementLeft(Settings.VECOLITYPLAYERX, Settings.VECOLITYPLAYERY);break;
                case D: player[0].moveElementRight(Settings.VECOLITYPLAYERX, Settings.VECOLITYPLAYERY);break;
                case SPACE: break;

                case UP: player[1].moveElementUP(Settings.VECOLITYPLAYERX, Settings.VECOLITYPLAYERY);break;
                case LEFT: player[1].moveElementLeft(Settings.VECOLITYPLAYERX, Settings.VECOLITYPLAYERY);break;
                case RIGHT: player[1].moveElementRight(Settings.VECOLITYPLAYERX, Settings.VECOLITYPLAYERY);break;
                case P: break;
            }
        }
    };


    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case W: player[0].moveElementUP(Settings.VECOLITYPLAYERX, -Settings.VECOLITYPLAYERY); break;
                case A: player[0].moveElementLeft(0, 0);break;
                case D: player[0].moveElementRight(0, 0);break;
                case SPACE: break;

                case UP: player[1].moveElementUP(Settings.VECOLITYPLAYERX, -Settings.VECOLITYPLAYERY);break;
                case LEFT: player[1].moveElementLeft(0, 0);break;
                case RIGHT: player[1].moveElementRight(0, 0);break;
                case P: break;
            }
        }
    };

    public static void main(String[] args) {
        launch(args);
    }
}
