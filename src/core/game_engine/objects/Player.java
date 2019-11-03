package core.game_engine.objects;

import core.game_engine.GameObject;
import processing.core.PApplet;

public class Player extends GameObject {
    ObjectTags tag = ObjectTags.PLAYER;
    public Player(PApplet p,int x,int y) {
        super(p,x,y);
    }

    @Override
    public void createObject() {
        parent.fill(255, 255, 0);
        parent.noStroke();
        parent.ellipse(x, y, 25, 25);
    }

    @Override
    public void nameEntity() {
        System.out.println("Player");
    }

}
