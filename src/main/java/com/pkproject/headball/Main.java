package com.pkproject.headball;


import com.pkproject.headball.client.Client;
import com.pkproject.headball.collision.Collision;
import com.pkproject.headball.collision.CollisionImpl;
import com.pkproject.headball.objects.*;
import com.pkproject.headball.settings.Settings;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application  /*implements EventHandler <KeyEvent> */{
    private Score score;
    private AnimationTimer timer;
    private Canvas canvas;
    private Group root;
    private Ball ball;
    private GraphicsContext gc;
    private Player[] players;
    private Frame frame;
    private Collision collision;
    private GameCreator gameCreator;
    private boolean turnOnButtons = false;
    private Stage stage;
    public Client client;
    public StateGame stateGame;
    private Label scoreLabel;

    @Override
    public void start(Stage stage) {
        stateGame = new StateGame();
        System.out.println(stateGame);
        client = new Client(stateGame);
        if(client.connectWithServer()) {
            if(client.turnOnGame()) {
                System.out.println("czeck" + stateGame.isStartGame());
                while(!stateGame.isStartGame()){System.out.println("k");}
                this.stage = stage;
                createObject();

            }
        } else {
            System.out.println("error client");
        }
    }

    public void createObject() {
        gameCreator = new GameCreator();
        gameCreator = new GameCreator();
        ball = gameCreator.getBall();
        players = gameCreator.getPlayers();
        collision = new CollisionImpl();
        score = new Score();
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
        gc.setFill( Color.GREEN);
        gc.fillRect(0,0, Settings.FRAMEWIDTH,Settings.FRAMEHEIGHT);

        //add result
        scoreLabel = new Label();
        scoreLabel.setFont(new Font("Cambria", 50));
        root.getChildren().add(scoreLabel);
        //start game
        timer = new MyTimer();
        stage.show();
    }

    private class MyTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
           doHandle();
        }

        public void doHandle() {
            if (score.checkEndGame()) {
                gc.setFill(Color.GREEN);
                gc.fillRect(0, 0, Settings.FRAMEWIDTH, Settings.FRAMEHEIGHT);

                if(Ball.counterShoot < Settings.HITPOWERBALL) {
                    ball.moveBallXY(Settings.VECOLITYBALLX, Settings.VECOLITYBALLY);
                    Ball.counterShoot++;
                }

                if(collision.checkCollisionsBallWithPlayer(ball, players))
                    Ball.counterShoot = Settings.HITPOWERBALL;

                collision.checkCollisionsBallWithFrame(ball);

                if (collision.checkCollisionsBallWithGoal(ball)) {
                    System.out.println(players[0].playerShoot);
                    System.out.println(players[1].playerShoot);

                    if (players[0].getBall() != null) {
                        players[0].setBall(null);
                    }
                    if (players[1].getBall() != null) {
                        players[1].setBall(null);
                    }
                    gameCreator.restartGame(ball, players);


                    scoreLabel.setText("Score Player1 " + score.getResultPlayer1() + " : Player2 " + score.getResultPlayer2());
                    Ball.counterShoot = Settings.HITPOWERBALL;
                }
            } else {
               gameOverAlert();
            }

        }
    }


    public void gameOverAlert() {
        if(stateGame.isRunning()) {
            scoreLabel.setText("");
            Label label = new Label("Game over: " + score.whoWon());
            label.setFont(new Font("Cambria", 50));
            root.getChildren().add(label);
            turnOnButtons = false;
            stateGame.setRunning(false);
            client.exitGame();
        }

    }

    private void shoot(Player p) {
        if(p.playerShoot) {
            p.playerShoot = false;
        }
    }

    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {

            switch (event.getCode()) {
                //control one player
                case W:
                    if(turnOnButtons)players[0].moveElementY(-Settings.VECOLITYPLAYERY);
                break;
                case A: if(turnOnButtons) players[0].moveElementX(-Settings.VECOLITYPLAYERY);
                    break;
                case D: if(turnOnButtons) players[0].moveElementX(Settings.VECOLITYPLAYERY);
                    break;
                case S: if(turnOnButtons)players[0].moveElementY(Settings.VECOLITYPLAYERY);
                    break;
                case SPACE:
                    if(turnOnButtons) {
                        players[0].shoot();
                        shoot(players[0]);
                    }
                    break;
                 //control second player
                case UP: if(turnOnButtons)players[1].moveElementY(-Settings.VECOLITYPLAYERY);
                    break;
                case LEFT: if(turnOnButtons)players[1].moveElementX(-Settings.VECOLITYPLAYERX);
                    break;
                case RIGHT: if(turnOnButtons)players[1].moveElementX(Settings.VECOLITYPLAYERX);
                    break;
                case DOWN: if(turnOnButtons)players[1].moveElementY(Settings.VECOLITYPLAYERY);
                    break;
                case P:
                    if(turnOnButtons) {
                        players[1].shoot();
                        shoot(players[1]);
                        System.out.println(Ball.moveDirectionX + " " + Ball.moveDirectionY);
                    }
                    break;
                case ENTER:
                    if(stateGame.isStartGame()) {
                        timer.start();
                        turnOnButtons = true;
                        stateGame.setStartGame(false);
                        stateGame.setRunning(true);
                    }
                    else {
                        System.out.println("nie dziala");
                    }
                    break;
                case ESCAPE:
                    System.out.println("escape " + stateGame.isEndGame());
                    if(stateGame.isEndGame()) {
                        timer.stop();
                        Platform.exit();
                        client.closeConnectWithServer();
                    }
                    break;
            }
        }

    };

    private EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
               // case W: testPlayers[0].moveElementY(-Settings.VECOLITYPLAYERY); break;
               // case UP: testPlayers[1].moveElementY(-Settings.VECOLITYPLAYERY);break;
            }
        }
    };

    public static void main(String[] args) {
        launch(args);

    }
}
