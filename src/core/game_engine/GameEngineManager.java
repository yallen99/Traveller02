package core.game_engine;
import core.OptionSelector;
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
        if(grid != null) {

            grid.initializeGrid();
            grid.margins();
        }

        if(optionSelector != null) {
            optionSelector.CreatorUI();
        }
        levelEditor.snapObject(parent.mouseX,parent.mouseY);
        levelEditor.ClearLastObject();
        levelEditor.DisplaySaveLevel();
        if(levelEditor.IsSaving()){
            grid = null;
            optionSelector = null;
            levelEditor.SaveOnSlot();
        }
        else{return;}

    }
}
