package core.game_engine.objects;

import core.game_engine.GameObject;
import processing.core.PApplet;

public class Platform extends GameObject {

    public Platform(PApplet p,int x,int y) {
        super(p,x,y);
    }

    @Override
    public void createObject() {
        parent.fill(255, 0, 0);
        parent.rectMode(parent.CENTER);
        parent.noStroke();
        parent.rect(x, y, 50, 50);
        nameEntity();
    }

    @Override
    public void nameEntity() {
        System.out.println("Sunt platforma haha");
    }


}
