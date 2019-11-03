package core.game;

import core.game_engine.OptionSelector;
import processing.core.PApplet;

public class GameManager {
    PApplet parent;
    public GameManager(PApplet p){ parent = p; }

    OptionSelector optionSelector;

    public void start(){
        optionSelector = new OptionSelector(parent);
        parent.background(0);
    }

    public void update(){
            optionSelector.CreatorUI();
        }
    }
