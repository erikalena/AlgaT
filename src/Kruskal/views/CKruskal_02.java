package Kruskal.views;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.sceneController;

//CONTROLLER DI intro.fxml E scena2.fxml

public class CKruskal_02 implements model.ISceneController {
	
	sceneController sc;
	

	
    @FXML
    private Button NextB, AlgoritmiMenu;

    @FXML
    private Button PrevB;
    

    @Override
	public void setSceneParent(sceneController parent) {
		sc = parent;
		
	}

    //intro
    @FXML
    void GoToMenu(ActionEvent event) throws IOException {
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    sc.getProgetto().gotoMenu(window);	
    }

    //scena2
    @FXML
    void PrevB(ActionEvent event) throws IOException {
    	sc.goBack();	
    }
    
    //entrambe
    @FXML
    void NextB(ActionEvent event) throws IOException {
    	sc.goNext();	
    }

    @FXML
    void initialize() {
    	assert PrevB != null : "fx:id=\"PrevB\" was not injected: check your FXML file 'Intro.fxml'.";
        assert NextB != null : "fx:id=\"NextB\" was not injected: check your FXML file 'Intro.fxml'.";
        assert AlgoritmiMenu != null : "fx:id=\"AlgoritmiMenu\" was not injected: check your FXML file 'Intro.fxml'.";

    }

}
