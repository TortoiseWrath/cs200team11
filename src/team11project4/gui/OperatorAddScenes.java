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
import team11project4.Member.MemberStatus;
import team11project4.Provider;
import team11project4.tools.NumberGenerator;

public class OperatorAddScenes {

	/**
	 * Creates the scene for allowing the user to add members or providers.
	 * 
	 * @param oldScene	The initial scene created. Allows returning to user select.
	 * @return	The option scene of selecting adding members or providers
	 */
    public static Scene createAddScene(Scene oldScene) {
        
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        
        Button addMem = new Button("Add Member");
        Button addProv = new Button("Add Provider");
        Button previous = new Button("Previous");
        Button userSelect = new Button(Interface.USER_SELECT);
        
        VBox.setMargin(addMem, new Insets(5, 0, 5, 0));
        VBox.setMargin(addProv, new Insets(5, 0, 5, 0));
        VBox.setMargin(previous, new Insets(5, 0, 5, 0));
        VBox.setMargin(userSelect, new Insets(5, 0, 5, 0));
        
        addMem.setOnAction(e -> Interface.setWindowScene(createAddMemScene(oldScene)));
        addProv.setOnAction(e -> Interface.setWindowScene(createAddProvScene(oldScene)));
        previous.setOnAction(e -> Interface.setWindowScene(UserScenes.createOperatorScene(oldScene)));
        userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
        
        root.getChildren().addAll(addMem, addProv, previous, userSelect);
        
        return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
    }
    
    /**
     * Creates scene with form for adding new members to the database.
     * 
     * @param oldScene	The initial scene created. Allows returning to user select.
     * @return			The scene for adding members to the database
     */
    private static Scene createAddMemScene(Scene oldScene) {
    	ChocAnDataCenter db = new ChocAnDataCenter();
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        
        Label nameLabel = new Label("Name:");
        root.add(nameLabel, 0, 1);
        TextField nameText = new TextField();
        root.add(nameText, 1, 1);
        
        Label addressLabel = new Label("Street Address:");
        root.add(addressLabel, 0, 2);
        TextField addressText = new TextField();
        root.add(addressText, 1, 2);
        
        Label cityLabel = new Label("City:");
        root.add(cityLabel, 0, 3);
        TextField cityText = new TextField();
        root.add(cityText, 1, 3);
        
        Label stateLabel = new Label("State:");
        root.add(stateLabel, 0, 4);
        TextField stateText = new TextField();
        root.add(stateText, 1, 4);
        
        Label zipLabel = new Label("Zip code:");
        root.add(zipLabel, 0, 5);
        TextField zipText = new TextField();
        root.add(zipText, 1, 5);
        
        Button enter = new Button("Confirm");
        enter.setOnAction(e -> {
        	String name = nameText.getText();
        	String address = addressText.getText();
        	String city = cityText.getText();
        	String state = stateText.getText();
        	String zip = zipText.getText();
        	String number = NumberGenerator.generateNumber();
        	//Check if number is already in use for a member. If so, generate new number until one is not in use.
        	for (Member m : db.getMemberData()) {
        		if (number.equals(m.memberNumber)) {
        			number = NumberGenerator.generateNumber();
        		}
        	}
        	/*
        	 * Create member object and attempt to add it to the database.
        	 * Alert the user if it succeeds or fails.
        	 */
        	Member member = new Member(number, name, address, city, state, zip, MemberStatus.ACTIVE);
        	if (db.addMember(member)) {
        		Alert success = new Alert(AlertType.INFORMATION);
        		success.setHeaderText("Member Added");
        		success.setContentText("Successfully added member with number: " + number);
        		success.showAndWait();
        	} else  {
        		Alert failure = new Alert(AlertType.ERROR);
        		failure.initModality(Modality.APPLICATION_MODAL);
        		failure.setHeaderText("Adding Member Failed");
        		failure.setContentText("Failed to add member.\nPlease check information and try again.");
        		failure.showAndWait();
        	}
        	
        	
        });
        root.add(enter, 0, 7);
        
        //Create button for returning to previous scene
        Button previous = new Button(Interface.PREVIOUS);
        previous.setOnAction(e -> Interface.setWindowScene(createAddScene(oldScene)));
        root.add(previous, 0, 8);
        
        //Create button for returning to user select scene
        Button userSelect = new Button(Interface.USER_SELECT);
        userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
        root.add(userSelect, 1, 8);
        
        return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
    }
    
    /**
     * Creating scene for allowing operators to add providers to the database
     * 
     * @param oldScene	The initial scene created. Allows returning to user select.
     * @return			Scene for adding providers to the database
     */
    private static Scene createAddProvScene(Scene oldScene) {
    	//Create ChocAnDataCenter object for accessing provider data and adding new providers to database
    	ChocAnDataCenter db = new ChocAnDataCenter();
    	
    	//Create GridPane layout for add provider form
        GridPane root = new GridPane();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        
        //Creating all of the labels and textfields for needed provider data
        
        Label nameLabel = new Label("Name:");
        root.add(nameLabel, 0, 1);
        TextField nameText = new TextField();
        root.add(nameText, 1, 1);
        
        Label addressLabel = new Label("Street Address:");
        root.add(addressLabel, 0, 2);
        TextField addressText = new TextField();
        root.add(addressText, 1, 2);
        
        Label cityLabel = new Label("City:");
        root.add(cityLabel, 0, 3);
        TextField cityText = new TextField();
        root.add(cityText, 1, 3);
        
        Label stateLabel = new Label("State:");
        root.add(stateLabel, 0, 4);
        TextField stateText = new TextField();
        root.add(stateText, 1, 4);
        
        Label zipLabel = new Label("Zip code:");
        root.add(zipLabel, 0, 5);
        TextField zipText = new TextField();
        root.add(zipText, 1, 5);
        
        //Create button for submitting data to the system
        Button enter = new Button("Confirm");
        enter.setOnAction(e -> {
        	String name = nameText.getText();
        	String address = addressText.getText();
        	String city = cityText.getText();
        	String state = stateText.getText();
        	String zip = zipText.getText();
        	String number = NumberGenerator.generateNumber();
        	//Check if number generated is already in use. If so, generate new numbers until one is not in use
        	for (Provider p : db.getProviderData()) {
        		if (number.equals(p.providerNumber)) {
        			number = NumberGenerator.generateNumber();
        		}
        	}
        	/*
        	 * Create provider object and attempt to add it to the database.
        	 * Alert the user if it succeeds or if it fails.
        	 */
        	Provider provider = new Provider(number, name, address, city, state, zip);
        	if (db.addProvider(provider)) {
        		Alert success = new Alert(AlertType.INFORMATION);
        		success.setHeaderText("Provider Added");
        		success.setContentText("Provider created with number: " + number);
        		success.showAndWait();
        	} else {
        		Alert failure = new Alert(AlertType.INFORMATION);
        		failure.initModality(Modality.APPLICATION_MODAL);
        		failure.setHeaderText("Adding Provider Failed");
        		failure.setContentText("Failed to add provider.\nPlease check information and try again.");
        		failure.showAndWait();
        	}
        });
        root.add(enter, 0, 7);
        
        //Create button for returning to previous scene
        Button previous = new Button(Interface.PREVIOUS);
        previous.setOnAction(e -> Interface.setWindowScene(createAddScene(oldScene)));
        root.add(previous, 0, 8);
        
        //Create button for returning to the user select screen
        Button userSelect = new Button(Interface.USER_SELECT);
        userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
        root.add(userSelect, 1, 8);
                
        return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
    }
    
}
