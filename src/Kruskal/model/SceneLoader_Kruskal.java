package Kruskal.model;

import model.sceneController;

//loader per il caricamento delle scene nel sceneController dell'introduzione agli algoritmi

public class SceneLoader_Kruskal {
		
		 public static Integer kruskal = 1;
		 public static String kruscene = "/Kruskal/views/Intro.fxml";
		 public static Integer scena1_K = 2;
		 public static String minalbero = "/Kruskal/views/scena1.fxml";
		 public static Integer scena2_K = 3;
		 public static String intro_K = "/Kruskal/views/scena2.fxml";
		 public static Integer scena3_K = 4;
		 public static String costo = "/Kruskal/views/scena3.fxml";
		 public static Integer scena4_K = 5;
		 public static String costop2 = "/Kruskal/views/scena4.fxml";
		 public static Integer scena5_K = 6;
		 public static String parte23 = "/Kruskal/views/scena5.fxml";
		 public static Integer scena6_K = 7;
		 public static String pseudo = "/Kruskal/views/scena6.fxml";
		 public static Integer scena7_K = 8;
		 public static String esercizio1 = "/Kruskal/views/scena7.fxml";
		 public static Integer scena8_K = 9;
		 public static String esercizio2 = "/Kruskal/views/scena8.fxml";
//		 public static Integer scena9_K = 10;
//		 public static String domanda1 = "/Kruskal/views/scena9.fxml";
//		 public static Integer scena10_K = 11;
//		 public static String domanda2 = "/Kruskal/views/scena10.fxml";
//		 public static Integer scena11_K = 12;
//		 public static String verofalso = "/Kruskal/views/scena11.fxml";
//		 public static Integer scena4b_K = 13;
//		 public static String ripasso = "/Kruskal/views/scena4bis.fxml";
		 
		 public static Integer scena10_K = 10;
		 public static String domande = "/Kruskal/views/domande.fxml";
		 public static Integer scena11_K = 11;
		 public static String verofalso = "/Kruskal/views/scena11.fxml";
		 public static Integer scena4b_K = 12;
		 public static String ripasso = "/Kruskal/views/scena4bis.fxml";
	     
	     
	     public sceneController Load(sceneController controller) {
				try {
					
					controller.loadScene(kruskal, kruscene);
					controller.loadScene(scena1_K, minalbero);
					controller.loadScene(scena2_K, intro_K);
					controller.loadScene(scena3_K, costo);
					controller.loadScene(scena4_K, costop2);
					controller.loadScene(scena5_K, parte23);
					controller.loadScene(scena6_K, pseudo);
					controller.loadScene(scena7_K, esercizio1);
					controller.loadScene(scena8_K, esercizio2);
//					controller.loadScene(scena9_K, domanda1);
//					controller.loadScene(scena10_K, domanda2);
					controller.loadScene(scena10_K, domande);
					controller.loadScene(scena11_K, verofalso);
					controller.loadScene(scena4b_K, ripasso);
				
				 
	             controller.setScene(kruskal);
	 
			     return(controller);
				 
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
					return(null);
				}
			
			}
	}
