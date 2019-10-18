package core.game_engine;
import processing.core.PApplet;
import core.game_engine.grid;

public class game_manager {
    public PApplet parent;
    private grid grid;
    private game_object game_object;

    public game_manager(PApplet p){
        this.parent = p;
        grid = new grid(parent);
        game_object = new game_object(parent);
    }

    public void startup(){
        grid.horizontal_grid();
        grid.vertical_grid();
        game_object.Initialize();

    }
    public void update(){
        game_object.SnapPlatform(parent.mouseX, parent.mouseY);
        grid.margins();
    }

}
