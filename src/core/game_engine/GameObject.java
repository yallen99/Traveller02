package core.game_engine;
import core.game_engine.data_management.Serializable;
import core.game_engine.objects.ObjectTags;
import processing.core.PApplet;
import processing.core.PVector;
import processing.data.JSONObject;

public abstract class GameObject implements Serializable {
    public PApplet parent;
    Point point;
    Point topLeft, topRight, bottomLeft, bottomRight;
    protected int x;
    protected int y;



    public GameObject(PApplet p, int x, int y) {
        parent = p;
        this.x = x;
        this.y = y;
       getPoints();
    }

    public Point getPoint() {
        return point;
    }

    protected void getPoints(){
        point = new Point(x,y);
        topLeft = new Point(x-25, y-25);
        topRight = new Point(x+25, y-25);
        bottomLeft = new Point(x-25, y+25);
        bottomRight = new Point(x+25, y+25);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Point getTopLeft() {
        return topLeft;
    }
    public Point getTopRight() {
        return topRight;
    }
    public Point getBottomLeft() {
        return bottomLeft;
    }
    public Point getBottomRight() {
        return bottomRight;
    }

    public abstract void nameEntity();
    public abstract void updatePosition();
    public abstract ObjectTags GetTag();
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
