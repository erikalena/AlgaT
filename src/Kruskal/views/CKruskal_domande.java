package Kruskal.views;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.annotation.Resource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.sceneController;

public class CKruskal_domande implements model.ISceneController {

	sceneController sc;
	
	Integer indexScene = 0;
	
	@FXML
	private Text domanda;
	String[] domande;
	
	@FXML
	private Button BtnRisp;
	
    @FXML
    private TextArea Risultato;

    @FXML
    private TextField Tentativo;

    @FXML
    private Button Riprova;

    @FXML
    private Button PrevB, NextB;
    
    
    
    void setDomanda(Integer n) throws IOException{
    	
    	Integer x=0;
    	String a=null;
    	
    	n=n+1;							//n indica l'indice della domanda, c'è il +1 perché le linee del file partono da 1
    	
    	try {
    		InputStream input = Resource.class.getResourceAsStream("/domandeK.txt");
  		    Scanner scanner = new Scanner (input);

    		while(x<n && scanner.hasNext()) {
    			a = scanner.nextLine();
    			x=x+1;
    		}
    		scanner.close();
    		
    		domanda.setText(a);
    	}
    	catch(Exception ex) {
			System.out.println("Unable to open answers file");                
        }
    	
    }
    
    @FXML
    void Clear(ActionEvent event) {
    	
    	Tentativo.clear();
    	Risultato.clear();
    	
    }

    @FXML
    void GetAnswer(ActionEvent event) throws IOException {
    	
    	String filename;
    	if(indexScene.equals(0)) filename = "/risposte_K.txt";
    	else filename = "/risposte2_K.txt";
    	
    	String prova = Tentativo.getText();
    	prova = prova.trim();
    	
    	if(prova.length()!=0) { //se c'è scritto qualcosa
    		try {	
    			InputStream input = Resource.class.getResourceAsStream(filename);
    			Scanner scanner = new Scanner (input);
    			boolean found = false;
    			while(scanner.hasNext()) {
    				String a = scanner.nextLine();
    				if(a.equals(prova)) {
    					Risultato.appendText("Corretto!"); 
    					found = true;
    					NextB.setDisable(false);
    				}
    			}
    			if(!found) Risultato.appendText("Sbagliato, riprova");
    	        scanner.close(); }
    		catch(Exception ex) {
    			System.out.println("Unable to open answers file");                
    		        }
    			}
    	
    }

    @Override
	public void setSceneParent(sceneController parent) {
		sc = parent;
		
	}

    @FXML
    void NextB(ActionEvent event) throws IOException {
    	
    	Tentativo.clear();
		Risultato.clear();
		
		indexScene = indexScene + 1;	//aumenta l'indice che indica la domanda
    	
    	if(indexScene.equals(2)) {		//quando le domande sono finite si passa alla scena successiva
    		sc.goNext();
    	}
    	
    	else this.setDomanda(indexScene);		//setta la domanda
    	
    }

    @FXML
    void PrevB(ActionEvent event) throws IOException {
    	
    	Tentativo.clear();
    	Risultato.clear();
    	
    	indexScene = indexScene - 1;
    	
    	if(indexScene.equals(-1)) {
    		sc.goBack();
    	}	
    	
    	else this.setDomanda(indexScene);
    }
    

    @FXML
    void initialize() throws IOException {

        assert Risultato != null : "fx:id=\"Risultato\" was not injected: check your FXML file 'domande.fxml'.";
        assert Tentativo != null : "fx:id=\"Tentativo\" was not injected: check your FXML file 'domande.fxml'.";
        assert Riprova != null : "fx:id=\"Riprova\" was not injected: check your FXML file 'domande.fxml'.";
        assert BtnRisp != null : "fx:id=\"BtnRisp\" was not injected: check your FXML file 'domande.fxml'.";
        assert domanda != null : "fx:id=\"domanda\" was not injected: check your FXML file 'domande.fxml'.";
        assert PrevB != null : "fx:id=\"PrevB\" was not injected: check your FXML file 'domande.fxml'.";
        assert NextB != null : "fx:id=\"NextB\" was not injected: check your FXML file 'domande.fxml'.";
        
    }
}
