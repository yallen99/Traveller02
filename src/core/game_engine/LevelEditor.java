package core.game_engine;

import core.game_engine.objects.FinishPoint;
import core.game_engine.objects.Key;
import core.game_engine.objects.Platform;
import core.game_engine.objects.Player;
import processing.core.PApplet;

import java.util.ArrayList;

public class LevelEditor {

    private PApplet parent;
    private OptionSelector optionSelector;
    private Player player;
    private FinishPoint finishPoint;
    private ArrayList<GameObject> objectsOnScreen;
    private boolean clearing = false;

    public LevelEditor(PApplet p){
        this.parent = p;
        optionSelector = new OptionSelector(parent);
        objectsOnScreen = new ArrayList<GameObject>();
    }

//    public void initializeGame(){
//        GameObject[] allObjects = new GameObject[3];
//
//        Platform platform = new Platform(parent);
//        platform.createObject(100,100);
//        Platform platform2 = new Platform(parent);
//        platform.createObject(400,400);
//        player = new Player(parent);
//        player.createObject(200,200);
//
//        allObjects[0]=platform;
//        allObjects[1]=platform2;
//        allObjects[2]=player;
//
//
//        for (GameObject gameObject : allObjects){
//            gameObject.nameEntity();
//        }
//    }

    public void snapObject(float x,float y) {
       // System.out.println(objectsOnScreen.size());


        int roundedX = PApplet.round(x / 50) * 50;
        int roundedY = PApplet.round(y / 50) * 50;

        if (roundedX > 25 && roundedX < 775 && roundedY > 25 && roundedY < 725) {

            //create platform
            if (parent.mousePressed && optionSelector.SelectorManager() == 1) {
                if (isGridEmpty(roundedX, roundedY)) {
                    Platform platform = new Platform(parent, roundedX, roundedY);
                    objectsOnScreen.add(platform);

                }
            }

            //create player
            if (parent.mousePressed && optionSelector.SelectorManager() == 2 && player == null) {
                if (isGridEmpty(roundedX, roundedY)) {
                    player = new Player(parent, roundedX, roundedY);
                    objectsOnScreen.add(player);

                }

            } else if (optionSelector.SelectorManager() == 2 && player != null) {
                System.out.println("THERE IS ALREADY A PLAYER IN THE SCENE!");
            }

            //create finish Point
            if (parent.mousePressed && optionSelector.SelectorManager() == 3 && finishPoint == null) {
                if (isGridEmpty(roundedX, roundedY)) {
                    finishPoint = new FinishPoint(parent, roundedX, roundedY);
                    objectsOnScreen.add(finishPoint);

                }
            } else if (parent.mousePressed && optionSelector.SelectorManager() == 3 && finishPoint != null) {
                System.out.println("THERE IS ALREADY A FINISH POINT IN THE SCENE!");
            }

            //create key
            if (parent.mousePressed && optionSelector.SelectorManager() == 4) {
                if (isGridEmpty(roundedX, roundedY)) {
                    Key key = new Key(parent, roundedX, roundedY);
                    objectsOnScreen.add(key);
                }
            }
        }
    }

    private boolean isGridEmpty(int x,int y) {
        for(GameObject gameObject : objectsOnScreen){
            if(gameObject.getX() == x && gameObject.getY() == y){
                System.out.println("Object on screeennnn!!!!");
                return false;
            }
        }
        return true;
    }
    private boolean isObjectOnScreen(){
        for(GameObject gameObject : objectsOnScreen){
            if(objectsOnScreen.size()>=1){
                return true;
            }
        }
        return false;
    }

    public void ClearLastObject(){
        if (optionSelector.SelectorManager() == 5 && isObjectOnScreen()) {
                if(!clearing && parent.keyCode == 90) {
                    GameObject toRemove = objectsOnScreen.get(objectsOnScreen.size() - 1);
                    toRemove.coverMe();
                    objectsOnScreen.remove(toRemove);
                    if(toRemove == player){
                        toRemove.coverMe();
                        objectsOnScreen.remove(toRemove);
                        player = null;
                    }
                    if(toRemove == finishPoint){
                        toRemove.coverMe();
                        objectsOnScreen.remove(toRemove);
                        finishPoint = null;
                    }
                clearing = true;
                }
        }
        if(parent.keyCode == 17){
            clearing = false;
        }
    }
}
