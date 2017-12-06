package team11project4.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import team11project4.ChocAnDataCenter;
import team11project4.Member;
import team11project4.Provider;

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
		
		updateMem.setOnAction(e -> Interface.setWindowScene(pickMemScene(oldScene)));
		updateProv.setOnAction(e -> Interface.setWindowScene(pickProvScene(oldScene)));
		previous.setOnAction(e -> Interface.setWindowScene(UserScenes.createOperatorScene(oldScene)));
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		
		VBox root = new VBox();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.getChildren().addAll(updateMem, updateProv, previous, userSelect);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
	}
	
	private static Scene pickMemScene(Scene oldScene) {
		GridPane root = new GridPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setHgap(10d);
		root.setVgap(10d);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		Label instr = new Label("Enter the number of the\nmember to be updated: ");
		root.add(instr, 0, 0);
		
		Label numberLabel = new Label("Member Number");
		root.add(numberLabel, 0, 1);
		TextField numberText = new TextField();
		root.add(numberText, 1, 1);
		
		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			ChocAnDataCenter db = new ChocAnDataCenter();
			String number = numberText.getText();
			Member member = db.getMember(number);
			if (member != null) {
				Interface.setWindowScene(updateMemScene(oldScene, member));
			} else {
				Alert failure = new Alert(AlertType.ERROR);
				failure.initModality(Modality.APPLICATION_MODAL);
				failure.setHeaderText("Update Member Failed");
				failure.setContentText("Failed to find member with that number.");
				failure.showAndWait();
			}
		});
		root.add(submit, 1, 2);
		
		Button previous = new Button(Interface.PREVIOUS);
		previous.setOnAction(e -> Interface.setWindowScene(createUpdateScene(oldScene)));
		root.add(previous, 0, 3);
		
		Button userSelect = new Button(Interface.USER_SELECT);
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		root.add(userSelect, 1, 3);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
	}
	
	private static Scene pickProvScene(Scene oldScene) {
		GridPane root = new GridPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setHgap(10d);
		root.setVgap(10d);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		Label instr = new Label("Enter the number of the\nprovider to be updated: ");
		root.add(instr, 0, 0);
		
		Label numberLabel = new Label("Provider Number");
		root.add(numberLabel, 0, 1);
		TextField numberText = new TextField();
		root.add(numberText, 1, 1);
		
		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			ChocAnDataCenter db = new ChocAnDataCenter();
			String number = numberText.getText();
			Provider provider = db.getProvider(number);
			if (provider != null) {
				Interface.setWindowScene(updateProvScene(oldScene, provider));
			} else {
				Alert failure = new Alert(AlertType.ERROR);
				failure.initModality(Modality.APPLICATION_MODAL);
				failure.setHeaderText("Update Provider Failed");
				failure.setContentText("Failed to find provider with that number.");
				failure.showAndWait();
			}
		});
		root.add(submit, 1, 2);
		
		Button previous = new Button(Interface.PREVIOUS);
		previous.setOnAction(e -> Interface.setWindowScene(createUpdateScene(oldScene)));
		root.add(previous, 0, 3);
		
		Button userSelect = new Button(Interface.USER_SELECT);
		userSelect.setOnAction(e -> Interface.setWindowScene(oldScene));
		root.add(userSelect, 1, 3);
		
		return new Scene(root, Interface.HEIGHT, Interface.WIDTH);
	}
	
	private static Scene updateMemScene(Scene oldScene, Member m) {
		
	}
	
	private static Scene updateProvScene(Scene oldScene, Provider p) {
		
	}

}
