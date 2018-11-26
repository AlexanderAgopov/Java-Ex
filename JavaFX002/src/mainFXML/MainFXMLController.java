package mainFXML;

import java.awt.event.KeyEvent;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class MainFXMLController {

	@FXML
	private Pane paneDraw;
	
	 @FXML
	private Canvas canvas;
	
	@FXML
    private Circle circle;

	@FXML
	private Button addButton;

	@FXML
	private Button clearButton;

	@FXML
	private MenuItem closeWindow;
	
	@FXML
    private ListView<String> list;

	@FXML
	void add(ActionEvent event) {
		double x = circle.getCenterX();
		circle.setCenterX(x - 20);
	}

	@FXML
	void clear(ActionEvent event) {
		double x = circle.getCenterX();
		circle.setCenterX(x + 20);
	}

	@FXML
	void closeWindow(ActionEvent event) {

		Platform.exit();

	}
	
	

}
