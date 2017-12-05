package team11project4.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import team11project4.Email;
import team11project4.SummaryReport;

public class ManagerScenes {

	public static void createSummaryReport() {
		//TODO: Set up summary report controller to create summary report
		SummaryReport report = new SummaryReport();
		Email emailReport = new Email("SummaryReport", null, report.report);
		emailReport.send();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Summary Report Generated");
		alert.setContentText("Summary Report added to summary reports folder");
		alert.showAndWait();
	}
}
