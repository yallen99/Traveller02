package core.game_engine;
import processing.core.PApplet;


public class grid {
    PApplet parent;
    public grid(PApplet p){
        this.parent = p;
    }

    private int x1 = 0, y1 = 50,
                x2 = 800, y2 = 0;
    private int a1 = 50, b1 = 0,
                a2 = 0, b2 = 800;

    public void horizontal_grid(){
        parent.stroke(255);
       for(y1 = 0; y1 <= 800; y1+=50) {
           parent.stroke(100);
           parent.line(x1, y1, x2, y2);
            y2+=50;
        }
    }

    public void vertical_grid(){
        parent.stroke(255);
        for(a1 = 0; a1 <= 800; a1+=50) {
            parent.stroke(100);
            parent.line(a1, b1, a2, b2);
            a2+=50;
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
