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
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Gingervitis
 */
public class TriviaMenu extends Application {
    
    private Stage mStage;
    private GridPane mMenuPane;
    private Scene mScene;
    
    @Override
    public void start(Stage primaryStage) {
        mMenuPane = constructGrid();
        mScene = new Scene(mMenuPane, mMenuPane.getWidth(), mMenuPane.getHeight());
        mScene.setNodeOrientation(NodeOrientation.INHERIT);
        
        mStage = primaryStage;
        mStage.setTitle("Trivia Maze");
        mStage.setScene(mScene);
        mStage.show();
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
        TextArea textArea = new TextArea();
        mScene = new Scene(textArea, 550, 500);
        mStage.setScene(mScene);
        mStage.show();
        Intro.runIntro(textArea);
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
