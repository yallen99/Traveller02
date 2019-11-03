package core.game_engine;
import core.Scenes;
import processing.core.PApplet;

public class GameEngineManager {
    public PApplet parent;
    private Grid grid;
    private LevelEditor levelEditor;
    Scenes scene = Scenes.LEVELEDITOR;

    public GameEngineManager(PApplet p){
        this.parent = p;
        levelEditor = new LevelEditor(parent);
        grid = new Grid(parent);
    }

    public void startup(){
        grid.EditorBackground();
    }

    public void update(){
        grid.initializeGrid();
        grid.margins();
        levelEditor.snapObject(parent.mouseX,parent.mouseY);
        levelEditor.ClearLastObject();
    }
}
