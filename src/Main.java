import processing.core.PApplet;
import core.game.TestGame;
public class Main extends PApplet
{
    TestGame testGame;

    public void settings(){size(801, 801);}

    public void setup(){
        background(0);
        frameRate(30);
        testGame = new TestGame(this);
        testGame.startGame();
    }
    public void draw(){
        testGame.updateGame();
    }

    public void keyPressed(){
        testGame.KeyPressed();
    }


    public static void main(String args[]){
        PApplet.main("Main" );
    }
}


//done
// add a back in editor
// add box colliders
// add player functionality
// add the collectable function
// find a way to save different levels
// add a display for different levels
