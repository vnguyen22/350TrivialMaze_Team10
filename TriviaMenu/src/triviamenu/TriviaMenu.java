/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviamenu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Gingervitis
 */
public class TriviaMenu extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = constructGrid();
        Scene scene = new Scene(root, root.getWidth(), root.getHeight());
        scene.setNodeOrientation(NodeOrientation.INHERIT);
        
        primaryStage.setTitle("Trivia Maze");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private Button constructButton(String text){
        Button butt = new Button();
        butt.setPrefWidth(400);
        butt.setPrefHeight(200);
        butt.setText(text);
        return butt;
    }
    
    private GridPane constructGrid(){
        GridPane root = new GridPane();
        Button newGameButton = constructButton("Start a new game");
        newGameButton.setOnAction(actionEvent -> onNew());
        root.add(newGameButton, 0, 0);
        Button loadGameButton = constructButton("Load a previous game");
        loadGameButton.setOnAction(actionEvent -> onLoad());
        root.add(loadGameButton, 0, 1);
        Button questButton = constructButton("Add your own question");
        questButton.setOnAction(actionEvent -> onQuest());
        root.add(questButton, 0, 2);
        Button quitButton = constructButton("Quit");
        quitButton.setOnAction(actionEvent -> onQuit());
        root.add(quitButton, 0, 3);
        return root;
    }
    
    
    private int onNew(){
        return 0;
    }
    
    private int onLoad(){
        return 0;
    }
    
    private int onQuest(){
        return 0;
    }
    
    private void onQuit(){
        Platform.exit();
    }
    
}
