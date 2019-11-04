package core.game;

import core.game_engine.GameObject;
import core.game_engine.OptionSelector;
import core.game_engine.data_management.DataManager;
import core.game_engine.objects.FinishPoint;
import core.game_engine.objects.Key;
import core.game_engine.objects.Platform;
import core.game_engine.objects.Player;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

import java.util.ArrayList;

public class GameManager {
    PApplet parent;
    public GameManager(PApplet p){ parent = p; }

    OptionSelector optionSelector;
    SceneManager sceneManager;
    DataManager dataManager;
    ArrayList<GameObject> loadedObjects;
    String itemType = "Platform";

    public void start(){
        optionSelector = new OptionSelector(parent);
        sceneManager = new SceneManager(parent);
        dataManager = new DataManager(parent);
        parent.background(0);
    }

    public void updateMenu(){

            optionSelector.CreatorUI();
    }

    public void updateLevel(){

        dataManager.loadLevelFile();
        CreateLevelLayout();
        loadLevelObjects("Level 1");
        System.out.println(dataManager.levelData);
    }

    private void CreateLevelLayout(){
        parent.fill(0);
        parent.rect(0,0,900,900);
    }

    public void loadLevelObjects(String listName){
        loadedObjects = new ArrayList();
        if(dataManager.levelData != null){
        JSONArray levelObjectsArray = dataManager.levelData.getJSONArray(listName);
        for(int i = 0; i < levelObjectsArray.size(); i++){

            JSONObject objectData =(JSONObject)levelObjectsArray.get(i);
            itemType = objectData.getString("tag");
            add_object(objectData.getInt("x")
                       ,objectData.getInt("y"));
        }
    }
    //    System.out.println("LEVEL LOADED");

    }

    private GameObject add_object(int x, int y){
        GameObject gameObject = null;
        if ("PLATFORM".equals(itemType)) {
            Platform gamePlatform = new Platform(this.parent, x, y);
            loadedObjects.add(gamePlatform);
            gameObject = gamePlatform;
        } else if ("COLLECTABLE".equals(itemType)) {
            Key key = new Key(this.parent, x, y);
            loadedObjects.add(key);
            gameObject = key;
        } else if ("PLAYER".equals(itemType)) {
            Player player = new Player(this.parent, x, y);
            loadedObjects.add(player);
            gameObject = player;
        }
        else if ("FINISH".equals(itemType)) {
            FinishPoint finish = new FinishPoint(this.parent, x, y);
            loadedObjects.add(finish);
            gameObject = finish;
        }
        return gameObject;
    }
}

