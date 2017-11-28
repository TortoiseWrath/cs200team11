package team11project4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application{
	
	Stage window = new Stage();
	
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
		
		VBox root = new VBox();
		root.getChildren().addAll(instr, memBtn, provBtn, manBtn, opBtn);
		
		Scene userSelect = new Scene(root, 600, 400);
		
		window.setScene(userSelect);
		
		window.show();
		
	}
	
}
