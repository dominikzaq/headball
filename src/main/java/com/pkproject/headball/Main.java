package com.pkproject.headball;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application  /*implements EventHandler <KeyEvent> */{
    private AnimationTimer timer;
    private Canvas canvas;
    private Group root;
    private Ball ball;
    private GraphicsContext gc;
    private Player[] players;
    private Frame frame;
    private Collision collision;
    private GameCreator gameCreator;

    @Override
    public void start(Stage stage) {
        gameCreator = new GameCreator();
        ball = gameCreator.getBall();
        players = gameCreator.getPlayers();
        collision = new CollisionImpl();
        stage.setTitle("football");
        initUI(stage);
    }

    private void initUI(Stage stage) {
        root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        canvas = new Canvas(Settings.FRAMEWIDTH, Settings.FRAMEHEIGHT);
        root.getChildren().add(canvas);

        root.getChildren().add(players[0].getPlayerBall());
        root.getChildren().add(players[1].getPlayerBall());
        root.getChildren().add(ball.getBall());


        frame = new Frame();
        root.getChildren().add(frame.getLine());
        root.getChildren().add(frame.getLeftGoal());
        root.getChildren().add(frame.getRightGoal());

        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);

        gc = canvas.getGraphicsContext2D();

        //start game
        timer = new MyTimer();
        timer.start();

        stage.show();
    }

    private class MyTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
           doHandle();
        }

        public void doHandle() {

            gc.setFill( Color.GREEN);
            gc.fillRect(0,0, Settings.FRAMEWIDTH,Settings.FRAMEHEIGHT);
            checkCollisions();

        }
    }

    void checkCollisions() {
        collision.checkCollisionsBallWithPlayer(ball, players);
        ball.getBall();
        players[0].getPlayerBall();
    }

    public void check() {
        for(Player p : players) {
            if(p.getBall() != null) {
               // p.setCenterX(p.getPlayerBall()[0]);
              //  p.setCenterY();
            }
        }
    }

    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {

            switch (event.getCode()) {
                //control one player
                case W:
                    players[0].moveElementY(-Settings.VECOLITYPLAYERY, ball);
                break;
                case A: players[0].moveElementX(-Settings.VECOLITYPLAYERY, ball);
                    break;
                case D: players[0].moveElementX(Settings.VECOLITYPLAYERY, ball);
                    break;
                case S: players[0].moveElementY(Settings.VECOLITYPLAYERY, ball);
                    break;
                case SPACE:
                    players[1].shoot();

                    break;
                 //control second player
                case UP: players[1].moveElementY(-Settings.VECOLITYPLAYERY, ball);
                    break;
                case LEFT: players[1].moveElementX(-Settings.VECOLITYPLAYERX, ball);
                    break;
                case RIGHT: players[1].moveElementX(Settings.VECOLITYPLAYERX, ball);
                    break;
                case DOWN: players[1].moveElementY(Settings.VECOLITYPLAYERY, ball);
                    break;
                case P:
                    players[1].shoot();
                    break;
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
