package core.game_engine;
import processing.core.PApplet;


public class Grid {
    PApplet parent;
    public Grid(PApplet p){
        this.parent = p;
    }

    public void initializeGrid(){
        parent.stroke(100);

        for(int startY=25;startY<=775;startY +=50) {
            parent.line(25, startY, 775, startY);
        }

        for(int startX=25;startX<=775;startX +=50) {
            parent.line(startX, 25, startX, 775);
        }
    }


    public void margins(){
        parent.stroke(100);
        parent.strokeWeight(50);
        parent.line(0,0,800,0);
        parent.line(0,0,0,800);
        parent.line(800,0,800,800);
        parent.strokeWeight(250);
        parent.line(0,800,800,800);
    }
}
