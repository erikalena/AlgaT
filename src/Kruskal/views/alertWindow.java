package Kruskal.views;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;

public class alertWindow {

    
     public void createAlert(AlertType type, String message,String title) {
        Alert alert = new Alert(type, message);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(title);
		alert.showAndWait();
    }

}
