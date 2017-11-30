/**
 * Author: Hunter Allen (jhallen3@crimson.ua.edu)
 */

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
        Button returnBtn = new Button(Interface.USER_SELECT);
        
        addMem.setOnAction(e -> Interface.setWindowScene(createAddMemScene(oldScene)));
        addProv.setOnAction(e -> Interface.setWindowScene(createAddProvScene(oldScene)));
        
        root.getChildren().addAll(addMem, addProv, returnBtn);
        
        return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
    }
    
    private static Scene createAddMemScene(Scene oldScene) {
        
        Button previous = new Button(Interface.USER_SELECT);
        
        previous.setOnAction(e -> Interface.setWindowScene(oldScene));
        
        //TODO: Replace this layout
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.getChildren().addAll(previous);
        
        return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
    }
    
    private static Scene createAddProvScene(Scene oldScene) {
        
    	Button previous = new Button(Interface.USER_SELECT);
    	
    	previous.setOnAction(e -> Interface.setWindowScene(oldScene));
    	
        //TODO: Replace this layout
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.getChildren().addAll(previous);
                
        return (new Scene(root, Interface.HEIGHT, Interface.WIDTH));
    }
    
}
