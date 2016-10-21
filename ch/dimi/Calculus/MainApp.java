package ch.dimi.Calculus;

import java.io.IOException;

import ch.dimi.Calculus.view.OverviewController;
import ch.dimi.Calculus.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Calculus Solver");
		
		initRootLayout();
		showOverview();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch (IOException e) {
			
		}
	}
	
	public void showOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Overview.fxml"));
			AnchorPane overview = (AnchorPane) loader.load();
			
			rootLayout.setCenter(overview);
		} catch (IOException e) {
			
		}
	}
	
	/*
	private void showGraphInNewWindow() {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/GraphView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage graphStage = new Stage();
			graphStage.setTitle("Graph");
			graphStage.initModality(Modality.WINDOW_MODAL);
			graphStage.initOwner(primaryStage);
			
			Scene scene = new Scene(page);
			graphStage.setScene(scene);
			graphStage.show();			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	*/
	
	public static void main(String[] args) {
		launch(args);
	}
}
