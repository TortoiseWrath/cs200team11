/**
 * Author: Hunter Allen (jhallen3@crimson.ua.edu)
 * Class Description: Contains functions to create the scenes for each member type.
 */

package team11project4.gui;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class UserScenes {
	
	public static Scene createMemberScene(Scene oldScene) {
		
		//TODO: Update the label to provide clear instructions
		Label instr = new Label("Select a member action:");
		
		//TODO: Add the buttons for each action available to members
		Button previous = new Button("Previous");
		previous.setOnAction(e -> Interface.window.setScene(oldScene));
		
		//TODO: Change this to a better looking layout
		VBox root = new VBox();
		root.getChildren().addAll(instr, previous);
		
		return (new Scene(root, 600, 400));
	}
	
	public static Scene createProviderScene(Scene oldScene) {
		
		//TODO: Update the label to provide clear instructions
		Label instr = new Label("Select a provider action:");
		
		//TODO: Add the buttons for each action available to providers
		Button previous = new Button("Previous");
		previous.setOnAction(e -> Interface.window.setScene(oldScene));
		
		//TODO: Change this to a better looking layout
		VBox root = new VBox();
		root.getChildren().addAll(instr, previous);
		
		return (new Scene(root, 600, 400));
	}
	
}
