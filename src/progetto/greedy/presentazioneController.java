package progetto.greedy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ISceneController;
import model.sceneController;

public class presentazioneController implements ISceneController {
	
	sceneController sc;
	
	  @FXML
	    private ImageView image;

	    @FXML
	    void goNext(ActionEvent event) {
           sc.goNext();
	    }

	    @FXML
	    void initialize() {
	        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'presentazione.fxml'.";
	        if(image != null) image.setImage(new Image("/Image/unibo.png"));
	    }

	    
	    @Override
		public void setSceneParent(sceneController sceneParent) {
			sc = sceneParent;	
		}
}
