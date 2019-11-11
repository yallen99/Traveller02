package core.game_engine.objects;

import processing.core.PApplet;
import processing.data.JSONObject;

public class FinishPoint extends Platform {
    ObjectTags tag = ObjectTags.FINISH;

    public FinishPoint(PApplet p,int x,int y) {
        super(p,x,y);
        updatePosition();
    }

    @Override
    public void updatePosition() {
        parent.fill(71, 217, 199);
        parent.rectMode(parent.CENTER);
        parent.noStroke();
        parent.rect(x, y, 50, 50);
    }
    @Override
    public ObjectTags GetTag() {
        return tag;
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
