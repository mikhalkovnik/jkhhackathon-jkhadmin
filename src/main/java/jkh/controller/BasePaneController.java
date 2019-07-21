package jkh.controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import jkh.domain.PreOrder;
import jkh.eventlistener.ValueEventListenerAdapter;

import java.util.List;

public class BasePaneController {
	
	@FXML
	private VBox preOrdersList;
	
	@FXML
	private VBox workersList;
	
	private DatabaseReference database;
	
	private List<PreOrder> preOrders;
	
	@FXML
	private void initialize() throws Exception {
		
		var options = FirebaseOptions
				.builder()
				.setCredentials(GoogleCredentials.getApplicationDefault())
				.setDatabaseUrl("https://jkhhakkaton.firebaseio.com/")
				.build();
		
		FirebaseApp.initializeApp(options);
		
		database = FirebaseDatabase
				.getInstance()
				.getReference();
		
		dumpPreOrders();
		dumpWorkers();
	}
	
	private void dumpPreOrders() {
		database.child("preorders")
		        .addValueEventListener((ValueEventListenerAdapter) preOrdersSnapshot -> {
			        System.out.println("preOrdersSnapshot = " + preOrdersSnapshot);
			        if (preOrdersSnapshot.exists()) {
				        for (var object : preOrdersSnapshot.getChildren()) {
					        System.out.println("object = " + object);
					        for (var preOrder : object.getChildren()) {
						        System.out.println("preOrder = " + preOrder);
						        
						        var userphone = preOrder.child("userphone").getValue(String.class);
						        var stage = preOrder.child("stage").getValue(String.class);
						        var status = preOrder.child("status").getValue(String.class);
						
						        var preOrderInfo = new VBox(new Label(userphone), new Label(stage), new Label(status));
						        preOrderInfo.setSpacing(10);
						        preOrderInfo.setPadding(new Insets(10));
						        Platform.runLater(() -> preOrdersList.getChildren().add(preOrderInfo));
					        }
				        }
			        }
		        });
	}
	
	private void dumpWorkers() {
		database.child("workers")
		        .addValueEventListener((ValueEventListenerAdapter) workersSnapshot -> {
		        	if (workersSnapshot.exists()) {
				        for (var worker : workersSnapshot.getChildren()) {
					        var name = worker.child("name").getValue(String.class);
					        var nowwork = worker.child("nowwork").getValue(String.class);
					        
					        var workerInfo = new VBox(new Label(name), new Label(nowwork));
					        workerInfo.setSpacing(10);
					        workerInfo.setPadding(new Insets(10));
					        Platform.runLater(() -> workersList.getChildren().add(workerInfo));
				        }
			        }
		        });
	}
}
