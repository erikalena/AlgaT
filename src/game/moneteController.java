package game;

import java.io.IOException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import model.ISceneController;
import model.sceneController;

public class moneteController implements ISceneController {

    int[] values = new int[]{1,5,10,20,50,100,500};
    int[] labelCounters = new int[]{0,0,0,0,0,0,0};
    int[] correctCounters = new int[]{0,0,0,0,0,0,0};
    sceneController sc;

    @FXML
    Button riprova;
    @FXML
    Label esito;

    @FXML
    Label count1;
    @FXML
    Label count5;
    @FXML
    Label count10;
    @FXML
    Label count20;
    @FXML
    Label count50;
    @FXML
    Label count100;
    @FXML
    Label count500;
    @FXML
    Label imp;

    @FXML
    private Label correct1;
    @FXML
    private Label correct5;
    @FXML
    private Label correct10;
    @FXML
    private Label correct20;
    @FXML
    private Label correct50;
    @FXML
    private Label correct100;
    @FXML
    private Label correct500;


    int importo;

    void startGame(){
        //Azzeramento contatori
        for(int i=0; i<7; i++){
            labelCounters[i] = 0;
            correctCounters[i] = 0;
        }

        riprova.setVisible(false);

        Random r = new Random();
        importo = r.nextInt((5000 - 1000) + 1) + 1000;

        int i = 6;
        int tempImporto = importo;

        //Calcolo soluzione greedy
        while(tempImporto > 0){
            if(tempImporto >= values[i]) {
                tempImporto -= values[i];
                correctCounters[6 - i]++;
            } else {
                i--;
            }
        }

        setCorrects();

        imp.setText(Integer.toString(importo));
        updateLabels();

    }

    @FXML
    void initialize() {
        startGame();
    }

    @FXML
    void clickMoney(MouseEvent event){
        String name = event.getSource().toString();
        if(name.contains("money100")) {
            moneyClicked(100);
        } else if(name.contains("money500")) {
            moneyClicked(500);
        } else if(name.contains("money10")) {
            moneyClicked(10);
        } else if(name.contains("money20")) {
            moneyClicked(20);
        } else if(name.contains("money50")) {
            moneyClicked(50);
        } else if(name.contains("money1")) {
            moneyClicked(1);
        } else if(name.contains("money5")) {
            moneyClicked(5);
        }
    }

    void setCorrects(){
        correct1.setText(Integer.toString(correctCounters[6]));
        correct5.setText(Integer.toString(correctCounters[5]));
        correct10.setText(Integer.toString(correctCounters[4]));
        correct20.setText(Integer.toString(correctCounters[3]));
        correct50.setText(Integer.toString(correctCounters[2]));
        correct100.setText(Integer.toString(correctCounters[1]));
        correct500.setText(Integer.toString(correctCounters[0]));
    }

    void showCorrects(){
        correct1.setVisible(true);
        correct5.setVisible(true);
        correct10.setVisible(true);
        correct20.setVisible(true);
        correct50.setVisible(true);
        correct100.setVisible(true);
        correct500.setVisible(true);
    }

    void updateLabels(){
        correct1.setVisible(false);
        correct5.setVisible(false);
        correct10.setVisible(false);
        correct20.setVisible(false);
        correct50.setVisible(false);
        correct100.setVisible(false);
        correct500.setVisible(false);
        count1.setText(Integer.toString(labelCounters[0]));
        count5.setText(Integer.toString(labelCounters[1]));
        count10.setText(Integer.toString(labelCounters[2]));
        count20.setText(Integer.toString(labelCounters[3]));
        count50.setText(Integer.toString(labelCounters[4]));
        count100.setText(Integer.toString(labelCounters[5]));
        count500.setText(Integer.toString(labelCounters[6]));
        count1.setStyle("-fx-text-fill: white;");
        count5.setStyle("-fx-text-fill: white;");
        count10.setStyle("-fx-text-fill: white;");
        count20.setStyle("-fx-text-fill: white;");
        count50.setStyle("-fx-text-fill: white;");
        count100.setStyle("-fx-text-fill: white;");
        count500.setStyle("-fx-text-fill: white;");
        esito.setText("");
    }

    void moneyCount(int value){
        switch(value){
            case 1: {
                labelCounters[6]++;
                count1.setText(Integer.toString(labelCounters[6]));
                break;
            }
            case 5: {
                labelCounters[5]++;
                count5.setText(Integer.toString(labelCounters[5]));
                break;
            }
            case 10: {
                labelCounters[4]++;
                count10.setText(Integer.toString(labelCounters[4]));
                break;
            }
            case 20: {
                labelCounters[3]++;
                count20.setText(Integer.toString(labelCounters[3]));
                break;
            }
            case 50: {
                labelCounters[2]++;
                count50.setText(Integer.toString(labelCounters[2]));
                break;
            }
            case 100: {
                labelCounters[1]++;
                count100.setText(Integer.toString(labelCounters[1]));
                break;
            }
            case 500: {
                labelCounters[0]++;
                count500.setText(Integer.toString(labelCounters[0]));
                break;
            }
        }
    }

    void checkCorrect(){
        boolean wrong = false;
        for(int i=0; i<7; i++){
            if(labelCounters[i] != correctCounters[i]){
                wrong = true;
                break;
            }
        }

        if(wrong){
            esito.setText("Sbagliato!!");
            count1.setStyle("-fx-text-fill: red;");
            count5.setStyle("-fx-text-fill: red;");
            count10.setStyle("-fx-text-fill: red;");
            count20.setStyle("-fx-text-fill: red;");
            count50.setStyle("-fx-text-fill: red;");
            count100.setStyle("-fx-text-fill: red;");
            count500.setStyle("-fx-text-fill: red;");
            showCorrects();
            riprova.setVisible(true);
        } else{
            esito.setText("Corretto!");
            count1.setStyle("-fx-text-fill: lightgreen;");
            count5.setStyle("-fx-text-fill: lightgreen;");
            count10.setStyle("-fx-text-fill: lightgreen;");
            count20.setStyle("-fx-text-fill: lightgreen;");
            count50.setStyle("-fx-text-fill: lightgreen;");
            count100.setStyle("-fx-text-fill: lightgreen;");
            count500.setStyle("-fx-text-fill: lightgreen;");
            riprova.setVisible(true);
        }

    }

    void moneyClicked(int value) {
        moneyCount(value);
        importo -= value;
        imp.setText(Integer.toString((importo)));
        if(importo <= 0){
            checkCorrect();
        }
    }

    @FXML
    void openMenu(ActionEvent event) throws IOException {
        sc.goBack();
    }
    @FXML
    void retry(){
        //gioco finito, l'utente preme riprova
        startGame();
    }

    @Override
    public void setSceneParent(sceneController parent) {
        sc = parent;

    }
}
