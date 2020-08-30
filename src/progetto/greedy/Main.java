package progetto.greedy;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {


		try {

			primaryStage.setTitle("AlgaT: il Greedy");
			progettoController progetto = new progettoController();
			progetto.load();
			progetto.start(primaryStage);
			

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
