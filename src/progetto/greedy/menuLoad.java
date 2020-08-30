package progetto.greedy;

import model.sceneController;

//loader per il caricamento delle scene nel sceneController che gestisce il menù

public class menuLoad {
      
	public static Integer presentazione = 1;
	public static String presScene = "/progetto/greedy/presentazione.fxml";
	public static Integer menu = 2;
	public static String menuScene = "/progetto/greedy/menu.fxml";
	public static Integer game = 3;
	public static String gameScene = "/game/monete.fxml";
	public static Integer lezioni = 4;
	public static String lezioniScene = "/progetto/greedy/lezioni.fxml";
	public static Integer algoritmi = 5;
	public static String algoritmiScene = "/progetto/greedy/algoritmi.fxml";


	 public sceneController Load(sceneController controller) {
		 
			try {
             
		     controller.loadScene(presentazione, presScene);		
			 controller.loadScene(menu, menuScene);
			 controller.loadScene(game, gameScene);
			 controller.loadScene(lezioni, lezioniScene);
			 controller.loadScene(algoritmi, algoritmiScene);
			 
             controller.setScene(presentazione);

		     return(controller);
			 
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				return(null);
			}
		
		}


}
