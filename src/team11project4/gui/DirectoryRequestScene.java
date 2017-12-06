package team11project4.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import team11project4.Email;
import team11project4.ProviderDirectory;

public class DirectoryRequestScene {

	public static void providerDirectoryRequest() {
		ProviderDirectory directory = new ProviderDirectory();
		Email emailDirectory = new Email("ProviderDirectory", null, directory.directory);
		emailDirectory.send();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Directory Request Generated");
		alert.setContentText("Summary report added to reports folder");
		alert.showAndWait();
	}
}
