package com.pkproject.headball;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application  /*implements EventHandler <KeyEvent> */{
    final int WIDTHFRAME = 900;
    final int HEIGHTFRAME = 600;

    private Canvas canvas;
    private Group root;
    private Player player;
    private Ball ball;

    @Override
    public void start(Stage stage) {
        stage.setTitle("headball");
        initUI(stage);
    }

    private void initUI(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);


        Canvas canvas = new Canvas( WIDTHFRAME, HEIGHTFRAME);
        root.getChildren().add(canvas);

        //Image player1 = new Image( new File("anim-0.png").toURI().toString());
        //GraphicsContext gc = canvas.getGraphicsContext2D();
       // gc.drawImage(player1,200,200);


        initBall();
        root.getChildren().add(ball.getBall());


        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);

        //start game
        AnimationTimer timer = new MyTimer();
        timer.start();



        stage.show();
    }

    public void initBall() {
        ball = new Ball();
        ball.initBall();
    }

    public void initCanvas() {

    }

    public void initPlayer() {
        player = new Player();

    }
    private class MyTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
           doHandle();
        }

        public void doHandle() {
           // ball.setCenterX(10);
          //  ball.setCenterY(Ball.positionY);
        }
    }


    private EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
              /*  case W: i+= 10; break;
                case A: i+= 10;break;
                case S: i+= 10;break;
                case D: i+= 10;break;
                case SPACE: break;

                case UP: i+= 10;break;
                case DOWN: i+= 10;break;
                case LEFT: i+= 10;break;
                case RIGHT: i+= 10;break;
                case P: i+= 10;break;*/

            }
        }
    };



    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {

        }
    };

    public static void main(String[] args) {
        launch(args);
    }
}
