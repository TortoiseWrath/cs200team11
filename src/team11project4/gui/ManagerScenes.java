package team11project4.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class ManagerScenes {

	public static Scene createSummaryScene(Scene oldScene) {
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
	}
}
