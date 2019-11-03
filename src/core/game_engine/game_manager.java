package core.game_engine;
import processing.core.PApplet;

public class game_manager {
    public PApplet parent;
    private Grid grid;
    private LevelEditor levelEditor;

    public game_manager(PApplet p){
        this.parent = p;
        levelEditor = new LevelEditor(parent);
        grid = new Grid(parent);
    }

    public void startup(){

    }

    public void update(){

        grid.initializeGrid();
        grid.margins();
        levelEditor.snapObject(parent.mouseX,parent.mouseY);
        levelEditor.ClearLastObject();
    }

}
