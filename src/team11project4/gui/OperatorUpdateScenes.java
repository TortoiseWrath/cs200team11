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

public class OperatorUpdateScenes {
	
	public static Scene createUpdateScene(Scene oldScene) {
		//Create buttons for updating members and providers
		Button updateMem = new Button("Update Members");
		Button updateProv = new Button("Update Providers");
		Button previous = new Button(Interface.PREVIOUS);
		Button userSelect = new Button(Interface.USER_SELECT);
		
		VBox.setMargin(updateMem, new Insets(5, 0, 5, 0));
		VBox.setMargin(updateProv, new Insets(5, 0, 5, 0));
		VBox.setMargin(previous, new Insets(5, 0, 5, 0));
		VBox.setMargin(userSelect, new Insets(5, 0, 5, 0));
		
		updateMem.setOnAction(e -> Interface.setWindowScene(pickMemScene(oldScene)));
		updateProv.setOnAction(e -> Interface.setWindowScene(pickProvScene(oldScene)));
		previous.setOnAction(e -> Interface.setWindowScene(UserScenes.createOperatorScene(oldScene)));
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(updateMem, updateProv, previous, userSelect);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
	}
	
	private static Scene pickMemScene(Scene oldScene) {
		GridPane root = new GridPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setHgap(10d);
		root.setVgap(10d);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		Label instr = new Label("Enter the number of the\nmember to be updated: ");
		root.add(instr, 0, 0);
		
		Label numberLabel = new Label("Member Number");
		root.add(numberLabel, 0, 1);
		TextField numberText = new TextField();
		root.add(numberText, 1, 1);
		
		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			ChocAnDataCenter db = new ChocAnDataCenter();
			String number = numberText.getText();
			Member member = db.getMember(number);
			if (member != null) {
				Interface.setWindowScene(updateMemScene(oldScene, member));
			} else {
				Alert failure = new Alert(AlertType.ERROR);
				failure.initModality(Modality.APPLICATION_MODAL);
				failure.setHeaderText("Update Member Failed");
				failure.setContentText("Failed to find member with that number.");
				failure.showAndWait();
			}
		});
		root.add(submit, 1, 2);
		
		Button previous = new Button(Interface.PREVIOUS);
		previous.setOnAction(e -> Interface.setWindowScene(createUpdateScene(oldScene)));
		root.add(previous, 0, 3);
		
		Button userSelect = new Button(Interface.USER_SELECT);
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		root.add(userSelect, 1, 3);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
	}
	
	private static Scene pickProvScene(Scene oldScene) {
		GridPane root = new GridPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setHgap(10d);
		root.setVgap(10d);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		Label instr = new Label("Enter the number of the\nprovider to be updated: ");
		root.add(instr, 0, 0);
		
		Label numberLabel = new Label("Provider Number");
		root.add(numberLabel, 0, 1);
		TextField numberText = new TextField();
		root.add(numberText, 1, 1);
		
		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			ChocAnDataCenter db = new ChocAnDataCenter();
			String number = numberText.getText();
			Provider provider = db.getProvider(number);
			if (provider != null) {
				Interface.setWindowScene(updateProvScene(oldScene, provider));
			} else {
				Alert failure = new Alert(AlertType.ERROR);
				failure.initModality(Modality.APPLICATION_MODAL);
				failure.setHeaderText("Update Provider Failed");
				failure.setContentText("Failed to find provider with that number.");
				failure.showAndWait();
			}
		});
		root.add(submit, 1, 2);
		
		Button previous = new Button(Interface.PREVIOUS);
		previous.setOnAction(e -> Interface.setWindowScene(createUpdateScene(oldScene)));
		root.add(previous, 0, 3);
		
		Button userSelect = new Button(Interface.USER_SELECT);
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		root.add(userSelect, 1, 3);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
	}
	
	private static Scene updateMemScene(Scene oldScene, Member m) {
		GridPane root = new GridPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setHgap(10d);
		root.setVgap(10d);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		Label numberLabel = new Label("Provider Number: ");
		root.add(numberLabel, 0, 1);
		Label number = new Label(m.memberNumber);
		root.add(number, 1, 1);
		
		Label nameLabel = new Label("Update Provider Name");
		root.add(nameLabel,  0, 2);
		TextField nameText = new TextField();
		nameText.setPromptText(m.memberName);
		root.add(nameText, 1, 2);
		
		Label addressLabel = new Label("Street Address:");
        root.add(addressLabel, 0, 3);
        TextField addressText = new TextField();
        addressText.setPromptText(m.memberAddress);
        root.add(addressText, 1, 3);
        
        Label cityLabel = new Label("City:");
        root.add(cityLabel, 0, 4);
        TextField cityText = new TextField();
        cityText.setPromptText(m.memberCity);
        root.add(cityText, 1, 4);
        
        Label stateLabel = new Label("State:");
        root.add(stateLabel, 0, 5);
        TextField stateText = new TextField();
        stateText.setPromptText(m.memberState);
        root.add(stateText, 1, 5);
        
        Label zipLabel = new Label("Zip code:");
        root.add(zipLabel, 0, 6);
        TextField zipText = new TextField();
        zipText.setPromptText(m.memberZip);
        root.add(zipText, 1, 6);
        
        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
        	//Create new member object for updating the member
        	Member updated = new Member();
        	ChocAnDataCenter db = new ChocAnDataCenter();
        	String name = nameText.getText();
        	String address = addressText.getText();
        	String city = cityText.getText();
        	String state = stateText.getText();
        	String zip = zipText.getText();
        	if (name.equals("")) {
        		updated.memberName = m.memberName;
        	} else {
        		updated.memberName = name;
        	}
        	if (address.equals("")) {
        		updated.memberAddress = m.memberAddress;
        	} else {
        		updated.memberAddress = address;
        	}
        	if (city.equals("")) {
        		updated.memberCity = m.memberCity;
        	} else {
        		updated.memberCity = city;
        	}
        	if (state.equals("")) {
        		updated.memberState = m.memberState;
        	} else {
        		updated.memberState = state;
        	}
        	if (zip.equals("")) {
        		updated.memberZip = m.memberZip;
        	} else  {
        		updated.memberZip = zip;
        	}
        	updated.memberNumber = m.memberNumber;
        	if (db.updateMember(m, updated)) {
        		Alert success = new Alert(AlertType.INFORMATION);
        		success.setHeaderText("Member Updated");
        		success.setContentText("Member information successfully updated.");
        		success.showAndWait();
        	} else {
        		Alert failure = new Alert(AlertType.ERROR);
        		failure.initModality(Modality.APPLICATION_MODAL);
        		failure.setHeaderText("Member Update Failed");
        		failure.setContentText("Error updating member information.");
        		failure.showAndWait();
        	}
        });
        root.add(submit, 1, 7);
		
		Button previous = new Button(Interface.PREVIOUS);
		previous.setOnAction(e -> Interface.setWindowScene(createUpdateScene(oldScene)));
		root.add(previous, 0, 8);
		
		Button userSelect = new Button(Interface.USER_SELECT);
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		root.add(userSelect, 1, 8);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
	}
	
	private static Scene updateProvScene(Scene oldScene, Provider p) {
		GridPane root = new GridPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setHgap(10d);
		root.setVgap(10d);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		Label numberLabel = new Label("Provider Number: ");
		root.add(numberLabel, 0, 1);
		Label number = new Label(p.providerNumber);
		root.add(number, 1, 1);
		
		Label nameLabel = new Label("Update Provider Name");
		root.add(nameLabel,  0, 2);
		TextField nameText = new TextField();
		nameText.setPromptText(p.providerName);
		root.add(nameText, 1, 2);
		
		Label addressLabel = new Label("Street Address:");
        root.add(addressLabel, 0, 3);
        TextField addressText = new TextField();
        addressText.setPromptText(p.providerAddress);
        root.add(addressText, 1, 3);
        
        Label cityLabel = new Label("City:");
        root.add(cityLabel, 0, 4);
        TextField cityText = new TextField();
        cityText.setPromptText(p.providerCity);
        root.add(cityText, 1, 4);
        
        Label stateLabel = new Label("State:");
        root.add(stateLabel, 0, 5);
        TextField stateText = new TextField();
        stateText.setPromptText(p.providerState);
        root.add(stateText, 1, 5);
        
        Label zipLabel = new Label("Zip code:");
        root.add(zipLabel, 0, 6);
        TextField zipText = new TextField();
        zipText.setPromptText(p.providerZip);
        root.add(zipText, 1, 6);
        
        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
        	//Create new provider object for updating the member
        	Provider updated = new Provider();
        	ChocAnDataCenter db = new ChocAnDataCenter();
        	String name = nameText.getText();
        	String address = addressText.getText();
        	String city = cityText.getText();
        	String state = stateText.getText();
        	String zip = zipText.getText();
        	if (name.equals("")) {
        		updated.providerName = p.providerName;
        	} else {
        		updated.providerName = name;
        	}
        	if (address.equals("")) {
        		updated.providerAddress = p.providerAddress;
        	} else {
        		updated.providerAddress = address;
        	}
        	if (city.equals("")) {
        		updated.providerCity = p.providerCity;
        	} else {
        		updated.providerCity = city;
        	}
        	if (state.equals("")) {
        		updated.providerState = p.providerState;
        	} else {
        		updated.providerState = state;
        	}
        	if (zip.equals("")) {
        		updated.providerZip = p.providerZip;
        	} else  {
        		updated.providerZip = zip;
        	}
        	updated.providerNumber = p.providerNumber;
        	if (db.updateProvider(p, updated)) {
        		Alert success = new Alert(AlertType.INFORMATION);
        		success.setHeaderText("Provider Updated");
        		success.setContentText("Provider information successfully updated.");
        		success.showAndWait();
        	} else {
        		Alert failure = new Alert(AlertType.ERROR);
        		failure.initModality(Modality.APPLICATION_MODAL);
        		failure.setHeaderText("Provider Update Failed");
        		failure.setContentText("Error updating provider information.");
        		failure.showAndWait();
        	}
        });
        root.add(submit, 1, 7);
		
		Button previous = new Button(Interface.PREVIOUS);
		previous.setOnAction(e -> Interface.setWindowScene(createUpdateScene(oldScene)));
		root.add(previous, 0, 8);
        
		Button userSelect = new Button(Interface.USER_SELECT);
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		root.add(userSelect, 1, 8);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
		
	}

}
