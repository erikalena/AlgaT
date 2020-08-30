package model;

import model.sceneController;

public interface ISceneController {
	
    //Questo metodo serve a creare una gerarchia nel sceneController, così che i singoli controller facciano tutti riferimento a uno stesso sceneController Parent
	    public void setSceneParent(sceneController sceneParent);
	    
}
