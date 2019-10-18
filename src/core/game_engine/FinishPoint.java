package core.game_engine;

import processing.core.PApplet;

public class FinishPoint extends Platform {

    public FinishPoint(PApplet p) {
        super(p);
    }
    @Override
    void createObject(int x,int y){
       super.createObject(x,y);
       parent.fill(0,255,255);
    }
}
