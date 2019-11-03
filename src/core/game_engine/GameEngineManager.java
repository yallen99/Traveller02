package core.game_engine;
import core.Scenes;
import processing.core.PApplet;

public class GameEngineManager {
    public PApplet parent;
    private Grid grid;
    private LevelEditor levelEditor;
    OptionSelector optionSelector;

    public GameEngineManager(PApplet p){
        this.parent = p;
    }

    public void startup(){
        levelEditor = new LevelEditor(parent);
        optionSelector = new OptionSelector(parent);
        grid = new Grid(parent);
        grid.EditorBackground();
    }

    public void update(){
        grid.initializeGrid();
        grid.margins();
        optionSelector.CreatorUI();
        levelEditor.snapObject(parent.mouseX,parent.mouseY);
        levelEditor.ClearLastObject();
    }
}
