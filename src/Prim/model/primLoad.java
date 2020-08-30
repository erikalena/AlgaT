package Prim.model;

import model.sceneController;

//loader per il caricamento delle scene nel sceneController dell'algoritmo di Prim

public class primLoad {

		 public static Integer prim = 1;
		 public static String primScene = "/Prim/views/prim.fxml";
		 public static Integer overView = 2;
		 public static String overViewScene = "/Prim/views/overView.fxml";
		 public static Integer concept = 3;
		 public static String conceptScene = "/Prim/views/concept.fxml";
		 public static Integer defProblem = 4;
		 public static String defProblemScene = "/Prim/views/defProblem.fxml";
		 public static Integer idea = 5;
		 public static String ideaScene = "/Prim/views/idea.fxml";
		 public static Integer correttezza = 6;
		 public static String correttezzaScene = "/Prim/views/correttezza.fxml";
		 public static Integer implementation = 7;
		 public static String implementScene = "/Prim/views/implementation.fxml";
		 public static Integer pseudoCodice = 8;
		 public static String codiceScene = "/Prim/views/pseudocodice.fxml";
		 public static Integer esecuzione = 9;
		 public static String exeScene = "/Prim/views/esecuzione.fxml";
		 public static Integer efficienza = 10;
		 public static String efficiencyScene = "/Prim/views/efficienza.fxml";
		 public static Integer efficienza2 = 11;
		 public static String efficiency2Scene = "/Prim/views/efficienza2.fxml";
		 public static Integer esercizi = 12;
		 public static String eserciziScene = "/Prim/views/esercizi.fxml";
		 public static Integer esercizi2 = 13;
		 public static String esercizi2Scene = "/Prim/views/esercizi2.fxml";
		 public static Integer domande = 14;
		 public static String domandeScene = "/Prim/views/domande.fxml";
		 public static Integer domande2 = 15;
		 public static String domande2Scene = "/Prim/views/domande2.fxml";	
		 public static Integer domande3 = 16;
		 public static String domande3Scene = "/Prim/views/domande3.fxml";
		 public static Integer domande4 = 17;
		 public static String domande4Scene = "/Prim/views/domande4.fxml";
	     
	     
	    public sceneController Load(sceneController controller) {
	    	
				try {

				 controller.loadScene(prim, primScene);
				 controller.loadScene(overView, overViewScene);
				 controller.loadScene(concept, conceptScene);
				 controller.loadScene(defProblem, defProblemScene);
				 controller.loadScene(idea, ideaScene);
				 controller.loadScene(correttezza, correttezzaScene);
				 controller.loadScene(implementation, implementScene);
				 controller.loadScene(pseudoCodice, codiceScene);
				 controller.loadScene(esecuzione, exeScene);
				 controller.loadScene(efficienza, efficiencyScene);
				 controller.loadScene(efficienza2, efficiency2Scene);
				 controller.loadScene(esercizi, eserciziScene);
				 controller.loadScene(esercizi2, esercizi2Scene);
				 controller.loadScene(domande, domandeScene);
				 
	             controller.setScene(prim);
	 
			     return(controller);
				 
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
					return(null);
				}
			
			}

}
