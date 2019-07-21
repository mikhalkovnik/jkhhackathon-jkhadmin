package jkh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		var root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/pane.fxml"));
		var scene = new Scene(root, 1240, 720);
		
		stage.setScene(scene);
		
		stage.setMaximized(true);
		stage.setTitle("ЖКХ");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(App.class, args);
	}
}
