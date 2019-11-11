package core.game_engine.objects;
import core.game_engine.GameObject;
import processing.core.PApplet;
import processing.data.JSONObject;

public class Key extends GameObject {
    ObjectTags tag = ObjectTags.COLLECTABLE;
    public Key(PApplet p,int x,int y) {
        super(p,x,y);
    }


    @Override
    public void nameEntity() {
        System.out.println("I am a KEY");
    }

    @Override
    public void updatePosition() {
        parent.fill(88, 61, 140);
        parent.noStroke();
        parent.rectMode(PApplet.CENTER);
        parent.rect(x,y,25,25);
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
