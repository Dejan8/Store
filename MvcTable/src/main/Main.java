/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author D
 */
public class Main extends Application {
    
    private double dragOffsetX;
    private double dragOffsetY;
    
     @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setTitle("FXML TableView Example");
       Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("/view/add_person.fxml"));
       Scene myScene = new Scene(myPane);
       myScene.getStylesheets().add("view/style.css");
       primaryStage.initStyle(StageStyle.UNDECORATED);
       primaryStage.setScene(myScene);
       primaryStage.show();
       
         myScene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dragOffsetX = event.getScreenX() - primaryStage.getX();
                dragOffsetY = event.getScreenY() - primaryStage.getY();
            }
        });
        myScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - dragOffsetX);
                primaryStage.setY(event.getScreenY() - dragOffsetY);
            }
        }
        );
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
}
