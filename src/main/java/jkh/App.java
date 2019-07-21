package jkh;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		var root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/pane.fxml"));
		var scene = new Scene(root, 1240, 720);
		
		stage.setScene(scene);
		
		stage.setTitle("ЖКХ");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(App.class, args);
	}
}
