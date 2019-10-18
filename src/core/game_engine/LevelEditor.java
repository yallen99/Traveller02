package core.game_engine;

import processing.core.PApplet;

public class LevelEditor {

    private PApplet parent;
    private OptionSelector optionSelector;
    private ObjectManager objectManager;
    private Player player;


    public LevelEditor(PApplet p){
        this.parent = p;
        optionSelector = new OptionSelector(parent);
        objectManager = new ObjectManager(parent);
    }

    public void initializeGame(){
        GameObject[] allObjects = new GameObject[3];

        Platform platform = new Platform(parent);
        platform.createObject(100,100);
        Platform platform2 = new Platform(parent);
        platform.createObject(400,400);
        player = new Player(parent);
        player.createObject(200,200);

        allObjects[0]=platform;
        allObjects[1]=platform2;
        allObjects[2]=player;


        for (GameObject gameObject : allObjects){
            gameObject.nameEntity();
        }
    }



}
