package Prim.views;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.annotation.Resource;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;

public class alertWindow {

    
     protected void createAlert(AlertType type, Integer line, String title) throws FileNotFoundException {     //crea un alertBox prendendo in input
    	 try {		                                                                                           //la riga del file di testo dal quale deve leggere
    	String message = findMessage(line);                                                                    //che trova chiamando la funzione findMessage
        Alert avviso = new Alert(type, message);
        avviso.initModality(Modality.APPLICATION_MODAL);
       
        DialogPane dp = avviso.getDialogPane();
        dp.getStylesheets().add(getClass().getResource("/stylesheets/application.css").toExternalForm());
        if(avviso.getAlertType() == AlertType.WARNING) dp.getStyleClass().add("alertWarn");
        if(avviso.getAlertType() == AlertType.INFORMATION) dp.getStyleClass().add("alertInfo");
        avviso.setTitle(title);
		avviso.showAndWait();
    	 } catch(Exception e) {
    		 System.out.println(e.getMessage());
    	 }
    }

     public String findMessage(Integer line) throws IOException {
    	 String message = new String();
         try {	
           InputStream input = Resource.class.getResourceAsStream("/avvisi.txt");
   		    Scanner scanner = new Scanner (input);
 
 			while(line > 0) {
 				message = scanner.nextLine();
 				line = line-1;
 			   }
 			 	 scanner.close();
 		    } catch(Exception e) {
 	        System.out.println("Unable to open file 'avvisi.txt'");                
 	        }
         return(message);
     }    
     
}
