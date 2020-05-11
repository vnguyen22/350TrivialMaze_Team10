package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
		//	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/MainWindow.fxml"));
			Scene scene = new Scene(root,800,800);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
