package core.game_engine.objects;

import processing.core.PApplet;
import processing.data.JSONObject;

public class FinishPoint extends Platform {
    ObjectTags tag = ObjectTags.FINISH;

    public FinishPoint(PApplet p,int x,int y) {
        super(p,x,y);
    }
    @Override
    public void createObject(){
        parent.fill(255, 184, 64);
        parent.rectMode(parent.CENTER);
        parent.noStroke();
        parent.rect(x, y, 50, 50);
        nameEntity();
    }
    @Override
    public void nameEntity(){
        System.out.println("Finish point");
    }
    @Override
    public JSONObject serializeToJSON(){
        JSONObject gameObjectData = super.serializeToJSON();
        gameObjectData.setString("tag", tag.toString());
        return gameObjectData;
    }
}
