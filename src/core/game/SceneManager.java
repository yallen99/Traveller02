package core.game;
import core.Scenes;
import core.game_engine.OptionSelector;
import processing.core.PApplet;

public class SceneManager {
    PApplet parent;
    public SceneManager(PApplet p) {
        parent = p;
    }

    private String scene = "Main Menu";


    OptionSelector optionSelector;

    public String ActiveScene(){
        return scene;
    }

//    public String ActiveScene() {
//        if (scene == "Main Menu") {
//            return scene;
//        } else if (scene == "Editor") {
//            return 2;
//        } else if (scene == "Game Over") {
//            return 3;
//        } else if (scene == "Level Selector") {
//            return 4;
//        } else if (scene == "Play"){
//            return 5;
//        }
//            return 0;
//    }



    public void linkScenes() {
        optionSelector = new OptionSelector(parent);

        if (ActiveScene() == "Main Menu") {
            if (KeyCheck() == 10 && optionSelector.SelectorManager() == 1)  {
                scene = "Level";
            } else if (KeyCheck() == 69 && optionSelector.SelectorManager() == 2) {
               scene = "Editor";
            } else if (KeyCheck() == 10 && optionSelector.SelectorManager() == 3) {
                scene = "Level Selector";
            }
        }
    }

    private int KeyCheck()
    {
        parent.keyTyped();

        return parent.keyCode;
    }
}



