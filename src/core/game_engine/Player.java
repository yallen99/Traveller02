package core.game_engine;

import processing.core.PApplet;

public class Player extends GameObject {
    public Player(PApplet p) {
        super(p);
    }

    @Override
    void createObject(int x, int y) {
        parent.fill(255, 255, 0);
        parent.noStroke();
        parent.ellipse(x, y, 25, 25);
    }

    @Override
    void nameEntity() {
        System.out.println("Player");
    }

}
