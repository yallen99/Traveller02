package core.game_engine;

import processing.core.PApplet;

public class Platform extends GameObject{

    public Platform(PApplet p) {
        super(p);
    }

    @Override
    void createObject(int x, int y) {
        parent.fill(255, 0, 0);
        parent.rectMode(parent.CENTER);
        parent.noStroke();
        parent.rect(x, y, 50, 50);
    }

    @Override
    void nameEntity() {
        System.out.println("Sunt platforma haha");
    }


}
