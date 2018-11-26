package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Main extends Application {

	Button button;
	ListView<String> listView;
	ObservableList<String> obsList;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			/**
			 * ObservableList<String> obsList = FXCollections.observableArrayList("A", "B",
			 * "C", "D"); ListView<String> listView = new ListView();
			 * listView.setItems(obsList); listView.setPrefWidth(100);
			 * listView.setPrefHeight(70);
			 */
			obsList = FXCollections.observableArrayList("A", "B", "C", "D");
			button = new Button("Click");
			listView = new ListView<String>();
			listView.setPrefWidth(100);
			listView.setPrefHeight(70);
			listView.getItems().addAll("A", "B", "C");
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			GridPane root = new GridPane();
			Scene scene = new Scene(root, 400, 400);
			root.getChildren().addAll(button, listView);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
