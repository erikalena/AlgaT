package progetto.greedy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ISceneController;
import model.sceneController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class algoritmiController implements ISceneController {

	sceneController sc;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane lessonP;

    @FXML
    void openIntro(ActionEvent event) throws IOException {
	     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	     sc.getProgetto().loadController(1,window);
    }

    @FXML
    void openKruskal(ActionEvent event) throws IOException{
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	     sc.getProgetto().loadController(3,window);
    }

    @FXML
    void openPrim (ActionEvent event) throws IOException {
    	 Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	 sc.getProgetto().loadController(2, window);
    }

    @FXML
    void openMenu(ActionEvent event) throws IOException  {
	    sc.goBack();	
    }

    @FXML
    void initialize() {

    }

	@Override
	public void setSceneParent(sceneController sceneParent) {		
		sc = sceneParent;
	}
}