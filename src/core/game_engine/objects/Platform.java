package core.game_engine.objects;

import core.game_engine.GameObject;
import core.game_engine.data_management.Serializable;
import processing.core.PApplet;
import processing.data.JSONObject;

public class Platform extends GameObject {
    ObjectTags tag = ObjectTags.PLATFORM;
    public Platform(PApplet p,int x,int y) {
        super(p,x,y);
    }

    @Override
    public void createObject() {
        parent.fill(64, 29, 9);
        parent.rectMode(parent.CENTER);
        parent.noStroke();
        parent.rect(x, y, 50, 50);
    }

    @Override
    public void nameEntity() {
    }

    @Override
    public JSONObject serializeToJSON(){
        JSONObject gameObjectData = super.serializeToJSON();
        gameObjectData.setString("tag", tag.toString());
        return gameObjectData;
    }

    @Override
    public void loadJSONObject(JSONObject json) {

    }
}
