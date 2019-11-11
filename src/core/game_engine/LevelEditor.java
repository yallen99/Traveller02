package core.game_engine;

import core.game_engine.data_management.DataManager;
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
    private boolean saving = false;

    DataManager dataManager;

    public LevelEditor(PApplet p){
        this.parent = p;
        optionSelector = new OptionSelector(parent);
        objectsOnScreen = new ArrayList<GameObject>();
    }

    public void snapObject(float x,float y) {
       // System.out.println(objectsOnScreen.size());
        dataManager = new DataManager(parent);


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
                    optionSelector.PlayerMessageHidden();
                }

            } else if (optionSelector.SelectorManager() == 2 && player != null) {
                optionSelector.PLayerMessageDisplayed();
            }

            //create finish Point
            if (parent.mousePressed && optionSelector.SelectorManager() == 3 && finishPoint == null) {
                if (isGridEmpty(roundedX, roundedY)) {
                    finishPoint = new FinishPoint(parent, roundedX, roundedY);
                    objectsOnScreen.add(finishPoint);
                    optionSelector.FinishMessageHidden();

                }
            } else if (optionSelector.SelectorManager() == 3 && finishPoint != null) {
              optionSelector.FinishMessageDisplayed();
            }

            //create key
            if (parent.mousePressed && optionSelector.SelectorManager() == 4) {
                if (isGridEmpty(roundedX, roundedY)) {
                    Key key = new Key(parent, roundedX, roundedY);
                    objectsOnScreen.add(key);
                }
            }
        }
        updateCanvas();
    }

    private void updateCanvas(){

    }
    public void DisplaySaveLevel(){
        if(optionSelector.KeyCheck() == 10){
            saving = true;
            DisplayLevelSlotOptions();
        }
    }
    public boolean IsSaving(){
        return saving;
    }

    public void SaveOnSlot(){
        if(parent.keyCode == 88 && saving){
            dataManager.saveGameObjects(objectsOnScreen, "Level 2");
            DisplayLevelSavedMessage();
            saving = false;
        }
        else if(parent.keyCode == 89 && saving){
            dataManager.saveGameObjects(objectsOnScreen, "Level 3");
            DisplayLevelSavedMessage();
            saving = false;
        }
    }

    private void DisplayLevelSlotOptions(){
        parent.background(0);
        parent.fill(255,200,101);
        parent.noStroke();
        parent.rectMode(parent.CENTER);
        parent.rect(400,400,600,200);
        parent.fill(0);
        parent.textSize(30);
        parent.text(" Click X to save on Slot 1 \n Click Y to save on Slot 2",170, 420);
        parent.fill(0);
        parent.textSize(40);
        parent.text(" SAVE LEVEL",250, 360);

    }
    private void DisplayLevelSavedMessage(){
        parent.fill(255,200,101);
        parent.noStroke();
        parent.rectMode(parent.CENTER);
        parent.rect(400,400,600,200);
        parent.fill(0);
        parent.textSize(50);
        parent.text(" LEVEL SAVED ",230, 410);
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

    public void removeObject(GameObject otherObject){
        objectsOnScreen.remove(otherObject);
    }

}
