package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {

	@FXML
	private Button bttnLogin, bttnSignUp;
	@FXML
	private TextField txt_Username, txt_Password;

	@FXML
	private HBox hBox;
	@FXML
	private Label lblStatus;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	public void onLogin_Click(ActionEvent event) {
		/*
		 * try {
		 * 
		 * if(loginModel.isLogin(txt_Username.getText(), txt_Password.getText())) {
		 * lblStatus.setText("correct"); } else { lblStatus.setText("incorrect"); }
		 * }catch(SQLException e) { lblStatus.setText("incorrect"); e.printStackTrace();
		 * }
		 */
	}

	@FXML
	public void onSaveGame_Click(ActionEvent event) {

		PlayerData data = new PlayerData();
		data.usernameField = txt_Username.getText();
		data.passwordField = txt_Password.getText();
		try {
			DataManager.savePlayer(data, "dataSaved.txt");

		} catch (Exception e) {
			System.out.println("Couldn't save: " + e.getMessage());
		}

		Alert alert = new Alert(Alert.AlertType.NONE, "Your game is saved", ButtonType.OK);
		alert.setTitle("Confirm Save Game");
		if (alert.showAndWait().orElse(ButtonType.OK) == ButtonType.OK) {
			alert.close();
		}

	}

	@FXML
	public void onLoadGame_Click(ActionEvent event) {

		try {
			PlayerData data = (PlayerData) DataManager.loadPlayer("dataSaved.txt");
			txt_Username.setText(data.usernameField);
			txt_Password.setText(data.passwordField);

			System.out.println(data.usernameField);
			System.out.println(data.passwordField);

		} catch (Exception e) {
			System.out.println("Couldn't load saved data: " + e.getMessage());
		}
	}

	@FXML
	public void onExit_Click(ActionEvent event) {
		
		Alert alert = new Alert(Alert.AlertType.NONE, "Would you like to quit the game?", ButtonType.YES,
				ButtonType.NO);
		alert.setTitle("Confirm Exit");
		if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
			Platform.exit();
			System.exit(0);
		} else {
			alert.close();
		}

	}
	@FXML
	public void onAbout_Click(ActionEvent event) {
		
		Alert alert = new Alert(Alert.AlertType.NONE, "CSCD350: TriviaMaze Project. \nSpring 2020 \n Team10: Van Nguyen,Corbin Smith, Graham Mix.", ButtonType.OK);
		alert.setTitle("About");
		if (alert.showAndWait().orElse(ButtonType.OK) == ButtonType.OK) {
			alert.close();
		} //end if

	}
	@FXML
	public void onRule_Click(ActionEvent event) {
		
		Alert alert = new Alert(Alert.AlertType.NONE, "-Must navigate through from entrance to exit. \n-Must correctly answer a question in order to pass through a door\n==========Enjoy the game==========", ButtonType.OK);
		alert.setTitle("Rules");
		if (alert.showAndWait().orElse(ButtonType.OK) == ButtonType.OK) {
			alert.close();
		}//end if

	}
	@FXML
	public void onNewGame_Click(ActionEvent event) throws IOException {
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/MainWindow.fxml"));
		Scene scene = new Scene(root, 800, 800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
