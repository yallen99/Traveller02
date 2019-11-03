package core.game;
import core.OptionSelector;
import core.game_engine.GameEngineManager;
import core.game_engine.PlayerController;
import processing.core.PApplet;
import core.game_engine.input_commands.Player_Input;
public class test_game {
    GameEngineManager GameEngineManager;
    PlayerController PlayerController;
    Player_Input player_input;
    OptionSelector optionSelector;
    SceneManager sceneManager;
    GameManager gameManager;

    PApplet parent;
    public test_game(PApplet p){ parent = p; }

    private void initialize_classes(){
        GameEngineManager = new GameEngineManager(parent);
        PlayerController = new PlayerController(parent,300,400);
        player_input = new Player_Input(PlayerController);
        optionSelector = new OptionSelector(parent);
        sceneManager = new SceneManager(parent);
        gameManager = new GameManager(parent);
    }

    public void startGame(){
        initialize_classes();
        switch(sceneManager.ActiveScene()){
            case 1:
                gameManager.start();
                break;
            case 2:
                GameEngineManager.startup();
                break;
        }
    }

    public void updateGame() {
        optionSelector.CreatorUI();
        sceneManager.linkScenes();

        if(sceneManager.ActiveScene() == 1){
                gameManager.update();
        }

        if(sceneManager.ActiveScene() == 2) {

              // player_input.check_input();
              GameEngineManager.update();
          }
        }


    public void KeyPressed(char key, int keyCode){
        player_input.key_handler(key, keyCode, true);
    }

    public void KeyReleased(char key, int keyCode){
        player_input.key_handler(key, keyCode, false);
    }

}
