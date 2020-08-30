package intro_KP.model;

import model.sceneController;

//loader per il caricamento delle scene nel sceneController dell'introduzione agli algoritmi

public class introLoad {

	public static Integer introI = 1;
	public static String firstIntro = "/intro_KP/views/introduzione.fxml";
	public static Integer introII = 2;
	public static String secondIntro = "/intro_KP/views/introduzione2.fxml";
	public static Integer introIII = 3;
	public static String thirdIntro = "/intro_KP/views/introduzione3.fxml";
	public static Integer introIV = 4;
	public static String fourthIntro = "/intro_KP/views/introduzione4.fxml";
	
	

	public sceneController Load(sceneController main) {		
		try {
		main.loadScene(introI, firstIntro);
		main.loadScene(introII, secondIntro);
		main.loadScene(introIII, thirdIntro);
		main.loadScene(introIV, fourthIntro);
        main.setScene(introI);
        
	     return(main);
		 
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return(null);
		}
	
	}
	 

}
