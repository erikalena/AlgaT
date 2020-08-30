package intro_KP.views;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.sceneController;


//gestisce i file FXML : introduzione1, introduzione2, introduzione3, introduzione4.fxml


public class introController implements model.ISceneController{

	sceneController sc; 
	

    @FXML
    private Line line1, line2, taglio;
	
	@FXML
	private Button back, next, menu, change;
	
    @FXML
    private Text albero;
    

	
	
//Funzioni che gestiscono l'FXML introduzione3.fxml
	
	  @FXML
	    void trasforma(ActionEvent event) {                    //trasforma l'albero T nell'albero T' 
               line1.setStroke(Color.rgb(140, 143, 154));
               line2.setStroke(Color.rgb(228, 11, 11));
               
               albero.setText("T'");       
	    }

	  
//Funzioni che gestiscono lo scambio delle scene 
	  
    @FXML
    void goBack(ActionEvent event) {
       sc.goBack();
    }

    @FXML
    void goNext(ActionEvent event) {
       sc.goNext();
    }
    
    @FXML
    void gotoMenu(ActionEvent event) throws IOException {
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    sc.getProgetto().gotoMenu(window);   
       }

	@Override
	public void setSceneParent(sceneController parent) {
		sc = parent;	
	}


	 @FXML
	 void initialize() {
		 
	//FXML introduzione3	 
	    assert change != null : "fx:id=\"change\" was not injected: check your FXML file 'introduzione3.fxml'.";
	    assert line1 != null : "fx:id=\"line1\" was not injected: check your FXML file 'introduzione3.fxml'.";
	    assert line2 != null : "fx:id=\"line2\" was not injected: check your FXML file 'introduzione3.fxml'.";
	    assert albero != null : "fx:id=\"albero\" was not injected: check your FXML file 'introduzione3.fxml'.";
	    
    	assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'introduzione.fxml'.";
        assert next != null : "fx:id=\"next\" was not injected: check your FXML file 'introduzione.fxml'.";
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'introduzione.fxml'.";
    }
}