import java.io.File;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
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

/**
 *
 * @author Gingervitis
 */
public class TriviaMenu {

    private BorderPane mPane;
    private Stage mStage;
    private Scene mScene;
    private boolean needsToShow = true;
    private int rowNum = 2, colNum = 2;

    public TriviaMenu(){}

    public boolean needsToShow(){
        return needsToShow;
    }

    public int getRowNum(){
        return rowNum;
    }

    public int getColNum(){
        return colNum;
    }
    
    public void show() {
        mStage = new Stage();
        mPane = new BorderPane();
        mScene = new Scene(mPane, 350, 250);

        mPane.setTop(buildMenuBar());

        Button newGame = createButton("Start a new game");
        newGame.setOnAction(event -> onStart());
        Button loadGame = createButton("Load a previous game");
        loadGame.setOnAction(event -> onLoad());
        Button custQuest = createButton("Add custom questions");
        Button exit = createButton("Exit the game");
        VBox vbox = new VBox(newGame, loadGame, custQuest, exit);
        mPane.setCenter(vbox);
        
        mStage.setTitle("Trivia Maze");
        mStage.setScene(mScene);
        mStage.setResizable(false);
        mStage.showAndWait();
    }

    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Trivia Maze\nTeam 10: Graham Mix, Van Nguyen, Corbin Smith");
        alert.showAndWait();
    }

    private void onStart(){
        Alert mazeOptions = new Alert(AlertType.INFORMATION);
        mazeOptions.setTitle("Maze Options");
        mazeOptions.setHeaderText("Please select the number of\nrows and columns for the maze");
        Label l1 = new Label("Rows: ");
        ChoiceBox<Integer>  rows = new ChoiceBox<Integer>();
        rows.getItems().addAll(2,3,4,5,6,7,8,9,10);
        rows.setValue(10);
        Label l2 = new Label("Columns: ");
        ChoiceBox<Integer> cols = new ChoiceBox<Integer>();
        cols.getItems().addAll(2,3,4,5,6,7,8,9,10);
        cols.setValue(10);
        HBox hbox1 = new HBox(l1, rows);
        hbox1.setSpacing(31.0);
        HBox hbox2 = new HBox(l2, cols);
        hbox2.setSpacing(10.0);
        VBox vbox = new VBox(hbox1, hbox2);
        mazeOptions.getDialogPane().setContent(vbox);
        mazeOptions.setWidth(25);
        mazeOptions.showAndWait();
        rowNum = rows.getValue(); 
        colNum = cols.getValue();
        needsToShow = false;
        mStage.close();
    }

    private void onLoad(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a file");
        File selectedFile = fileChooser.showOpenDialog(mStage);
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
}
