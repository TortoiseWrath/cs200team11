package team11project4.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class OperatorAddScenes {

    public static Scene createAddScene(Scene oldScene) {
        
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        
        Button addMem = new Button("Add Member");
        Button addProv = new Button("Add Provider");
        Button returnBtn = new Button("Return");
        
        addMem.setOnAction(e -> Interface.window.setScene(createAddMemScene(oldScene)));
        addProv.setOnAction(e -> Interface.window.setScene(createAddProvScene(oldScene)));
        
        root.getChildren().addAll(addMem, addProv, returnBtn);
        
        return (new Scene(root, 600, 400));
    }
    
    private static Scene createAddMemScene(Scene oldScene) {
        
        Button returnBtn = new Button("Return");
        
        returnBtn.setOnAction(e -> Interface.window.setScene(oldScene));
        
        //TODO: Replace this layout
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.getChildren().addAll(returnBtn);
        
        return (new Scene(root, 600, 400));
    }
    
    private static Scene createAddProvScene(Scene oldScene) {
        
        //TODO: Replace this layout
        VBox root = new VBox();
                
        return (new Scene(root, 600, 400));
    }
    
}
