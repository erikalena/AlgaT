package Prim.views;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.sceneController;


//classe per la gestione dei seguenti file : idea.fxml, correttezza.fxml, implementation.fxml

public class secondController implements model.ISceneController{

	sceneController sc;

    @FXML
    private Button back, next;
    
    @FXML
    private Circle c1,c2;   //fxml implementazione
    
    @FXML
    private Label answer;

    @FXML
    private Button definition, corollary; //fxml correttezza
    
    
    @FXML
    private ImageView immagine;    //fxml pseudocode


    
//FUNZIONI DI GESTIONE DELL'FXML CORRETTEZZA
    
   @FXML
    void checkCorollary(ActionEvent event) throws IOException {                  //va all'ultima scena dell'introduzione in cui è spiegato il corollario
	     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	     sc.getProgetto().loadScene(1,window, 4);
    }

    @FXML
    void checkDefinition(ActionEvent event) throws IOException {                  //carica la definizione di taglio
    	alertWindow definizione = new alertWindow();
    	definizione.createAlert(AlertType.INFORMATION, 4, "Definizione Taglio");
    }
   
//FUNZIONI DI GESTIONE DELL'FXML IMPLEMENTAZIONE
    
    @FXML
    void getAnswer(MouseEvent event) {                           //ritorna la risposta alla scelta del nodo da parte dell'utente
    	 Circle c = (Circle) event.getSource();
    	 answer.setFont(Font.font("Segoe UI",FontWeight.BOLD,FontPosture.REGULAR, 17));
    	 answer.setOpacity(1.00);
    	 if(c == c2) {
    		 answer.setText("Corretto!");
    		 answer.setDisable(false);
    		 c2.setStroke(Color.rgb(168,103,103));
    	 }
    	 else {
    		 answer.setText("Sbagliato");
    		 answer.setDisable(false);
    		 c1.setStroke(Color.rgb(168,103,103));
    	 }
    }
   
    @FXML
    void toColor(MouseEvent event) {
       Circle c = (Circle) event.getSource();
       c.setStroke(Color.rgb(168,103,103));
    }

    @FXML
    void toUncolor(MouseEvent event) {	
    	Circle c = (Circle) event.getSource();
        c.setStroke(Color.rgb(72,111,117));
    }
    
    
 
 //funzioni che gestiscono il cambio delle scene   
    
    @FXML
    void goBack(ActionEvent event) throws IOException{
       sc.goBack();
    }

    @FXML
    void goNext(ActionEvent event) throws IOException {
    	sc.goNext();
    }
    
	@Override
	public void setSceneParent(sceneController sceneParent) {
		sc = sceneParent;
	}

    @FXML
    void initialize() {

        if(immagine!=null) immagine.setImage(new Image("/Image/prim.jpg"));
       
    }

}