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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;

/**
 *
 * @author Gingervitis
 */
public class TriviaMenu extends Application {

    BorderPane mPane;
    Stage mStage;
    Scene mScene;
    
    @Override
    public void start(Stage primaryStage) {
        mStage = primaryStage;
        mPane = new BorderPane();
        mScene = new Scene(mPane, 350, 250);

        mPane.setTop(buildMenuBar());

        Button newGame = createButton("Start a new game");
        newGame.setOnAction(event -> onStart());
        Button loadGame = createButton("Load a previous game");
        Button custQuest = createButton("Add custom questions");
        Button exit = createButton("Exit the game");
        VBox vbox = new VBox(newGame, loadGame, custQuest, exit);
        mPane.setCenter(vbox);
        
        mStage.setTitle("Trivia Maze");
        mStage.setScene(mScene);
        mStage.setResizable(false);
        mStage.show();
    }

    private void onStart(){
        Alert mazeOptions = new Alert(AlertType.INFORMATION);
        mazeOptions.setTitle("Maze Options");
        mazeOptions.setHeaderText("Please select the number of\nrows and columns for the maze");
        Label l1 = new Label("Rows: ");
        ChoiceBox<Integer>  rows = new ChoiceBox();
        rows.getItems().addAll(2,3,4,5,6,7,8,9,10);
        Label l2 = new Label("Columns: ");
        ChoiceBox<Integer> cols = new ChoiceBox();
        cols.getItems().addAll(2,3,4,5,6,7,8,9,10);
        HBox hbox1 = new HBox(l1, rows);
        hbox1.setSpacing(10.0);
        HBox hbox2 = new HBox(l2, cols);
        hbox2.setSpacing(10.0);
        VBox vbox = new VBox(hbox1, hbox2);
        mazeOptions.getDialogPane().setContent(vbox);
        mazeOptions.setWidth(25);
        mazeOptions.showAndWait();
    }

    private Button createButton(String text){
        Button butt = new Button();
        butt.setText(text);
        butt.setPrefSize(mScene.getWidth(), mScene.getHeight()/4);
        return butt;
    }

    private MenuBar buildMenuBar(){
        MenuBar menubar = new MenuBar();
        Menu fileMenu = new Menu("_File");
        MenuItem quitMenuItem = new MenuItem("_Quit");
        quitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Q,
                KeyCombination.CONTROL_DOWN));
        quitMenuItem.setOnAction(actionEvent -> Platform.exit());
        fileMenu.getItems().add(quitMenuItem);
        Menu helpMenu = new Menu("_Help");
        MenuItem aboutMenuItem = new MenuItem("_About");
        aboutMenuItem.setOnAction(actionEvent -> onAbout());
        helpMenu.getItems().add(aboutMenuItem);
        menubar.getMenus().addAll(fileMenu, helpMenu);
        return menubar;
    }

    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Trivia Maze\nTeam 10: Graham Mix, Van Nguyen, Corbin Smith");
        alert.showAndWait();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
