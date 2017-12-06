/**
 * @author Hunter Allen
 * Class Description: A class to initialize a graphical user interface for the project
 */

package team11project4.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
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
	protected static final int HEIGHT = 650;
	protected static final int WIDTH = 450;
	
	protected static final String USER_SELECT = "User Select";
	protected static final String PREVIOUS = "Previous";
	
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
		Button opBtn = new Button("Operator(Interactive Mode)");
		
		//Setting the margin on the buttons so there is space in between them
		VBox.setMargin(provBtn, new Insets(5, 5, 5, 5));
		VBox.setMargin(manBtn, new Insets(5, 5, 5, 5));
		VBox.setMargin(opBtn, new Insets(5, 5, 5, 5));
		
		//Adding event listeners for actions to be taken when clicking a button
		provBtn.setOnAction(e -> window.setScene(UserScenes.createProviderScene(scene)));
		manBtn.setOnAction(e -> window.setScene(UserScenes.createManagerScene(scene)));
		opBtn.setOnAction(e -> window.setScene(UserScenes.createOperatorScene(scene)));
		
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(instr, provBtn, manBtn, opBtn);
		
		scene = new Scene(root, HEIGHT, WIDTH);
		
		window.setScene(scene);
		window.show();
		
	}
	
	/**
	 * Properly closes the program and can perform any necessay final steps before shutdown
	 */
	private void exitProgram() {
		Platform.exit();
	}
	
	/**
	 * Sets the scene that is displayed in the window.
	 * 
	 * @param scene	The scene to be set as currently displayed
	 */
	public static void setWindowScene(Scene scene) {
		window.setScene(scene);
	}
	
}
