package core.game;
import core.game_engine.OptionSelector;
import core.game_engine.GameEngineManager;
import core.game_engine.PlayerController;
import core.game_engine.data_management.DataManager;
import processing.core.PApplet;
import core.game_engine.input_commands.Player_Input;
public class test_game {
    GameEngineManager gameEngineManager;
    PlayerController PlayerController;
    Player_Input player_input;
    OptionSelector optionSelector;
    SceneManager sceneManager;
    GameManager gameManager;
    DataManager dataManager;

    private boolean editorStarted = false;
    private boolean menuDisplayed = true;

    PApplet parent;
    public test_game(PApplet p){ parent = p; }

    private void initialize_classes(){
        gameEngineManager = new GameEngineManager(parent);
        PlayerController = new PlayerController(parent,300,400);
        player_input = new Player_Input(PlayerController);
        optionSelector = new OptionSelector(parent);
        sceneManager = new SceneManager(parent);
        gameManager = new GameManager(parent);
        dataManager = new DataManager(parent);
    }

    public void startGame(){
        initialize_classes();
        dataManager.loadLevelFile();

       if(sceneManager.ActiveScene() == "Main Menu") {
           gameManager.start();
       }
    }

    public void updateGame() {
        sceneManager.linkScenes();
   //     System.out.println("Currently on scene     " + sceneManager.ActiveScene());

        if(sceneManager.ActiveScene() == "Main Menu" && menuDisplayed){
                gameManager.updateMenu();
        }

        else if(sceneManager.ActiveScene() == "Level"){


            gameManager.updateLevel();
        }

        else if(sceneManager.ActiveScene() == "Editor") {
            menuDisplayed = false;
            if(!editorStarted) {
                gameEngineManager.startup();
                editorStarted = true;
            }
                gameEngineManager.update();
          }
        else if(sceneManager.ActiveScene() == "Level"){

        }
        }


    public void KeyPressed(char key, int keyCode){
        player_input.key_handler(key, keyCode, true);
    }

    public void KeyReleased(char key, int keyCode){
        player_input.key_handler(key, keyCode, false);
    }

}
