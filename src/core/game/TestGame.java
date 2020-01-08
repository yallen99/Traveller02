package core.game;
import core.OptionSelector;
import core.game_engine.GameEngineManager;
import core.game_engine.data_management.DataManager;
import processing.core.PApplet;

public class TestGame {
    GameEngineManager gameEngineManager;
    OptionSelector optionSelector;
    SceneManager sceneManager;
    GameManager gameManager;
    DataManager dataManager;

    //desperation calls: sorting visuals thru bools
    private boolean editorStarted = false;
    private boolean editorBackground = false;

    PApplet parent;

    public TestGame(PApplet p) {
        parent = p;
    }

    private void initialize_classes() {
        gameEngineManager = new GameEngineManager(parent);
        optionSelector = new OptionSelector(parent);
        sceneManager = new SceneManager(parent);
        gameManager = new GameManager(parent);
        dataManager = new DataManager(parent);

    }

    public void startGame() {
        initialize_classes();
        dataManager.loadLevelFile();
        if (sceneManager.ActiveScene() == "Main Menu") {
            gameManager.start();
        }
    }

    public void updateGame() {
        sceneManager.linkScenes();
        if (sceneManager.ActiveScene() == "Main Menu") {
            editorBackground = false;
            editorStarted = false;
            gameManager.updateMenu();
        } else if (sceneManager.ActiveScene() == "Level 1") {
            gameManager.updateLevel1();
            if(gameManager.IsLevelFnished()){
                optionSelector.CongratsScreen();

            }
        } else if (sceneManager.ActiveScene() == "Level 2") {
            gameManager.updateLevel2();
            if(gameManager.IsLevelFnished()){
                optionSelector.CongratsScreen();
            }
        } else if (sceneManager.ActiveScene() == "Level 3") {
            gameManager.updateLevel3();
            if(gameManager.IsLevelFnished()){
                optionSelector.CongratsScreen();
            }
        } else if (sceneManager.ActiveScene() == "Editor") {
            if (!editorBackground) {
                parent.fill(0);
                parent.rectMode(parent.CORNER);
                parent.rect(0, 0, 900, 900);
                editorBackground = true;
            }
            if (!editorStarted) {
                gameEngineManager.startup();
                editorStarted = true;
            }
            gameEngineManager.update();
        } else if (sceneManager.ActiveScene() == "Level Selector") {
            gameManager.updateSelector();
        }
    }

    public void KeyPressed() {
        gameManager.checkInput();
    }
}
