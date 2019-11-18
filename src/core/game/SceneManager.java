package core.game;
import core.OptionSelector;
import processing.core.PApplet;

public class SceneManager {
    PApplet parent;
    public SceneManager(PApplet p) {
        parent = p;
    }

    private String scene = "Main Menu";
    OptionSelector optionSelector;
    GameManager gameManager;

    public String ActiveScene(){
        return scene;
    }

    public void linkScenes() {
        gameManager = new GameManager(parent);


        if (ActiveScene() == "Main Menu") {
            optionSelector = new OptionSelector(parent);
            if (optionSelector.SelectorManager() == 10)  {
                // UP ARROW
                scene = "Level 1";
                optionSelector = null;
            } else if (optionSelector.SelectorManager() == 12) {
              //LEFT ARROW
               scene = "Editor";
               optionSelector = null;

            } else if (optionSelector.SelectorManager() == 11) {
               //RIGHT ARROW
                scene = "Level Selector";
                optionSelector = null;
            }
        }

        else if(ActiveScene() == "Editor"){
            optionSelector = new OptionSelector(parent);
            if(optionSelector.SelectorManager() == 100){
                scene = "Main Menu";
                optionSelector = null;
            }
        }

        else if(ActiveScene() == "Level Selector"){
            optionSelector = new OptionSelector(parent);

            if (optionSelector.SelectorManager() == 1) {
                scene = "Level 1";
                System.out.println(scene);
                optionSelector = null;
            } else if (optionSelector.SelectorManager() == 2) {
                scene = "Level 2";
                optionSelector = null;
            } else if (optionSelector.SelectorManager() == 3) {
                scene = "Level 3";
                optionSelector = null;
            } else if (optionSelector.SelectorManager() == 100) {
                System.out.println("BACKED");
                scene = "Main Menu";
                optionSelector = null;
            }
        }

        else if(ActiveScene() == "Level 1" || ActiveScene() == "Level 2" || ActiveScene() == "Level 3"){
            optionSelector = new OptionSelector(parent);
            if (optionSelector.SelectorManager() == 100) {
                System.out.println("BACKED");
                scene = "Main Menu";
                optionSelector = null;
            }
        }

//        else if(ActiveScene() == "Clear Data"){
//        }
    }
}




