package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class SplashScreenFormController {

    public Label lblStatus;

    public void initialize(){
        Timeline timeline = new Timeline();
        var k1 = new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("Loading...!");
            }
        });
        var k2 = new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("Please wait..");
            }
        });
        var k3 = new KeyFrame(Duration.millis(1300), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("Creating interface");
            }
        });
        var k4 = new KeyFrame(Duration.millis(1800), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    URL resource = this.getClass().getResource("/view/TextEditorForm.fxml");
                    Parent container = FXMLLoader.load(resource);
                    Scene editorScene = new Scene(container);
                    Stage primaryStage = new Stage();
                    primaryStage.setScene(editorScene);
                    primaryStage.setTitle("DEP-9 Text Editor");
                    primaryStage.show();
                    primaryStage.centerOnScreen();
                    lblStatus.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        timeline.getKeyFrames().addAll(k1, k2, k3, k4);
        timeline.playFromStart();
    }
}
