package team11project4.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class OperatorUpdateScenes {
	
	public static Scene createUpdateScene(Scene oldScene) {
		//Create buttons for updating members and providers
		Button updateMem = new Button("Update Members");
		Button updateProv = new Button("Update Providers");
		Button previous = new Button(Interface.PREVIOUS);
		Button userSelect = new Button(Interface.USER_SELECT);
		
		VBox.setMargin(updateMem, new Insets(5, 0, 5, 0));
		VBox.setMargin(updateProv, new Insets(5, 0, 5, 0));
		VBox.setMargin(previous, new Insets(5, 0, 5, 0));
		VBox.setMargin(userSelect, new Insets(5, 0, 5, 0));
		
		updateMem.setOnAction(e -> Interface.setWindowScene(updateMemScene(oldScene)));
		updateProv.setOnAction(e -> Interface.setWindowScene(updateProvScene(oldScene)));
		previous.setOnAction(e -> Interface.setWindowScene(UserScenes.createOperatorScene(oldScene)));
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(updateMem, updateProv, previous, userSelect);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
	}
	
	private static Scene updateMemScene(Scene oldScene) {
		
	}
	
	private static Scene updateProvScene(Scene oldScene) {
		
	}

}
