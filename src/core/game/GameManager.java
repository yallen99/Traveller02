package core.game;

import processing.core.PApplet;

public class GameManager {
    PApplet parent;
    public GameManager(PApplet p){ parent = p; }

    SceneManager sceneManager;

    public void start(){
        sceneManager = new SceneManager(parent);
        parent.background(0);
    }

    public void update(){
        if(sceneManager.ActiveScene() == 2 || sceneManager.ActiveScene() == 3 || sceneManager.ActiveScene() == 4){
            Blackout();
        }
    }

    private void Blackout(){
        parent.fill(0);
        parent.rect(0,0,900,900);
    }


}