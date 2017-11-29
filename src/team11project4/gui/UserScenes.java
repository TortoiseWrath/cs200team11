/**
 * Author: Hunter Allen (jhallen3@crimson.ua.edu)
 * Class Description: Contains functions to create the scenes for each member type.
 */

package team11project4.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class UserScenes {
	
	/**
	 * Returns a new scene for selecting from the actions that are available to the member users.
	 * 
	 * @param oldScene	The scene from which this function is being called
	 * @return			A new scene for displaying member options
	 */
	public static Scene createMemberScene(Scene oldScene) {
		
		//TODO: Update the label to provide clear instructions
		Label instr = new Label("Select a member action:");
		
		//TODO: Add the buttons for each action available to members
		Button previous = new Button("User Select");
		//Adding an event listener to the button to return to the previous scene
		previous.setOnAction(e -> Interface.window.setScene(oldScene));
		
		//TODO: Change this to a better looking layout
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(instr, previous);
		
		return (new Scene(root, 600, 400));
	}
	
	/**
	 * Returns a new scene for selecting from the actions available to provider users
	 * 
	 * @param oldScene	The current scene from which this function is being called
	 * @return			A new scene for displaying provider options
	 */
	public static Scene createProviderScene(Scene oldScene) {
		
		//TODO: Update the label to provide clear instructions
		Label instr = new Label("Select a provider action:");
		
		//TODO: Add the buttons for each action available to providers
		Button previous = new Button("User Select");
		previous.setOnAction(e -> Interface.window.setScene(oldScene));
		
		//TODO: Change this to a better looking layout
		VBox root = new VBox();
		root.getChildren().addAll(instr, previous);
		root.setAlignment(Pos.BASELINE_CENTER);
		return (new Scene(root, 600, 400));
	}
	
	/**
	 * Returns a new scene for selecting from the actions available to manager users
	 * 
	 * @param oldScene	The current scene from which this function is being called
	 * @return			A new scene for displaying manager options
	 */
	public static Scene createManagerScene(Scene oldScene) {
		
		//TODO: Update the label to provide clear instructions
		Label instr = new Label("Select a manager action:");
		
		//TODO: Add the buttons for each action available to managers
		Button previous = new Button("User Select");
		previous.setOnAction(e -> Interface.window.setScene(oldScene));
		
		//TODO: Change this to a better looking layout
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(instr, previous);
		
		return (new Scene(root, 600, 400));
		
	}
	
	/**
	 * Returns a new scene for selecting from the actions available to operator users
	 * 
	 * @param oldScene	The current scene from which this function is being called
	 * @return			A new scene for displaying operator Options
	 */
	public static Scene createOperatorScene(Scene oldScene) {
		
		//TODO: Update the label to provide clear instructions
		Label instr = new Label("Select an operator action:");
		
		//TODO: Add the buttons for each action available to operators
		Button previous = new Button("User Select");
		previous.setOnAction(e -> Interface.window.setScene(oldScene));
		
		//TODO: Change this to a better looking layout
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(instr, previous);
		
		return (new Scene(root, 600, 400));
	}
	
}
