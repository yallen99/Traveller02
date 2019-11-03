package core.game_engine.objects;
import core.game_engine.GameObject;
import processing.core.PApplet;

public class Key extends GameObject {
    ObjectTags tag = ObjectTags.COLLECTABLE;
    public Key(PApplet p,int x,int y) {
        super(p,x,y);
    }

    @Override
    public void createObject() {
        parent.fill(235, 136, 209);
        parent.noStroke();
        parent.rectMode(PApplet.CENTER);
        parent.rect(x,y,25,25);
        nameEntity();
    }

    @Override
    public void nameEntity() {
        System.out.println("I am a KEY");
    }
}
