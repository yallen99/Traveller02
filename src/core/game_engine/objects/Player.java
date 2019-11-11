package core.game_engine.objects;

import core.game_engine.GameObject;
import core.game_engine.Movable;
import processing.core.PApplet;
import processing.data.JSONObject;

public class Player extends GameObject implements Movable {
    ObjectTags tag = ObjectTags.PLAYER;
    public Player(PApplet p,int x,int y) {
        super(p,x,y);
        updatePosition();
    }

    @Override
    public void nameEntity() {
        System.out.println("Player");
    }

    @Override
    public void updatePosition() {
        parent.fill(255, 200, 101);
        parent.noStroke();
        parent.ellipse(x, y, 25, 25);
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

    @Override
    public void moveUp() {
        y-=50;
    }

    @Override
    public void moveDown() {
        y+=50;
    }

    @Override
    public void moveRight() {
        x+=50;
    }

    @Override
    public void moveLeft() {
        x-=50;
    }
}
