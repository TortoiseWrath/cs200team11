/**
 * @author Hunter Allen
 */
package team11project4.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import team11project4.MainAccountingProcedureController;

public class MainAccountingScene {

	/**
	 * Creates MainAccountingProcedureControllerObject and runs the procedure.
	 * Alerts the user that the procedure has run.
	 */
	public static void runMainAccountingProcedure() {
		MainAccountingProcedureController mapController = new MainAccountingProcedureController();
		mapController.runProcedure();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Main Accounting Procedure Ran");
		alert.setContentText("Main accounting procedure ran. Files have been saved.");
		alert.showAndWait();
	}
	
}
