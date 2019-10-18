package core.game_engine;
import processing.core.PApplet;
import java.util.ArrayList;

public class game_object {
    public PApplet parent;

    OptionSelector optionSelector;
    object_keeper object_keeper;
    private boolean player = false;
    private boolean finish = false;


    public game_object(PApplet p){
        this.parent = p; }

        public void Initialize(){
            optionSelector = new OptionSelector(parent);
            object_keeper = new object_keeper(parent);
        }

    public void SnapPlatform(float x, float y){

        System.out.println(object_keeper.objects.size());

        int X = parent.round(x/50)*50;
        int Y = parent.round(y/50)*50;
             if(X>25 && X<775 &&
                     Y>25 && Y<725) {

                 //create platform
                 if (parent.mousePressed && optionSelector.SelectorManager() == 1) {
                     parent.fill(255, 0, 0);
                     parent.rectMode(parent.CENTER);
                     parent.noStroke();
                     parent.rect(X, Y, 50, 50);
                     object_keeper.AddObjectToList();
                    // System.out.println(platforms.size());
                 }
             }
                //create player
                if(parent.mousePressed && optionSelector.SelectorManager() == 2 && !player){
                    parent.fill(255, 255, 0);
                    parent.noStroke();
                    parent.ellipse(X, Y, 25, 25);
                    object_keeper.AddObjectToList();
                    player = true;
                }
                else if(optionSelector.SelectorManager() == 2 && player){
                    System.out.println("THERE IS ALREADY A PLAYER IN THE SCENE!");
                }

                //create finish Point
                if(parent.mousePressed && optionSelector.SelectorManager() == 3 && !finish){
                    parent.fill(0,255,0);
                    parent.noStroke();
                    parent.rect(X, Y, 50,50);
                    object_keeper.AddObjectToList();
                    finish = true;
                }
                else if(parent.mousePressed && optionSelector.SelectorManager() == 3 && finish){
                    System.out.println("THERE IS ALREADY A FINISH POINT IN THE SCENE!");
                }
    }

}
