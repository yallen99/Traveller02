package core.game_engine.objects;

import core.game_engine.GameObject;
import processing.core.PApplet;
import processing.data.JSONObject;

public class Player extends GameObject {
    ObjectTags tag = ObjectTags.PLAYER;
    public Player(PApplet p,int x,int y) {
        super(p,x,y);
    }

    @Override
    public void createObject() {
        parent.fill(255, 200, 101);
        parent.noStroke();
        parent.ellipse(x, y, 25, 25);
    }

    @Override
    public void nameEntity() {
        System.out.println("Player");
    }

    @Override
    public void loadJSONObject(JSONObject json) {

    }
    @Override
    public JSONObject serializeToJSON(){
        JSONObject gameObjectData = super.serializeToJSON();
        gameObjectData.setString("tag", tag.toString());
        return gameObjectData;
    }
}
