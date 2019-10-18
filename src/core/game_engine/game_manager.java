package core.game_engine;
import processing.core.PApplet;

public class game_manager {
    public PApplet parent;
    private Grid grid;
    private LevelEditor levelEditor;
    //private game_object game_object;

    public game_manager(PApplet p){
        this.parent = p;
        levelEditor = new LevelEditor(parent);
        grid = new Grid(parent);
      //  game_object = new game_object(parent);
    }

    public void startup(){
        grid.initializeGrid();


    }
    public void update(){
        //game_object.snapObject(parent.mouseX, parent.mouseY);
        grid.margins();
        levelEditor.snapObject(parent.mouseX,parent.mouseY);
    }

}
