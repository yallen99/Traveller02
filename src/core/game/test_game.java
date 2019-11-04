package core.game;
import core.game_engine.OptionSelector;
import core.game_engine.GameEngineManager;
import core.game_engine.PlayerController;
import processing.core.PApplet;
import core.game_engine.input_commands.Player_Input;
public class test_game {
    GameEngineManager gameEngineManager;
    PlayerController PlayerController;
    Player_Input player_input;
    OptionSelector optionSelector;
    SceneManager sceneManager;
    GameManager gameManager;

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
    }

    public void startGame(){
        initialize_classes();
       // System.out.println("Currently on scene     " + sceneManager.ActiveScene());
       if(sceneManager.ActiveScene() == "Main Menu") {
           gameManager.start();
       }
    }

    public void updateGame() {
        sceneManager.linkScenes();
        if(sceneManager.ActiveScene() == "Main Menu" && menuDisplayed){
                gameManager.update();
        }

        else if(sceneManager.ActiveScene() == "Editor") {
            menuDisplayed = false;
            if(!editorStarted) {
                gameEngineManager.startup();
              //  System.out.println("EDITOR STARTUP");
                editorStarted = true;
            }
                gameEngineManager.update();
          }
        }


    public void KeyPressed(char key, int keyCode){
        player_input.key_handler(key, keyCode, true);
    }

    public void KeyReleased(char key, int keyCode){
        player_input.key_handler(key, keyCode, false);
    }

}
