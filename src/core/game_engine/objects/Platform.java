package core.game_engine.objects;

import core.game_engine.GameObject;
import processing.core.PApplet;
import processing.data.JSONObject;

public class Platform extends GameObject {
    ObjectTags tag = ObjectTags.PLATFORM;
    public Platform(PApplet p,int x,int y) {
        super(p,x,y);
        updatePosition();
    }

    @Override
    public void nameEntity() {
//Naming Objects to test @Override
    }

    @Override
    public void updatePosition() {
        parent.fill(64, 29, 9);
        parent.rectMode(parent.CENTER);
        parent.noStroke();
        parent.rect(x, y, 50, 50);
    }
    @Override
    public ObjectTags GetTag() {
        return tag;
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
