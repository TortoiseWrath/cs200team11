package team11project4.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ManagerScenes {

	public static void createSummaryReport() {
		//TODO: Set up summary report controller to create summary report
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Summary Report Generated");
		alert.setContentText("Summary Report added to summary reports folder");
		alert.showAndWait();
	}
}
