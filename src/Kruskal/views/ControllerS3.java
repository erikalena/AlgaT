package Kruskal.views;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import Kruskal.views.alertWindow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.sceneController;


public class ControllerS3 implements model.ISceneController {
	
	sceneController sc;
	Integer index=0;  //setto l'indice per l'ordinamento degli archi, fuori dalla funzione perché si resetterebbe ogni volta
    
	@FXML
    private Button NextB, PrevB;

    @FXML
    private Line A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12;
    

    @FXML
    private Button OrdAB;

    @FXML
    private AnchorPane V1, V2, V3, V4, V5, V6, V7, V8, V9, V10, V11, V12;
    

    @FXML
    void FaiOrdinare(ActionEvent event) {
    	alertWindow p = new alertWindow();
    	p.createAlert(AlertType.INFORMATION, "Perché non ordini tu gli archi?\nCliccaci sopra in ordine crescente!", "Esercizio");
    }

    @FXML
    void Fill(MouseEvent event) throws IOException {
    	Line x = (Line) event.getSource();
    	x.setStroke(Color.rgb(253,198,181));
    	x.setStrokeWidth(3);
    }

    @FXML
    void Unfill(MouseEvent event) {
    	Line x = (Line) event.getSource();
    	x.setStroke(Color.WHITE);
    	x.setStrokeWidth(3);
    }
    
    @FXML
    void toColor(MouseEvent event) {
    	
	
        Line[] lines = {A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12};
    	AnchorPane[] panes = {V1, V2, V3, V4, V5, V6, V7, V8, V9, V10, V11, V12};
    	
    	Line x = (Line) event.getSource();
    	

    	if(x.equals(lines[index])) {				//quando la linea cliccata è quella successiva all'ordine crescente
    		panes[index].setVisible(true);
    		index=index+1;
    	}
    		
    	
    	
    }
    
    
    @FXML
    void NextB(ActionEvent event) throws IOException {
    	sc.goNext();
    	
    	AnchorPane[] panes = {V1, V2, V3, V4, V5, V6, V7, V8, V9, V10, V11, V12};  //torno alle condizioni di partenza
    	
    	for(int i=0; i<12; i++)
    		panes[i].setVisible(false);
    	
    }

    @FXML
    void PrevB(ActionEvent event) throws IOException {
    	sc.goBack();	
    }
    
  	@Override
  	public void setSceneParent(sceneController parent) {
  		sc = parent;
  		
  	}


    @FXML
    void initialize() {
        assert NextB != null : "fx:id=\"NextB\" was not injected: check your FXML file 'scena3.fxml'.";
        assert PrevB != null : "fx:id=\"PrevB\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A9 != null : "fx:id=\"A9\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A8 != null : "fx:id=\"A8\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A6 != null : "fx:id=\"A6\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A10 != null : "fx:id=\"A10\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A1 != null : "fx:id=\"A1\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A2 != null : "fx:id=\"A2\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A12 != null : "fx:id=\"A12\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A7 != null : "fx:id=\"A7\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A3 != null : "fx:id=\"A3\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A11 != null : "fx:id=\"A11\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A5 != null : "fx:id=\"A5\" was not injected: check your FXML file 'scena3.fxml'.";
        assert A4 != null : "fx:id=\"A4\" was not injected: check your FXML file 'scena3.fxml'.";
        assert OrdAB != null : "fx:id=\"OrdAB\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V1 != null : "fx:id=\"V1\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V2 != null : "fx:id=\"V2\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V3 != null : "fx:id=\"V3\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V4 != null : "fx:id=\"V4\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V5 != null : "fx:id=\"V5\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V6 != null : "fx:id=\"V6\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V7 != null : "fx:id=\"V7\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V8 != null : "fx:id=\"V8\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V9 != null : "fx:id=\"V9\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V10 != null : "fx:id=\"V10\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V11 != null : "fx:id=\"V11\" was not injected: check your FXML file 'scena3.fxml'.";
        assert V12 != null : "fx:id=\"V12\" was not injected: check your FXML file 'scena3.fxml'.";

    }
}
