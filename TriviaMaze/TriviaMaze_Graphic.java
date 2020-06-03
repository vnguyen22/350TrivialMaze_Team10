import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private Canvas mCanvas;
    private Label mLabel;
    private int rowNum, colNum, playX, playY;

    public TriviaMaze_Graphic(int row, int col, int x, int y){
        this.rowNum = row;
        this.colNum = col;
        this.playX = x; 
        this.playY = y;
        mCanvas = new Canvas(col*30+10, row*30+10);
    }

    public void show() {
        BorderPane root = new BorderPane();
        mLabel = new Label("Direction: None");
        VBox vbox = new VBox(mCanvas, mLabel);
        root.setCenter(vbox);
        this.drawMaze(rowNum, colNum, playX, playY);
        
        mScene = new Scene(root, colNum*30+10, rowNum*30+60);
        
        mStage.setTitle("Trivia Maze");
        mStage.setScene(mScene);
        mStage.show();
    }
    
    public Scene getScene(){
        return mScene;   
    }
    
    private void drawMaze(int numRows, int numCols, int playX, int playY){
        GraphicsContext gc = mCanvas.getGraphicsContext2D();
        gc.save();
        gc.setStroke(Color.RED);
        gc.strokeRect(0, 0, mCanvas.getWidth(), mCanvas.getHeight());
        gc.translate(5, 5);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2.0);
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                gc.strokeLine(0, 0, 0, 30);
                gc.strokeLine(0, 0, 30, 0);
                gc.strokeLine(30, 0, 30, 30);
                gc.strokeLine(0, 30, 30, 30);
                gc.translate(30, 0);
            }//end j
            gc.translate(-(30*numCols), 30);
        }//end i
        gc.restore();
        gc.save();
        gc.translate(7.5,9.5);
        gc.drawImage(new Image("Avatar.jpg"), playY*30, playX*30, 25, 20);
        gc.restore();
        gc.save();
        gc.translate(6, 6);
        gc.drawImage(new Image("Exit.png"), 0, 0, 28, 28);
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
