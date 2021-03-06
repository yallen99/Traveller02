package core.game;

import core.game_engine.GameObject;
import core.OptionSelector;
import core.game_engine.PlayerController;
import core.game_engine.data_management.DataManager;
import core.game_engine.objects.*;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

import java.util.ArrayList;


public class GameManager {
    PApplet parent;
    public GameManager(PApplet p){ parent = p;
    playerController = new PlayerController(parent);}

    OptionSelector optionSelector;
    SceneManager sceneManager;
    DataManager dataManager;
    ArrayList<GameObject> loadedObjects;
    ArrayList<GameObject> collectables;
    JSONArray levelObjectsArray;
    String itemType = "Platform";
    private Player player;
    PlayerController playerController;

    private boolean level1 = false;
    private boolean level2 = false;
    private boolean level3 = false;
    private boolean activeFinishPoint = false;
    private boolean levelFinished = false;


    public void start(){
        optionSelector = new OptionSelector(parent);
        sceneManager = new SceneManager(parent);
        dataManager = new DataManager(parent);
        parent.background(0);
    }
    private void CreateLevelLayout(){
        parent.fill(0);
        parent.rect(0,0,900,900);
    }
    public void loadLevelObjects(String listName){
        collectables = new ArrayList<GameObject>();
        loadedObjects = new ArrayList();
        if(dataManager.levelData != null){
            levelObjectsArray = dataManager.levelData.getJSONArray(listName);
            for(int i = 0; i < levelObjectsArray.size(); i++){

                JSONObject objectData =(JSONObject)levelObjectsArray.get(i);
                itemType = objectData.getString("tag");
                addObject(objectData.getInt("x")
                        ,objectData.getInt("y"));
            }
        }
    }
    private GameObject addObject(int x, int y){
        GameObject gameObject = null;
        if ("PLATFORM".equals(itemType)) {
            Platform gamePlatform = new Platform(this.parent, x, y);
            loadedObjects.add(gamePlatform);
            gameObject = gamePlatform;
        } else if ("COLLECTABLE".equals(itemType)) {
            Key key = new Key(this.parent, x, y);
            loadedObjects.add(key);
            collectables.add(key);
            gameObject = key;
        } else if ("PLAYER".equals(itemType)) {
            Player player = new Player(this.parent, x, y);
            this.player = player;
            loadedObjects.add(player);
            playerController.addPlayer(player);
            gameObject = player;
        }
        else if ("FINISH".equals(itemType)) {
            FinishPoint finish = new FinishPoint(this.parent, x, y);
            loadedObjects.add(finish);
            gameObject = finish;
        }
        return gameObject;
    }

    private void CheckForCollectables() {
        if (collectables.size() == 0) {
            activeFinishPoint = true;
        }
    }

    private void CheckLevelCollisions() {
        player.startOfLoop();
        for (int i = 0; i < loadedObjects.size(); i++) {
            GameObject gameObject = loadedObjects.get(i);
            if (gameObject.GetTag() == ObjectTags.PLAYER) {
                return;
            }

            //platform collision check
            if (gameObject.GetTag() == ObjectTags.PLATFORM) {
                player.CollisionUp(gameObject);
                player.CollisionDown(gameObject);
                player.CollisionLeft(gameObject);
                player.CollisionRight(gameObject);
            }
            player.CheckSpecialTileCollision(gameObject);

            //key collision
            if (player.CheckSpecialTileCollision(gameObject) && gameObject.GetTag() == ObjectTags.COLLECTABLE) {
                collectables.remove(gameObject);
                loadedObjects.remove(gameObject);
                System.out.println(collectables.size());

            }
            //finish point collision
            if (player.CheckSpecialTileCollision(gameObject) && activeFinishPoint && gameObject.GetTag() == ObjectTags.FINISH) {
                levelFinished = true;
            }
        }
    }


    public boolean IsLevelFnished(){
        return levelFinished;
    }

    ///////////////////////////////////// MENU ////////////////////////////////////////
    public void updateMenu(){
            parent.fill(0);
            parent.noStroke();
            parent.rectMode(parent.CORNER);
            parent.rect(0,0, 900,900);
            optionSelector.CreatorUI();
            optionSelector.Title();

            level1 = false; level2 = false; level3 = false; levelFinished = false;
    }

    /////////////////////////////////////// LEVEL 1 ///////////////////////////////////
    public void updateLevel1(){
        if(!level1){
            dataManager.loadLevelFile();
            CreateLevelLayout();
            loadLevelObjects("Level 1");
            level1 = true;
        }
        updateCanvas();
        CheckForCollectables();
        CheckLevelCollisions();
        player.CheckNewPlatformsCollision();
        displayK();
        if(player.Blocked()){
            optionSelector.GameOverScene();
        }
    }

    ///////////////////////////////////// LEVEL 2 /////////////////////////////////////
    public void updateLevel2(){
        //start
        if(!level2){
        dataManager.loadLevelFile();
        CreateLevelLayout();
        loadLevelObjects("Level 2");
        level2 = true;
        }
        //update
        updateCanvas();
        CheckLevelCollisions();
        CheckForCollectables();
        player.CheckNewPlatformsCollision();
displayK();
        if(player.Blocked()){
            optionSelector.GameOverScene();
        }
    }

    //////////////////////////////////// LEVEL 3 /////////////////////////////////////
    public void updateLevel3() {
        if (!level3) {
            dataManager.loadLevelFile();
            CreateLevelLayout();
            loadLevelObjects("Level 3");
            level3 = true;
        }
        updateCanvas();
        CheckForCollectables();
        CheckLevelCollisions();
        player.CheckNewPlatformsCollision();
displayK();
        if(player.Blocked()){
            optionSelector.GameOverScene();
        }
    }

    ///////////////////////////////////// LEVEL SELECTOR //////////////////////////////
    public void updateSelector(){
        dataManager.loadLevelFile();
        parent.background(0);
        CheckForSelectorButtons();
        optionSelector.CreateSelectorUI();
        sceneManager.linkScenes();
    }
    private void CheckForSelectorButtons() {
        parent.fill(242, 233, 189);
        parent.noStroke();
        if (dataManager.levelData.hasKey("Level 2") && dataManager.levelData.getJSONArray("Level 2").size() >= 1) {
            parent.fill(242, 233, 189);
            parent.noStroke();
            parent.rect(150, 300, 200, 150);
            parent.textSize(40);
            parent.fill(0);
            parent.text("Level 2", 165, 340);
            parent.textSize(30);
            parent.text("click 2 \nto play", 165, 380);

            //Additional text
            parent.fill(0);
            parent.strokeWeight(5);
            parent.stroke(242,182,160);
            parent.rectMode(parent.CORNER);
            parent.rect(410, 300, 300, 150);
            parent.fill(242, 233, 189);
            parent.textSize(20);
            parent.text("You can rewrite this level \nby creating a new one \nand saving it on 1st slot", 425, 345);

        }
        if (dataManager.levelData.hasKey("Level 3") && dataManager.levelData.getJSONArray("Level 3").size() >= 1) {
            parent.fill(242, 233, 189);
            parent.noStroke();
            parent.rect(150, 500, 200, 150);
            parent.textSize(40);
            parent.fill(0);
            parent.text("Level 3", 165, 540);
            parent.textSize(30);
            parent.text("click 3 \nto play", 165, 580);

            //Additional text
            parent.fill(0);
            parent.strokeWeight(5);
            parent.stroke(242,182,160);
            parent.rectMode(parent.CORNER);
            parent.rect(410, 500, 300, 150);
            parent.fill(242, 233, 189);
            parent.textSize(20);
            parent.text("You can rewrite this level \nby creating a new one \nand saving it on 2nd slot", 425, 545);
        }
    }
    public void checkInput() {
        playerController.checkInput();
    }
    private void updateCanvas() {
        for(GameObject gameObject : loadedObjects){
            gameObject.updatePosition();
        }
    }

    //UI - couldn't be added to option selector cause it's linked to collectables array
    private void displayK(){
        parent.fill(0);
        parent.noStroke();
        parent.rectMode(parent.CORNER);
        parent.rect(0,650,800,100);

        optionSelector.instructions();
        parent.fill(255, 200, 101);
        parent.noStroke();
        parent.textSize(20);
        parent.text(collectables.size(), 100,700);
        parent.text("Keys to collect  ->", 120, 700);
        parent.fill(88, 61, 140);
        parent.noStroke();
        parent.rectMode(parent.CORNER);
        parent.rect(300,680,25,25);


        if(collectables.size() <=0){
            parent.fill(255, 200, 101);
            parent.noStroke();
            parent.textSize(20);
            parent.text("Proceed to   ->", 120, 750);
            parent.fill(71, 217, 199);
            parent.noStroke();
            parent.rectMode(parent.CORNER);
            parent.rect(270,725,25,25);
        }
    }
}

