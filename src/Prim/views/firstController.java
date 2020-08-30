package Prim.views;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import Prim.model.primLoad;
import model.sceneController;


//gestisce i seguenti file FXML : prim.fxml, overView.fxml, concept.fxml, defProblem.fxml

public class firstController implements model.ISceneController {
	
	
		sceneController sc;
		
		ObservableList<String> definizioni = FXCollections.observableArrayList("Grafo non orientato e connesso","Albero di copertura", "Albero di copertura minimo", "Taglio","Arco sicuro");
			
	    @FXML
	    private Button start, back, next, menu, alert,controlla;
	    
		    
	    @FXML
		private StackPane sp1,sp2,sp3,sp4,sp5,sp6;    //stackPanes FXML overView
	
	    
	    @FXML
	    private ImageView image;

	    @FXML
	    private Label kruskal;


		@FXML
	    private ChoiceBox<String> cbox ;

	    @FXML
	    private CheckBox check1,check2,check3,check4,check5;

		
	//FUNZIONI CHE GESTISCONO L'FXML OVERVIEW
		    @FXML
		    void information(ActionEvent event) throws FileNotFoundException {  //apre un alertBox che informa l'utente delle conoscenze pregresse delle quali necessita
		         alertWindow aw = new alertWindow();
		         aw.createAlert(AlertType.WARNING,1, "Nota Bene");
		    }
		    
		    @FXML
		    void gotoCode(MouseEvent event) {
		    	sc.setScene(primLoad.pseudoCodice);
		    }

		    @FXML
		    void gotoIdea(MouseEvent event) {
		        sc.setScene(primLoad.idea);
		    }
		    
		    @FXML
		    void gotoCorrect(MouseEvent event) throws IOException {
		    	 sc.setScene(primLoad.correttezza);
		    }


		    @FXML
		    void gotoEfficiency(MouseEvent event) {
		    	sc.setScene(primLoad.efficienza);
		    }

		    @FXML
		    void gotoEsercizi(MouseEvent event) {
		      sc.setScene(primLoad.esercizi);
		    }

		    @FXML
		    void gotoImplementation(MouseEvent event) throws IOException {
		    	sc.setScene(primLoad.implementation);
		    }


		    @FXML
		    void toFill(MouseEvent event)  throws IOException {     //colora i cerchi del menù quando ci si passa sopra con il mouse
		    	StackPane x = (StackPane) event.getSource();       
		    	Circle c = (Circle) x.getChildren().get(0);           //recupera il cerchio che è l'ultimo figlio dello stackPane
		    	c.setFill(Color.rgb(228,160,160));
		    }

		    @FXML
		    void unfill(MouseEvent event)  throws IOException{
		    	StackPane x = (StackPane) event.getSource();
		    	Circle c = (Circle) x.getChildren().get(0);
		    	c.setFill(Color.rgb(196,229,242));
		    }  
		    
		    
 //FUNZIONI CHE GESTISCONO L'FXML CONCEPT	
		    
		    @FXML
		    void verify(ActionEvent event) {
		    	CheckBox[] check = {check1,check2,check3,check4,check5};   //controlla che i checkBoxes siano stati spuntati e abilita/disabilita
		    	boolean selected = true;                                    //di conseguenza il pulsante per andare avanti 
		    	for(int i = 0; i < check.length; i++) {
		    		if(!check[i].isSelected()) selected = false;
		    	}
		    	if (selected) next.setDisable(false);
		    	else next.setDisable(true);
		    }

		    @FXML
		    void tocheck(ActionEvent event) throws IOException {                //carica la definizione richiesta aprendo un file txt caricato nel programma
		        String s = cbox.getValue();
		        alertWindow info = new alertWindow();
				if(s == definizioni.get(1))
		             info.createAlert(AlertType.INFORMATION, 2,"Definizione Albero di copetura");
		        else if (s==definizioni.get(2))
		        	 info.createAlert(AlertType.INFORMATION, 3, "Definizione Albero di copertura minimo");
		        else if (s==definizioni.get(3))
		        	 info.createAlert(AlertType.INFORMATION, 4, "Definizione Taglio");
		        else if (s==definizioni.get(4))
		        	info.createAlert(AlertType.INFORMATION, 6, "Definzione Arco sicuro");
		        else info.createAlert(AlertType.INFORMATION, 5, "Definzione Grafo non orientato e connesso");
		    }	    
	    
 //FUNZIONI CHE GESTISCONO L'FXML DEFPROBLEM
		    
		 @FXML
		  void gotoKruskal(MouseEvent event) throws IOException {                        //si sposta alla sezione Algoritmo di Kruskal
			    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                sc.getProgetto().loadController(3,window);
		    }		    
		    
		    
  //Funzioni che gestiscono lo scambio tra le pagine
		 
        @FXML
		 void goBack(ActionEvent event) throws IOException {
		  sc.goBack();
		  }
		    
		@FXML
		  void goNext(ActionEvent event) throws IOException {
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

	        //FXML concept
	        if(cbox != null) { cbox.setValue("Grafo non orientato e connesso"); cbox.setItems(definizioni); }

	        //FXML defProblem
	         if(image!=null)   image.setImage(new Image("/Image/Minimum_spanning_tree.png"));
	        
	    }

}
