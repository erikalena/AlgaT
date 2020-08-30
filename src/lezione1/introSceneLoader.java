package lezione1;

import model.sceneController;

public class introSceneLoader{


	public static Integer intro = 1;
	public static String introScene = "/lezione1/1_1.fxml";
	public static Integer proprieta = 2;
	public static String proprietaScene = "/lezione1/1_2.fxml";
	public static Integer esempio = 3;
	public static String esempioScene = "/lezione1/1_3.fxml";
	public static Integer gioco = 4;
	public static String giocoScene = "/lezione1/esempio.fxml";
	public static Integer end = 5;
	public static String endScene = "/lezione1/1_5.fxml";
	public static Integer esercizi = 6;
	public static String eserciziScene = "/lezione1/domande.fxml";



	public sceneController Load(sceneController controller) throws Exception {

		controller.loadScene(intro, introScene);
		controller.loadScene(proprieta, proprietaScene);
		controller.loadScene(esempio, esempioScene);
		controller.loadScene(gioco, giocoScene);
		controller.loadScene(end, endScene);
		controller.loadScene(esercizi, eserciziScene);

		controller.setScene(intro);

		return controller;

	}

}
