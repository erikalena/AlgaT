package model;

import java.util.HashMap;
import java.util.Map.Entry;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import progetto.greedy.progettoController;


public class sceneController extends StackPane {

	protected HashMap<Integer, Node> mappa ;        //hashMap che contiene tutte le scene
	protected progettoController mainProject;                    //struttura del progetto
	protected Integer scenaCorrente;                  //indice della scena attualmente visibile, in cima allo StackPane
	
	
	public sceneController() {
		this.mappa = new HashMap<>();
		this.mainProject = null;
		this.scenaCorrente = 1;
	}
	
	public Integer getScenaCorrente() {      //ritorna l'indice della scena attualmente visibile
		return(scenaCorrente);
	}
	
	public void addScene(Integer n, Node scene) {        
		mappa.put(n, scene);
	}

    public Node getNode(Integer n) {
	  return(mappa.get(n));
    }
    
    
    public Integer getIndex (Node scene) {
    	 for (Entry<Integer, Node> entry : mappa.entrySet()) {
    	        if (scene.equals(entry.getValue())) {
    	            return entry.getKey();
    	        }
    	    }
    	    return null;
    }
    
    public HashMap<Integer,Node> getMap(sceneController sc) {                //ritorna la mappa che contiene tutte le scene di uno specifico sceneController
    	return(sc.mappa);
    }
	    
    
  public void loadScene(Integer n, String resource) {
    	 try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
             AnchorPane ap = loader.load();                                                   //carica il filefxml richiesto
             ISceneController sceneController = ((ISceneController) loader.getController());    //il controller relativo deve implementare la funzione setSceneParent
             sceneController.setSceneParent(this);   
             addScene(n, ap);                       //aggiungi la scena alla hashMap
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
    }    
    
 
    public void setScene(Integer n) {     
    	
    	if (mappa.containsKey(n) && mappa.get(n) != null) {   //la scena deve essere stata caricata nella mappa

        if (!getChildren().isEmpty()) {    // se è presente più di una scena nella mappa
        	
    		Integer scenaRichiesta = n;
    		if(scenaRichiesta > scenaCorrente) {                 //se la scena richiesta ha un indice maggiore di quello attuale la funzione
    			while(scenaRichiesta > scenaCorrente) {           //chiama goNext() il numero di volte richiesto
    				this.goNext();
    			}
    		}
    		else if (scenaRichiesta < scenaCorrente) {            //altrimenti va indietro finchè non raaggiunge la scena desiderata
    			while(scenaRichiesta < scenaCorrente) {
    				this.goBack();
    			}
    		}
    		scenaCorrente = n;          //aggiorna l'indice della scena attuale
        }
        
         else {
            getChildren().add(mappa.get(n));       //se non ci sono altri figli la scena viene aggiunta e mostrata come primo figlio
            scenaCorrente = n;
        }
        
      } else {
        System.out.println("Questa scena non è stata caricata\n");
    }
    	
   }
   
    public void goBack() {
       	try {	
       	 Integer x = scenaCorrente;
  		 Node attuale = this.getNode(x);         //prende il nodo corrispondente alla scena attuale
  		 getChildren().remove(attuale);            //e lo rimuove dalla pila così da rendere visibile quello sottostante
  		 scenaCorrente = scenaCorrente - 1;
  
      	} catch (Exception e) {
              System.out.println(e.getMessage());             
          }
    }
    
    public void goNext() {
    	try {	
    		
    	 scenaCorrente = scenaCorrente + 1;     //prende l'indice della scena successiva a quella attuale
   		 Integer x = scenaCorrente; 
   		 getChildren().add(mappa.get(x));         //e inserisce la scena tra i figli, mettendola in cima
   		 
    	} catch (Exception e) {
           System.out.println(e.getMessage());
          
       }
    }
    
    
    
    public void setProgetto(progettoController progetto) {       //questa funzione comunica al sceneController qual è il progetto (progettoController)
    	mainProject = progetto;                                   //al quale deve fare riferimento
    }
    
    public progettoController getProgetto() {                   //ritorna il progetto al quale il sceneController è associato
    	return(mainProject);
    }
    
}
