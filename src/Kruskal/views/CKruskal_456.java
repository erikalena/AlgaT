package Kruskal.views;

import java.io.IOException;

import Kruskal.model.SceneLoader_Kruskal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.sceneController;

//CONTROLLER DI scena4.fxml - scena5.fxml - scena6.fxml

public class CKruskal_456 implements model.ISceneController {
	
	sceneController sc;
	
	@FXML
    private Button PrevB, NextB;
	
	//scena4
    @FXML
    private ImageView pseudoK;
    
    @FXML
    private Button Ripasso;
    
    //scena4bis
    @FXML
    private ImageView imMFSET;
    
    @FXML
    private Button Back;
    
    //scena5
    @FXML
    private ImageView costoK;
    
    @FXML
    private Button Correttezza;
    
    //scena6
    @FXML
    private ImageView pseudoTotK;
    
    
    //FUNZIONI
    
    //scena 4
    @FXML
    void GoToMFSet(ActionEvent event) {
    	sc.setScene(SceneLoader_Kruskal.scena4b_K);
    }
    
    //scena4bis
    @FXML
    void GoToScene4(ActionEvent event) {
    	sc.setScene(SceneLoader_Kruskal.scena4_K);
    }
    
    //scena5
    @FXML
    void GoToCorrettezza(ActionEvent event) throws IOException {
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    sc.getProgetto().loadScene(1, window, 1);
    }
    
    //cambio scena - in comune
    
	@Override
	public void setSceneParent(sceneController parent) {
		sc = parent;
		
	}

    @FXML
    void NextB(ActionEvent event) throws IOException {
    	sc.goNext();
    }

    @FXML
    void PrevB(ActionEvent event) throws IOException {
    	sc.goBack();	
    }

    
    @FXML
    void initialize() {
    	
        assert PrevB != null : "fx:id=\"PrevB\" was not injected: check your FXML file 'scena4.fxml'.";
        assert NextB != null : "fx:id=\"NextB\" was not injected: check your FXML file 'scena4.fxml'.";
        assert Ripasso != null : "fx:id=\"Ripasso\" was not injected: check your FXML file 'scena4.fxml'.";
        assert pseudoK != null : "fx:id=\"pseudoK\" was not injected: check your FXML file 'scena4.fxml'.";
        if(pseudoK != null)pseudoK.setImage(new Image("/Image/kruskal.png"));
        
        //
        assert imMFSET != null : "fx:id=\"imMFSET\" was not injected: check your FXML file 'scena4bis.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'scena4bis.fxml'.";
        if(imMFSET != null)imMFSET.setImage(new Image("/Image/MFSET.png"));
        
        //
        assert costoK != null : "fx:id=\"costoK\" was not injected: check your FXML file 'scena5.fxml'.";
        if(costoK != null)costoK.setImage(new Image("/Image/costoK.png"));
        
        //
        assert pseudoTotK != null : "fx:id=\"pseudoTotK\" was not injected: check your FXML file 'scena6.fxml'.";
        if(pseudoTotK != null)pseudoTotK.setImage(new Image("/Image/pseudoTotK.png"));
        
    }
}


