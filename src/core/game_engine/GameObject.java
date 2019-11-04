package core.game_engine;
import core.game_engine.data_management.Serializable;
import core.game_engine.objects.Platform;
import processing.core.PApplet;
import processing.data.JSONObject;

public abstract class GameObject implements Serializable {
    public PApplet parent;
    protected int x;
    protected int y;

    public GameObject(PApplet p, int x, int y) {
        parent = p;
        this.x = x;
        this.y = y;
        createObject();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void createObject();

    public abstract void nameEntity();

    public void coverMe() {
        parent.fill(0);
        parent.rectMode(parent.CENTER);
        parent.noStroke();
        parent.rect(x, y, 50, 50);
    }

    @Override
    public JSONObject serializeToJSON() {
        JSONObject gameObjectData = new JSONObject();
        gameObjectData.setInt("x", x);
        gameObjectData.setInt("y", y);
        return gameObjectData;
    }

}
