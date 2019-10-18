package core.game_engine;
import processing.core.PApplet;
import java.util.ArrayList;


public class OptionSelector {
    public PApplet parent;
    public OptionSelector(PApplet p){
        this.parent = p; }

        int activatedPlatformStroke = 100;
        int activatedPlayerStroke = 100;
        int activatedFinishStroke = 100;

        public int selector = 0;


        public int SelectorManager(){
          if(KeyCheck() == 49){
              selector = 1;
            //  System.out.println("PLATFORM");
          }
          else if (KeyCheck() == 50){
              selector = 2;
            //  System.out.println("PLAYER");
          }
          else if(KeyCheck() == 51){
              selector = 3;
              //  System.out.println("FINISH");
          }
              return selector;
        }

        private int KeyCheck()
        {
            parent.keyTyped();
            return parent.keyCode;
        }

        public void CreatorUI(){
            parent.stroke(activatedPlatformStroke);
            parent.strokeWeight(5);
            parent.fill(255,0,0);
            parent.rectMode(parent.CENTER);
            parent.rect(100, 725, 75, 50);

            parent.stroke(activatedPlayerStroke);
            parent.strokeWeight(5);
            parent.fill(255,255,0);
            parent.rectMode(parent.CENTER);
            parent.rect(250, 725, 75, 50);

            parent.stroke(activatedFinishStroke);
            parent.strokeWeight(5);
            parent.fill(0,255,0);
            parent.rectMode(parent.CENTER);
            parent.rect(400, 725, 75, 50);

                if(SelectorManager() == 1){
                    activatedPlatformStroke = 0;
                    activatedPlayerStroke = 100;
                    activatedFinishStroke = 100;

                }
                else if(SelectorManager() == 2){
                    activatedPlatformStroke = 100;
                    activatedPlayerStroke = 0;
                    activatedFinishStroke = 100;
                }

                else if(SelectorManager() == 3){
                    activatedPlatformStroke = 100;
                    activatedPlayerStroke = 100;
                    activatedFinishStroke = 0;
                }
        }
}
