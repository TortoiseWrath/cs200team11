/**
 * Author: Hunter Allen (jhallen3@crimson.ua.edu)
 */

package team11project4.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import team11project4.Member;
import team11project4.Member.MemberStatus;
import team11project4.Provider;
import team11project4.tools.NumberGenerator;

public class OperatorAddScenes {

    public static Scene createAddScene(Scene oldScene) {
        
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        
        Button addMem = new Button("Add Member");
        Button addProv = new Button("Add Provider");
        Button returnBtn = new Button(Interface.USER_SELECT);
        
        addMem.setOnAction(e -> Interface.setWindowScene(createAddMemScene(oldScene)));
        addProv.setOnAction(e -> Interface.setWindowScene(createAddProvScene(oldScene)));
        
        root.getChildren().addAll(addMem, addProv, returnBtn);
        
        return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
    }
    
    private static Scene createAddMemScene(Scene oldScene) {
        
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
        	
        	Member member = new Member(name, address, city, state, zip, number, MemberStatus.ACTIVE);
        	
        	System.out.println(number);
        });
        root.add(enter, 0, 7);
        
        Button previous = new Button(Interface.USER_SELECT);
        previous.setOnAction(e -> Interface.setWindowScene(oldScene));
        root.add(previous, 1, 7);
        
        return (new Scene(root, 600, 400));
    }
    
    private static Scene createAddProvScene(Scene oldScene) {
    	
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
        	
        	Provider provider = new Provider(name, address, city, state, zip, number);
        });
        root.add(enter, 0, 7);
        
        Button previous = new Button(Interface.USER_SELECT);
        previous.setOnAction(e -> Interface.setWindowScene(oldScene));
        root.add(previous, 1, 7);
                
        return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
    }
    
}
