package Prim.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import model.ISceneController;
import model.sceneController;


//gestisce il file esecuzione.fxml

public class exeController implements ISceneController {

	sceneController sc;

    @FXML
    private Button back, next;

    @FXML
    private StackPane spB,spC,spD,spE,spF,spG,spH;
    private Integer index = 0;
    
    @FXML
    private Line firstLine,secondLine,thirdLine,fourthLine,fifthLine,sixthLine,seventhLine,eigthLine,ninthLine,tenthLine,eleventhLine,twelfthLine;
    private Integer iLine = 0;
    private Integer iHatch = 2;


    @FXML
    private CubicCurve firstCut,secondCut,thirdCut,fourthCut,fifthCut,sixthCut,seventhCut;
    


    @FXML
    void toFill(MouseEvent event) {																			//stackPane, curve e linee sono organizzati in degli array 
    	final StackPane nodi[] = {spC,spE,spG,spF,spD,spB,spH};                                                //così da poter essere gestiti in sequenza
    	final CubicCurve curve[] = {firstCut,secondCut,thirdCut,fourthCut,fifthCut,sixthCut,seventhCut};
    	final Line[] linee = {firstLine,secondLine,thirdLine,fourthLine,fifthLine,sixthLine,eleventhLine,tenthLine,seventhLine,twelfthLine,eigthLine,ninthLine};
    	
    	
    	StackPane x = (StackPane) event.getSource();     //prende lo stackPane sul quale è avvenuto l'evento
    	      
    	if(index < nodi.length ) {                         //finchè non sono stati colorati tutti i nodi
   		         if (x.equals(nodi[index])) {
   		        	 
   		            Circle c = (Circle) x.getChildren().get(0);
                	c.setStroke(Color.rgb(201, 86, 24));
       	            c.setFill(Color.rgb(195,151,135));                         //a seconda dell'indice corrente rende visibili o meno le varie linee e i tagli
                   	curve[index].setOpacity(0.0);                        //rende invisibile il taglio precedente      
                   	linee[iLine].setStroke(Color.rgb(201, 86, 24));
                   	linee[iLine].setStrokeWidth(4);
                   	if(iLine == iHatch) {
                   		linee[iLine+5].getStrokeDashArray().addAll(20d,15d);           //gli archi "scartati" vengono tratteggiati
                   		if(iLine == 4) linee[11].getStrokeDashArray().addAll(25d,10d);
                   		iHatch = iHatch +1;
                   	}
                   
                  	if (index < nodi.length-1) {
       		            curve[index+1].setOpacity(1);
       	            	
                 	}
                 	index = index + 1;
                 	iLine = iLine + 1;
   	            }
    	}
    }

    @FXML
    void goBack(ActionEvent event) {
       sc.goBack();
    }

    @FXML
    void goNext(ActionEvent event) {
      sc.goNext();
    }
    
	@Override
	public void setSceneParent(sceneController sceneParent) {
		sc = sceneParent;	
	}

    @FXML
    void initialize() {
    	
    
     }

}
