package com.pkproject.headball;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class Main extends Application  implements EventHandler <KeyEvent> {
    private Circle ball;
    private Player player;
    //Image image;
    static int i = 900;
    @Override
    public void start(Stage stage) {
        stage.setTitle("headball");
        initUI(stage);
    }

    private void initUI(Stage stage) {
        player = new Player();

        Group root = new Group();
        Scene scene = new Scene(root, 900,900);

        ball = new Circle();
        ball.setCenterX(50);
        ball.setCenterY(50);
        ball.setRadius(150);
        root.getChildren().add(ball);
        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);
        AnimationTimer timer = new MyTimer();
        timer.start();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event.getCode());
    }

    private class MyTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
           doHandle();
        }

        public void doHandle() {
            ball.setCenterX(i);
            ball.setCenterY(i);
        }
    }


    private EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            System.out.println(event.getCode());
        }
    };



    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            System.out.println(event.getCode());
        }
    };
}
