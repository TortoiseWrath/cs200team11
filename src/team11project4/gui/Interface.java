/**
 * Author: Hunter Allen (jhallen3@crimson.ua.edu)
 * Class Description: A class to initialize a graphical user interface for the project
 */

package team11project4.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application{
	
	private static Stage window;
	private Scene scene;
	
	//Using these values for all scene declarations will keep the size of the GUI consistent
	protected static final int HEIGHT = 600;
	protected static final int WIDTH = 400;
	
	protected static final String USER_SELECT = "User Select";
	
	/**
	 * The launch() function is needed to start the interface window.
	 * Any initialization needed needs to be done before launch() is called.
	 */
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		window = arg0;
		window.setTitle("Chocoholics Anonymous");
		window.setOnCloseRequest(e -> exitProgram());
		
		Label instr = new Label("Select your user type:");
		
		//Declaring buttons for selecting user type
		Button provBtn = new Button("Provider");
		Button manBtn = new Button("Manager");
		Button opBtn = new Button("Operator");
		
		//Adding event listeners for actions to be taken when clicking a button
		provBtn.setOnAction(e -> window.setScene(UserScenes.createProviderScene(scene)));
		manBtn.setOnAction(e -> window.setScene(UserScenes.createManagerScene(scene)));
		opBtn.setOnAction(e -> window.setScene(UserScenes.createOperatorScene(scene)));
		
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(instr, /*memBtn,*/ provBtn, manBtn, opBtn);
		
		scene = new Scene(root, HEIGHT, WIDTH);
		
		window.setScene(scene);
		window.show();
		
	}
	
	private void exitProgram() {
		//Any tasks that need to be done before the program is closed needs to be put here
		//For example, final writes/updates to the database should go hear
		
		//Debug print statement
		System.out.println("Program is closing...");
		
		Platform.exit();
	}
	
	public static void setWindowScene(Scene scene) {
		window.setScene(scene);
	}
	
}
