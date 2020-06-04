import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Gingervitis
 */
public class DoorGraphic {
    
    private Stage mStage = new Stage();
    private Scene mScene;
    private ImageView mImage = new ImageView("lock.png");
    private Label mLabel;
    private Door mDoor;
    
    public DoorGraphic(Door d){
        mDoor = d;
    }
    
    public void show(){
        BorderPane pane = new BorderPane();
        mLabel = new Label(mDoor.getQuestion());
        //mLabel.set
        mImage.setFitWidth(300);
        mImage.setFitHeight(300);
        VBox vbox = new VBox(mImage, mLabel);
        pane.setCenter(vbox);
        mScene = new Scene(pane, 300, 400);
        
        mStage.setScene(mScene);
        mStage.show();
    }
}
