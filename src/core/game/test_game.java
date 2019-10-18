package core.game;
import core.game_engine.OptionSelector;
import core.game_engine.game_manager;
import core.game_engine.OptionSelector;
import core.game_engine.player_controller;
import processing.core.PApplet;
import core.game_engine.input_commands.Player_Input;
public class test_game {
    game_manager game_manager;
    player_controller player_controller;
    Player_Input player_input;
    OptionSelector optionSelector;

    PApplet parent;
    public test_game(PApplet p){ parent = p; }

    private void initialize_classes(){
        game_manager = new game_manager(parent);
        player_controller = new player_controller(parent,300,400);
        player_input = new Player_Input(player_controller);
        optionSelector = new OptionSelector(parent);
    }

    public void start_game(){
        initialize_classes();
        game_manager.startup();

    }

    public void update_game(){
       // parent.background(0);
        player_input.check_input();
        game_manager.update();
        optionSelector.CreatorUI();
       // player_controller.create_player();

    }

    public void KeyPressed(char key, int keyCode){
        player_input.key_handler(key, keyCode, true);
    }

    public void KeyReleased(char key, int keyCode){
        player_input.key_handler(key, keyCode, false);
    }

}
