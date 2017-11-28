/**
 * Author: Hunter Allen (jhallen3@crimson.ua.edu)
 * Class Description: A class to initialize a graphical user interface for the project
 */

package team11project4.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application{
	
	protected static Stage window;
	private Scene scene;
	
	/**
	 * The launch() function is the only thing needed in main().
	 * All program logic will be handled with event handlers.
	 */
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		window = arg0;
		window.setTitle("Chocohalics Anonymous");
		
		Label instr = new Label("Select your user type:");
		
		Button memBtn = new Button("Member");
		Button provBtn = new Button("Provider");
		Button manBtn = new Button("Manager");
		Button opBtn = new Button("Operator");
		
		memBtn.setOnAction(e -> window.setScene(UserScenes.createMemberScene(scene)));
		provBtn.setOnAction(e -> window.setScene(UserScenes.createProviderScene(scene)));
		
		VBox root = new VBox();
		root.getChildren().addAll(instr, memBtn, provBtn, manBtn, opBtn);
		
		scene = new Scene(root, 600, 400);
		
		window.setScene(scene);
		
		window.show();
		
	}
	
}
