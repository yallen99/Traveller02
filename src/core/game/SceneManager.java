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

    public void linkScenes() {
        optionSelector = new OptionSelector(parent);

        if (ActiveScene() == "Main Menu") {
            if (parent.mousePressed && optionSelector.SelectorManager() == 10)  {
                // UP ARROW
                scene = "Level";
            } else if (parent.mousePressed && optionSelector.SelectorManager() == 12) {
              //LEFT ARROW
               scene = "Editor";
            } else if (parent.mousePressed && optionSelector.SelectorManager() == 11) {
               //RIGHT ARROW
                scene = "Level Selector";
            }
            } else if (parent.mousePressed && optionSelector.SelectorManager() == 13) {
                 //DOWN ARROW
                  System.out.println("APPLICATION  QUIT");
            }
        }
    }




