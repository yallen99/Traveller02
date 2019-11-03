package core.game_engine.objects;

import core.game_engine.GameObject;
import processing.core.PApplet;

public class Platform extends GameObject {
    ObjectTags tag = ObjectTags.PLATFORM;
    public Platform(PApplet p,int x,int y) {
        super(p,x,y);
    }

    @Override
    public void createObject() {
        parent.fill(163, 116, 34);
        parent.rectMode(parent.CENTER);
        parent.noStroke();
        parent.rect(x, y, 50, 50);
    }

    @Override
    public void nameEntity() {
        System.out.println("Sunt platforma haha");
    }

}
