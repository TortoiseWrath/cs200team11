package team11project4.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class OperatorDelScenes {

	public static Scene createDelScene(Scene oldScene) {
		
		Label instr = new Label("Select an option");
		
		Button delMem = new Button("Delete Member");
		Button delProv = new Button("Delete Provider");
		Button previous = new Button(Interface.USER_SELECT);
		
		delMem.setOnAction(e -> Interface.setWindowScene(createDelMemScene(oldScene)));
		delProv.setOnAction(e -> Interface.setWindowScene(createDelProvScene(oldScene)));
		previous.setOnAction(e -> Interface.setWindowScene(oldScene));
		
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(instr, delMem, delProv, previous);
		
		return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
	}
	
	private static Scene createDelMemScene(Scene oldScene) {
		
		Button previous = new Button(Interface.USER_SELECT);
		
		previous.setOnAction(e -> Interface.setWindowScene(oldScene));
		
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(previous);
		
		return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
	}
	
	private static Scene createDelProvScene(Scene oldScene) {
		
		Button previous = new Button(Interface.USER_SELECT);
		
		previous.setOnAction(e -> Interface.setWindowScene(oldScene));
		
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(previous);
		
		return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
	}
	
}
