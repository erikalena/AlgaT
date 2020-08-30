package progetto.greedy;	

import java.io.IOException;

import Kruskal.model.SceneLoader_Kruskal;
import Prim.model.primLoad;
import intro_KP.model.introLoad;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lezione1.introSceneLoader;
import model.sceneController;

//classe che gestisce tutti controller delle lezioni, li inserisce in un array e gestisce le funzioni di interscambio

public class progettoController extends Application {


        protected Integer controllerCorrente;     //mantiene l'indice del sceneController attualmente in esecuzione
        
		protected sceneController[] progetto ;    //array che contiene tutti i sceneController del progetto
		
		protected double stageWidth;          //parametri per regolare le dimensioni della finestra
		protected double stageHeight;
		protected boolean inizia;
	
		
		public progettoController() {
			this.controllerCorrente = 0;
			this.progetto = new sceneController[5];
			this.stageHeight = 0;
			this.stageWidth = 0;
			this.inizia = true;
		}
		
		
		public void load() {                        //carica i sceneController dentro l'array
			
		   	try {
				
		   		sceneController mainController = new sceneController();
				menuLoad main = new menuLoad();
				mainController = main.Load(mainController);
				
				sceneController kruskalController = new sceneController();
				SceneLoader_Kruskal kruskal = new SceneLoader_Kruskal();
				kruskalController = kruskal.Load(kruskalController);
				
				sceneController primController = new sceneController();
				primLoad prim = new primLoad();
				primController = prim.Load(primController);
				

				sceneController introKPController = new sceneController();
				introLoad introKP = new introLoad();	
				introKPController = introKP.Load(introKPController);
				
				sceneController introController = new sceneController();
				introSceneLoader intro = new introSceneLoader();	
				introController = intro.Load(introController);
		   		
				progetto[0] = mainController;
				progetto[1] = introKPController;
				progetto[2] = primController;
				progetto[3] = kruskalController;	
				progetto[4] = introController;

				
				this.setStructure();                     

		 
		     } catch(Exception e) {
			    e.printStackTrace();
		   }
		   	
	     }
		

        public void setStructure() {       //comunica ad ogni sceneController il progetto al quale devono fare riferimento
        	
        	for(int i = 0; i < progetto.length; i++) {
        		progetto[i].setProgetto(this);
        	}
        	
        }
        
        
        public void calcolaX(Stage window) {
        	this.stageWidth = window.getWidth() - 1080;  //calcola la differenza tra la larghezza dello stage e quella della scena
        }
        
        public void calcolaY(Stage window) {
           	this.stageHeight = window.getHeight() - 720;   //calcola la differenza tra l'altezza dello stage e quella della scena
        }
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			try {																//crea uno stackPane e imposta come figlio il sceneController corrente
				
		    StackPane root = new StackPane();
			root.getChildren().add(progetto[controllerCorrente]);
			
    		root.getStylesheets().add(getClass().getResource("/stylesheets/application.css").toExternalForm());
    	    root.getStyleClass().add("stackp");
    		
//          System.out.println(root.getHeight());
    	    
    	    NumberBinding ScaleX = Bindings.divide(root.widthProperty(), 1080);     //calcola il fattore di scala in relazione
    	    NumberBinding ScaleY = Bindings.divide(root.heightProperty(), 720);     //al ridimensionamento della finestra

    	    
    	    progetto[controllerCorrente].scaleXProperty().bind(ScaleX);
    	    progetto[controllerCorrente].scaleYProperty().bind(ScaleY);
          
    	    
//    	    System.out.println(primaryStage.getHeight());
 	    
    	    Scene scene;
    	    if(inizia) scene = new Scene(root);
    	    else scene = new Scene(root,primaryStage.getWidth()-this.stageWidth,primaryStage.getHeight()-this.stageHeight);  // setta la scena 
    	    																													//della dimensione corretta
    		primaryStage.setScene(scene);

    		
    		primaryStage.show();

    		if(inizia) {
    		   this.calcolaX(primaryStage);     //calcola la differenza tra le dimensioni dello stage e quelle della scena
    		   this.calcolaY(primaryStage);      //tali dimensioni rimangono costanti, per cui la funzione è chiamata una volta
    		   inizia = false;                      //all'avvio
    		}
    		
			} catch (Exception e) {	
				System.out.println(e.getMessage());
			}
    		
		}

		
		public void gotoMenu(Stage window) throws IOException {	
			
			progetto[controllerCorrente].setScene(1);         //riposiziona il sceneController da cui si sta muovendo l'utente alla prima scena
			controllerCorrente = 0;
			try {                                                //per andare al menu prende il sceneController in posizione 
																	//zero nell'array e lo carica
				this.start(window);	
			   
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		public void loadController(Integer i, Stage window) {  //prende in input l'indice relativo al sceneController
			controllerCorrente = i;                             //che si vuole caricare e chiama la funzione start per caricarlo
			try {
				this.start(window);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public void loadScene(Integer i, Stage window, Integer scena) throws IOException {   //prende in input l'indice del sceneController e l'indice della scena desiderata
																						      
			this.loadController(i,window);
			
			sceneController attuale = this.progetto[controllerCorrente];          //prende il sceneController richiesto              
			
			if(attuale.getMap(attuale).containsKey(scena)) {                                     //se la scena è contenuta nell'hashMap
			while(attuale.getNode(attuale.getScenaCorrente()) != attuale.getNode(scena)) {        //si muove avanti o indietro fino alla scena richiesta
				if(attuale.getScenaCorrente() < scena)	attuale.goNext();
				else attuale.goBack();
			}
		  }
		}

}
