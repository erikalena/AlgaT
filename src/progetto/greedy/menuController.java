package progetto.greedy;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import model.ISceneController;
import model.sceneController;

public class menuController implements ISceneController {

	sceneController sc;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BLEZ;

    @FXML
    private Button BGAME;


    @FXML
    void openLezioni(ActionEvent event) {
    	sc.setScene(4);
    }

    @FXML
    void openMonete(ActionEvent event) {
    	sc.goNext();
    }

    @FXML
    void initialize(){
        assert BLEZ != null : "fx:id=\"BLEZ\" was not injected: check your FXML file 'menu.fxml'.";
        BLEZ.setOnAction(event -> openLezioni(event));
        assert BGAME != null : "fx:id=\"BGAME\" was not injected: check your FXML file 'menu.fxml'.";
        BGAME.setOnAction(event -> openMonete(event));
    }

	@Override
	public void setSceneParent(sceneController sceneParent) {
		sc = sceneParent;
		
	}

}