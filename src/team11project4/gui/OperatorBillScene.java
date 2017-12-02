/**
 * Author: Hunter Allen (jhallen3@crimson.ua.edu)
 * 
 * Class Description: A class containing a function to create the scene for the operator billing action
 */

package team11project4.gui;

import java.util.Date;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import team11project4.BillForServicesController;

public class OperatorBillScene {

	public static Scene createBillScene(Scene oldScene) {
		
		//Creating GridPane layout for the scene
		GridPane root = new GridPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setHgap(10d);
		root.setVgap(10d);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		//Creating label and textfield for entering member number
		Label memNumLabel = new Label("Member Number:");
		root.add(memNumLabel, 0, 1);
		TextField memNumText = new TextField();
		root.add(memNumText, 1, 1);
		
		//Creating label and textfield for entering provider number
		Label provNumLabel = new Label("Provider Number:");
		root.add(provNumLabel, 0, 2);
		TextField provNumText = new TextField();
		root.add(provNumText, 1, 2);
		
		//Creating label and textfield for entering service code
		Label serviceLabel = new Label("Service Code:");
		root.add(serviceLabel, 0, 3);
		TextField serviceText = new TextField();
		root.add(serviceText, 1, 3);
		
		//Creating label and textfield for entering date of service provided
		Label dateLabel = new Label("Date Provided:");
		root.add(dateLabel, 0, 4);
		TextField dateText = new TextField();
		dateText.setPromptText("DD/MM/YYYY");
		root.add(dateText, 1, 4);
		
		//Creating label and textfield for entering optional comments
		Label comLabel = new Label("Comments:");
		root.add(comLabel, 0, 5);
		TextField comText = new TextField();
		comText.setPromptText("Optional");
		root.add(comText, 1, 5);
		
		//Creating button for user to submit their input
		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			String memNumber = memNumText.getText();
			String provNumber = provNumText.getText();
			String serviceCode = serviceText.getText();
			String dateString = dateText.getText();
			String comments = comText.getText();
			
			//If date is in correct format: try to write service
			if (dateString.contains("/")) {
				BillForServicesController bill = new BillForServicesController(provNumber);
				
				try {
					bill.setService(serviceCode);
				} catch (IllegalArgumentException a) {
					Alert serviceAlert = new Alert(AlertType.INFORMATION);
					serviceAlert.initModality(Modality.APPLICATION_MODAL);
					serviceAlert.setHeaderText("Incorrect service code");
					serviceAlert.setContentText("Service code entered does not exist.");
					serviceAlert.showAndWait();
				}
				
				String[] dateParts = dateString.split("/");
				int month = Integer.parseInt(dateParts[0]);
				int day = Integer.parseInt(dateParts[1]);
				int year = Integer.parseInt(dateParts[2]);
				//TODO: Possibly swap this out with different date object
				@SuppressWarnings("deprecation")
				Date date = new Date(year, month, day);
				
				bill.setMember(memNumber);
				bill.setDate(date);
				bill.setComments(comments);
			}
			else { //If date is not in correct format: inform the user
				Alert dateAlert = new Alert(AlertType.INFORMATION);
				dateAlert.initModality(Modality.APPLICATION_MODAL);
				dateAlert.setHeaderText("Incorrect date format");
				dateAlert.setContentText("Enter date in the format: MM/DD/YYYY");
				dateAlert.showAndWait();
			}	
		});
		root.add(submit, 1, 7);
		
		//Creating button for returning to user select scene
		Button previous = new Button(Interface.USER_SELECT);
	    previous.setOnAction(e -> Interface.setWindowScene(oldScene));
	    root.add(previous, 0, 9);
		
		return (new Scene(root, 600, 400));
		
	}
	
}
