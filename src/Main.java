import processing.core.PApplet;
import core.game.test_game;
public class Main extends PApplet
{
    test_game test_game;

    public void settings(){size(801, 801);}

    public void setup(){
        background(0);
        frameRate(30);
        test_game = new test_game(this);
        test_game.startGame();
    }
    public void draw(){
        test_game.updateGame();
    }

    public void keyPressed(){
        test_game.KeyPressed(key, keyCode);
    }
    public void keyReleased(){
        test_game.KeyReleased(key,keyCode);
    }

    public static void main(String args[]){
        PApplet.main("Main" );
    }
}
