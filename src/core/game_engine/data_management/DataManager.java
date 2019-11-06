package core.game_engine.data_management;

import core.game_engine.GameObject;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

import java.util.ArrayList;

public class DataManager {
    PApplet parent;

    public DataManager(PApplet p) {
        parent = p;
    }

    public JSONObject levelData;
    private String loadLevelFile = "levels.json";
    private String dataFolder = "DataFolder/";

    //load json file
    public void loadLevelFile() {
        levelData = parent.loadJSONObject(dataFolder + loadLevelFile);
    }

    //save json file
    public void saveGameObjects(ArrayList<GameObject> jsonPlatformList, String nameOfList) {
        loadLevelFile();
        JSONArray newList = new JSONArray();
        for (Serializable serialJson : jsonPlatformList) {
            newList.append(serialJson.serializeToJSON());
        }
        levelData.setJSONArray(nameOfList, newList);
        parent.saveJSONObject(this.levelData, dataFolder + loadLevelFile);
    }

}
