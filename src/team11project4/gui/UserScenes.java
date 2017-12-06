/**
 * Author: Hunter Allen (jhallen3@crimson.ua.edu)
 * Class Description: Contains functions to create the scenes for each member type.
 */

package team11project4.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class UserScenes {
	
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
		Button previous = new Button(Interface.USER_SELECT);
		Button bill = new Button("Bill for Services");
		Button directory = new Button("Directory Request");
		
		VBox.setMargin(previous, new Insets(5, 0, 5, 0));
		VBox.setMargin(bill, new Insets(5, 0, 5, 0));
		VBox.setMargin(directory, new Insets(5, 0, 5, 0));
		
		previous.setOnAction(e -> Interface.setWindowScene(oldScene));
		bill.setOnAction(e -> Interface.setWindowScene(OperatorBillScene.createBillScene(oldScene)));
		directory.setOnAction(e -> DirectoryRequestScene.providerDirectoryRequest());
		
		//TODO: Change this to a better looking layout
		VBox root = new VBox();
		root.getChildren().addAll(instr, bill, directory, previous);
		root.setAlignment(Pos.BASELINE_CENTER);
		return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
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
		Button summary = new Button("Summary Report");
		Button previous = new Button(Interface.USER_SELECT);
		
		//Setting margins on buttons' top and bottom
		VBox.setMargin(summary, new Insets(5, 0, 5, 0));
		VBox.setMargin(previous, new Insets(5, 0, 5, 0));
		
		summary.setOnAction(e -> ManagerScenes.createSummaryReport());
		previous.setOnAction(e -> Interface.setWindowScene(oldScene));
		
		//TODO: Change this to a better looking layout
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(instr, summary, previous);
		
		return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
		
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
		Button add = new Button("Add");
		Button del = new Button("Delete");
		Button map = new Button("Run Main Accouting Procedure");
		Button previous = new Button(Interface.USER_SELECT);
		
		//Setting margins on buttons top and bottom
		VBox.setMargin(previous, new Insets(5, 0, 5, 0));
		VBox.setMargin(add, new Insets(5, 0, 5, 0));
		VBox.setMargin(del, new Insets(5, 0, 5, 0));
		VBox.setMargin(map, new Insets(5, 0, 5, 0));
		
		add.setOnAction(e -> Interface.setWindowScene(OperatorAddScenes.createAddScene(oldScene)));
		del.setOnAction(e -> Interface.setWindowScene(OperatorDelScenes.createDelScene(oldScene)));
		map.setOnAction(e -> MainAccountingScene.runMainAccountingProcedure());
		previous.setOnAction(e -> Interface.setWindowScene(oldScene));
		
		//TODO: Change this to a better looking layout
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(instr, add, del, map, previous);
		
		return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
	}
	
}
