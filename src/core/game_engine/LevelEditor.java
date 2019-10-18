package core.game_engine;

import processing.core.PApplet;

public class LevelEditor {

    private PApplet parent;
    private OptionSelector optionSelector;
    private ObjectManager objectManager;
    private Player player;
    private FinishPoint finishPoint;


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

    public void snapObject(float x,float y){
        int roundedX = parent.round(x/50)*50;
        int roundedY = parent.round(y/50)*50;
        if(roundedX>25 && roundedX<775 &&
                roundedY>25 && roundedY<725) {
            if (parent.mousePressed && optionSelector.SelectorManager() == 1) {
                 Platform platform = new Platform(parent);
                 platform.createObject(roundedX,roundedY);
            }

            if(parent.mousePressed && optionSelector.SelectorManager() == 2 && player==null) {
                     player = new Player(parent);
                     player.createObject(roundedX,roundedY);

            }else if(optionSelector.SelectorManager() == 2 && player!=null){
                System.out.println("THERE IS ALREADY A PLAYER IN THE SCENE!");
            }

            //create finish Point
            if(parent.mousePressed && optionSelector.SelectorManager() == 3 && finishPoint==null){
                finishPoint = new FinishPoint(parent);
                finishPoint.createObject(roundedX,roundedY);
            }
            else if(parent.mousePressed && optionSelector.SelectorManager() == 3 && finishPoint!=null){
                System.out.println("THERE IS ALREADY A FINISH POINT IN THE SCENE!");
            }

            }
        }



}
