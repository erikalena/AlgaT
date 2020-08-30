package lezione1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.sceneController;

import java.util.Random;


public class esempioController implements model.ISceneController{

    sceneController sc;
    int[] values = new int[]{1,5,10,20,50,100,500};
    int[] labelCounters = new int[]{0,0,0,0,0,0,0};
    int[] correctCounters = new int[]{0,0,0,0,0,0,0};

    @FXML
    Button continua;

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
    private Pane money1;
    @FXML
    private Pane money5;
    @FXML
    private Pane money10;
    @FXML
    private Pane money20;
    @FXML
    private Pane money50;
    @FXML
    private Pane money100;
    @FXML
    private Pane money500;


    Pane[] MoneyList;
    int importo;

    void startGame(){

        MoneyList = new Pane[]{money1, money5, money10, money20, money50, money100, money500};

        for(int i=0; i<7; i++){
            labelCounters[i] = 0;
            correctCounters[i] = 0;
        }

        continua.setVisible(false);

        Random r = new Random();
        importo = r.nextInt((5000 - 1000) + 1) + 1000;

        int i = 6;
        int tempImporto = importo;

        while(tempImporto > 0){
            if(tempImporto >= values[i]) {
                tempImporto -= values[i];
                correctCounters[6 - i]++;
            } else {
                i--;
            }
        }

        imp.setText(Integer.toString(importo));
        updateLabels();
        disablePanes(calcolaCorrente(importo));


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
        disablePanes(calcolaCorrente(importo));
    }

    void disablePanes (int n){
        for(int i = 0; i < MoneyList.length; i++)
            MoneyList[i].setDisable(true);

        MoneyList[n].setDisable(false);
    }

    int calcolaCorrente(int n){
        int ix = 6;

        while(values[ix] > n && ix>0){
            ix--;
        }
        return ix;
    }

    void updateLabels(){
        count1.setText(Integer.toString(labelCounters[0]));
        count5.setText(Integer.toString(labelCounters[1]));
        count10.setText(Integer.toString(labelCounters[2]));
        count20.setText(Integer.toString(labelCounters[3]));
        count50.setText(Integer.toString(labelCounters[4]));
        count100.setText(Integer.toString(labelCounters[5]));
        count500.setText(Integer.toString(labelCounters[6]));
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
        } else{
            continua.setVisible(true);
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
    void nextPage(ActionEvent event){
        sc.goNext();
    }

    @FXML
    void goBack(ActionEvent event){
        sc.goBack();
    }


    @Override
    public void setSceneParent(sceneController sceneParent) {
        sc = sceneParent;
    }
}
