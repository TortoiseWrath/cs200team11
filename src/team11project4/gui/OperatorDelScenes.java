/**
 * @author Hunter Allen
 */
package team11project4.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import team11project4.ChocAnDataCenter;
import team11project4.Member;
import team11project4.Provider;

public class OperatorDelScenes {

	public static Scene createDelScene(Scene oldScene) {
		
		Label instr = new Label("Select an option");
		
		Button delMem = new Button("Delete Member");
		Button delProv = new Button("Delete Provider");
		Button previous = new Button("Previous");
		Button userSelect = new Button(Interface.USER_SELECT);
		
		VBox.setMargin(delMem, new Insets(5, 0, 5, 0));
		VBox.setMargin(delProv, new Insets(5, 0, 5, 0));
		VBox.setMargin(previous, new Insets(5, 0, 5, 0));
		VBox.setMargin(userSelect, new Insets(5, 0, 5, 0));
		
		delMem.setOnAction(e -> Interface.setWindowScene(createDelMemScene(oldScene)));
		delProv.setOnAction(e -> Interface.setWindowScene(createDelProvScene(oldScene)));
		previous.setOnAction(e -> Interface.setWindowScene(UserScenes.createOperatorScene(oldScene)));
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(instr, delMem, delProv, previous, userSelect);
		
		return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
	}
	
	private static Scene createDelMemScene(Scene oldScene) {
		//Create ChocAnDataCenter to access and delete members
		ChocAnDataCenter db = new ChocAnDataCenter();
		
		//Create GridPane layout for member delete form
		GridPane root = new GridPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        
        //Create instruction label for informing user of what to do
        Label instr = new Label("Enter the number of the member to be deleted:");
        root.add(instr, 0, 0);
        
        //Create label and textfield for entering number of member to be deleted
        Label numberLabel = new Label("Member Number");
        root.add(numberLabel, 0, 1);
        TextField numberText = new TextField();
        root.add(numberText, 1, 1);
        
        //Create button for submitting number and deleting member
        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
        	//Get number string from input
        	String number = numberText.getText();
        	//Attempt to find member with that number
        	Member member= db.getMember(number);
        	//If member exists with the number: delete them, else alert user that member does not exist
        	if (member != null) {
        		db.deleteMember(member);
        		Alert success = new Alert(AlertType.INFORMATION);
        		success.setHeaderText("Delete Member Success");
        		success.setContentText("Successfully deleted member (number: " + number + ") from database.");
        		success.showAndWait();
        	} else {
        		Alert failure = new Alert(AlertType.ERROR);
        		failure.initModality(Modality.APPLICATION_MODAL);
        		failure.setHeaderText("Delete Member Failed");
        		failure.setContentText("Could not find member with number: " + number);
        		failure.showAndWait();
        	}
        });
        root.add(submit, 0, 2);
        
        //Create button for returning to previous scene
        Button previous = new Button(Interface.PREVIOUS);
        previous.setOnAction(e -> Interface.setWindowScene(createDelScene(oldScene)));
		
        //Create button for returning to user selection screen
		Button userSelect = new Button(Interface.USER_SELECT);
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		root.add(userSelect, 0, 3);
		
		return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
	}
	
	private static Scene createDelProvScene(Scene oldScene) {
		//Create ChocAnDataCenter to access and delete providers
		ChocAnDataCenter db = new ChocAnDataCenter();
		
		//Create GridPane layout for provider delete form
		GridPane root = new GridPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        
        //Create instruction label for informing user of what to do
        Label instr = new Label("Enter the number of the provider to be deleted:");
        root.add(instr, 0, 0);
        
        //Create label and textfield for entering number of provider to be deleted
        Label numberLabel = new Label("Provider Number");
        root.add(numberLabel, 0, 1);
        TextField numberText = new TextField();
        root.add(numberText, 1, 1);
        
        //Create button for submitting number and deleting provider
        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
        	//Get number string from input
        	String number = numberText.getText();
        	//Attempt to find provider with that number
        	Provider provider= db.getProvider(number);
        	//If provider exists with the number: delete them, else: alert user that member does not exist
        	if (provider != null) {
        		db.deleteProvider(provider);
        		Alert success = new Alert(AlertType.INFORMATION);
        		success.setHeaderText("Delete Provider Success");
        		success.setContentText("Successfully deleted provider (number: " + number + ") from database.");
        		success.showAndWait();
        	} else {
        		Alert failure = new Alert(AlertType.ERROR);
        		failure.initModality(Modality.APPLICATION_MODAL);
        		failure.setHeaderText("Delete Provider Failed");
        		failure.setContentText("Could not find provider with number: " + number);
        		failure.showAndWait();
        	}
        });
        root.add(submit, 0, 2);
        
        //Create button for returning to previous scene
        Button previous = new Button(Interface.PREVIOUS);
        previous.setOnAction(e -> Interface.setWindowScene(createDelScene(oldScene)));
        root.add(previous, 0, 3);
		
        //Create button for returning to user selection screen
		Button userSelect = new Button(Interface.USER_SELECT);
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		root.add(userSelect, 0, 4);
		
		return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
	}
	
}
