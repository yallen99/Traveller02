package core.game_engine;
import processing.core.PApplet;

public abstract class GameObject {
    public PApplet parent;
    protected int x;
    protected int y;

    public GameObject(PApplet p,int x,int y){
        parent = p;
        this.x = x;
        this.y = y;
        createObject();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public abstract void createObject();
    public abstract  void nameEntity();
}
