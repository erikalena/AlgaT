
package lezione1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.sceneController;

import java.io.IOException;

public class navController implements model.ISceneController{

    sceneController sc;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        sc.goBack();
    }

    @FXML
    void goNext(ActionEvent event) throws IOException {
        sc.goNext();
    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        sc.getProgetto().gotoMenu(window);
    }

    @Override
    public void setSceneParent(sceneController sceneParent) {
        sc = sceneParent;
    }
}
