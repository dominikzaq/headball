package com.pkproject.headball;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class Main extends Application  /*implements EventHandler <KeyEvent> */{
    private Canvas canvas;
    private Group root;
    private Ball ball;
    private GraphicsContext gc;
    private Player[] players;
    private Frame frame;

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

        root.getChildren().add(players[0].getBall());
        root.getChildren().add(players[1].getBall());
        root.getChildren().add(ball.getBall());


        frame = new Frame();
        root.getChildren().add(frame.getLine());
        root.getChildren().add(frame.getLeftGoal());
        root.getChildren().add(frame.getRightGoal());

        gc = canvas.getGraphicsContext2D();

        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);


        //start game
        AnimationTimer timer = new MyTimer();
        timer.start();

       // Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3),
               // new KeyValue(ball.getPositionBall()[0], ball.getPositionBall()[0]));
        //timeline.setCycleCount(2);
        //timeline.play();

        stage.show();
    }

    public void initBall() {
        ball = new Ball(Settings.POSITIONBALLX, Settings.POSITIONBALLY);
        ball.initBall();
    }


    public void initPlayers() {
        players = new Player[2];
        players[0] = new Player(Settings.POSITIONPLAYER1X, Settings.POSITIONPLAYER1Y, Color.RED);
        players[1] = new Player(Settings.POSITIONPLAYER2X, Settings.POSITIONPLAYER2Y, Color.BLUE);
        players[0].initBall();
        players[1].initBall();
    }

    private class MyTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
           doHandle();
        }

        public void doHandle() {


            gc.setFill( Color.GREEN);
            gc.fillRect(0,0, Settings.FRAMEWIDTH,Settings.FRAMEHEIGHT);

          //  gc.drawImage(player[0].getImage(),player[0].getPositionX(),player[0].getPositionY());
          //  gc.drawImage(player[1].getImage(),player[1].getPositionX(),player[1].getPositionY());

             //ball.setCenterX(10);
            //ball.setCenterY();

            checkCollisions();
        }
    }


    void checkCollisions() {
        //players[0].checkBorder();
       // players[1].checkBorder();
    }

    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {

            switch (event.getCode()) {
                case W: players[0].moveElementY(Settings.VECOLITYPLAYERY); break;
                case A: players[0].moveElementX(Settings.VECOLITYPLAYERY);break;
                case D: players[0].moveElementX(-Settings.VECOLITYPLAYERY);break;
                case S: players[0].moveElementY(-Settings.VECOLITYPLAYERY);break;
                case SPACE: break;

                case UP: players[1].moveElementY(Settings.VECOLITYPLAYERY);break;
                case LEFT: players[1].moveElementX(Settings.VECOLITYPLAYERX);break;
                case RIGHT: players[1].moveElementX(-Settings.VECOLITYPLAYERX);break;
                case DOWN: players[1].moveElementY(-Settings.VECOLITYPLAYERY);break;
                case P: break;
            }
        }
    };


    private EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {


              //  case W: testPlayers[0].moveElementY(-Settings.VECOLITYPLAYERY); break;
             //   case UP: testPlayers[1].moveElementY(-Settings.VECOLITYPLAYERY);break;
            }
        }
    };

    public static void main(String[] args) {
        launch(args);
    }
}
