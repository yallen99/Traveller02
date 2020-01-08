package core.game_engine;

import core.OptionSelector;
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
            if (optionSelector.SelectorManager() == 2 && player == null) {
                    optionSelector.PlayerWarningMessage(255, 0,0);
                if (isGridEmpty(roundedX, roundedY) && parent.mousePressed) {
                    player = new Player(parent, roundedX, roundedY);
                    objectsOnScreen.add(player);

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
    }

    public void DisplaySaveLevel(){
        if(optionSelector.KeyCheck() == 10){
            saving = true;
            optionSelector.DisplayLevelSlotOptions();
        }
    }
    public boolean IsSaving(){
        return saving;
    }

    public void SaveOnSlot(){
        if(parent.keyCode == 88 && saving){
            dataManager.saveGameObjects(objectsOnScreen, "Level 2");
            optionSelector.DisplayLevelSavedMessage();
            saving = false;

        }
        else if(parent.keyCode == 89 && saving){
            dataManager.saveGameObjects(objectsOnScreen, "Level 3");
            optionSelector.DisplayLevelSavedMessage();
            saving = false;

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
