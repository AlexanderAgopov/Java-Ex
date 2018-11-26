package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class FxFXMLController1 {
	
	@FXML
    private MenuItem close;
	

    @FXML
    void close(ActionEvent event) {
    	Platform.exit();
    }

}
