package core.game;
import core.Scenes;
import core.OptionSelector;
import processing.core.PApplet;

public class SceneManager {
    PApplet parent;
    public SceneManager(PApplet p){ parent = p; }
    private Scenes activeScene = Scenes.MAINMENU;

    OptionSelector optionSelector;

    public int ActiveScene(){
        if(activeScene == Scenes.MAINMENU){
            return 1;
        }
        else if(activeScene == Scenes.LEVELEDITOR){
            return 2;
        }
        else if(activeScene == Scenes.GAMEOVER){
            return 3;
        }
        else if(activeScene == Scenes.LEVELSELECTOR){
            return 4;
        }
        else return 0;
    }

    public void linkScenes(){
        optionSelector = new OptionSelector(parent);

        if(ActiveScene() == 1) {
            if (optionSelector.SelectorManager() == 1 && parent.mousePressed) {
                activeScene = Scenes.LEVEL;
            }
            if (optionSelector.SelectorManager() == 2 && parent.mousePressed) {
                activeScene = Scenes.LEVELEDITOR;
            }
            if (optionSelector.SelectorManager() == 3 && parent.mousePressed) {
                activeScene = Scenes.LEVELSELECTOR;
            }
        }
        }
}


