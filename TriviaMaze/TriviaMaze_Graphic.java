import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Gingervitis
 */
public class TriviaMaze_Graphic{
    
    private Stage mStage = new Stage();
    private Scene mScene;
    private DoorGraphic mDoor;
    private Maze mMaze;
    private Canvas mCanvas;
    private Label mLabel;
    private Direction mDirection = Direction.NONE;
    private int rowNum, colNum, playX, playY, entX, entY;
    private boolean mSaveNeeded;

    public TriviaMaze_Graphic(int row, int col, int px, int py, int ex, int ey){
        rowNum = row; colNum = col;
        playX = px; playY = py;
        entX = ex; entY = ey;
        mCanvas = new Canvas(col*30+10, row*30+10);
        mMaze = TriviaMazeMain.getMaze();
    }

    public void show() {
        BorderPane root = new BorderPane();
        mLabel = new Label("Direction: None");
        VBox vbox = new VBox(mCanvas, mLabel);
        root.setTop(buildMenuBar());
        root.setCenter(vbox);
        this.drawMaze();
        
        mScene = new Scene(root, colNum*30+30, rowNum*30+60);
        mScene.setOnKeyPressed(keyEvent -> onKeyPressed(keyEvent));
        
        mStage.setTitle("Trivia Maze");
        mStage.setScene(mScene);
        mStage.show();
    }
    
    public Stage getStage(){
        return mStage;
    }
    
    public Scene getScene(){
        return mScene;   
    }
    
    private MenuBar buildMenuBar(){
        MenuBar menu = new MenuBar();
        Menu fileMenu = new Menu("_File");
        MenuItem newMenuItem = new MenuItem("_New");
        newMenuItem.setOnAction(actionEvent -> onNew());
        newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N,
                KeyCombination.CONTROL_DOWN));
        fileMenu.getItems().add(newMenuItem);
        //File menu with an open item
        MenuItem openMenuItem = new MenuItem("_Open");
        openMenuItem.setOnAction(actionEvent -> onOpen());
        openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O,
                KeyCombination.CONTROL_DOWN));
        fileMenu.getItems().add(openMenuItem);
        menu.getMenus().addAll(fileMenu);
        return menu;
    }
    
    private void clearCanvas(){
        GraphicsContext gc = mCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, mCanvas.getWidth(), mCanvas.getHeight());
    }
    
    private void onNew(){
        TriviaMenu newMenu = TriviaMazeMain.getTriviaMenu();
        clearCanvas();
        newMenu.onStart();
        this.rowNum = newMenu.getRowNum();
        this.colNum = newMenu.getColNum();
        mCanvas.setWidth(colNum*30+10);
        mCanvas.setHeight(rowNum*30+10);
        mMaze = new Maze(rowNum, colNum);
        this.playX = mMaze.getEntranceX();
        this.playY = mMaze.getEntranceY();
        this.entX = mMaze.getExitX();
        this.entY = mMaze.getExitY();
        TriviaMaze_Graphic newScreen = TriviaMazeMain.getGraphic();
        TriviaMazeMain.setMaze(mMaze);
        newScreen.getStage().close();
        newScreen = this;
        newScreen.show();
        TriviaMazeMain.setGraphic(newScreen);
        MazeSettings newSettings = TriviaMazeMain.getSettings();
        newSettings.setRowNum(rowNum);
        newSettings.setColNum(colNum);
        newSettings.setPlayerPosX(playX);
        newSettings.setPlayerPosY(playY);
    }
    
    private void onOpen(){
        
    }
    
    public void onKeyPressed(KeyEvent keyEvent) {
        switch(keyEvent.getCode()){
            case UP:
                mLabel.setText("Direction: Up");
                mDirection = Direction.UP;
                break;
            case DOWN:
                mLabel.setText("Direction: Down");
                mDirection = Direction.DOWN;
                break;
            case LEFT:
                mLabel.setText("Direction: Left");
                mDirection = Direction.LEFT;
                break;
            case RIGHT:
                mLabel.setText("Direction: Right");
                mDirection = Direction.RIGHT;
                break;
            case SPACE:
                Door d;
                if (mDirection != Direction.NONE){
                    if (mDirection == Direction.UP){ d = mMaze.getPlayersRoom().getTopDoor(); }
                    else if (mDirection == Direction.DOWN){ d = mMaze.getPlayersRoom().getBottomDoor(); }
                    else if (mDirection == Direction.LEFT){ d = mMaze.getPlayersRoom().getLeftDoor(); }
                    else{ d = mMaze.getPlayersRoom().getRightDoor(); }
                    mDoor = new DoorGraphic(d);
                    mDoor.show();
                }
        }
    }
    
    private void drawMaze(){
        GraphicsContext gc = mCanvas.getGraphicsContext2D();
        gc.save();
        gc.setStroke(Color.RED);
        gc.strokeRect(0, 0, mCanvas.getWidth(), mCanvas.getHeight());
        gc.translate(5, 5);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2.0);
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++){
                gc.strokeLine(0, 0, 0, 30);
                gc.strokeLine(0, 0, 30, 0);
                gc.strokeLine(30, 0, 30, 30);
                gc.strokeLine(0, 30, 30, 30);
                gc.translate(30, 0);
            }//end j
            gc.translate(-(30*colNum), 30);
        }//end i
        gc.restore();
        gc.save();
        gc.translate(7.5,9.5);
        gc.drawImage(new Image("Avatar.jpg"), playY*30, playX*30, 25, 20);
        gc.restore();
        gc.save();
        gc.translate(6, 6);
        gc.drawImage(new Image("Exit.png"), entY*30, entX*30, 28, 28);
        gc.restore();
    }
    
    public void setLabel(String s){
        mLabel.setText(s);
    }
    
    private boolean checkIsInBounds(int addX, int addY){
        if ((playX+addX) >= rowNum || (playY+addY) >= colNum || (playX+addX) < 0 || (playY+addY) < 0){
            return false;
        }
        return true;
    }
}
