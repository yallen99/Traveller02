package core.game_engine;
import core.game_engine.objects.Key;
import processing.core.PApplet;
import java.util.ArrayList;

public class OptionSelector {
    public PApplet parent;
    public OptionSelector(PApplet p){
        this.parent = p; }

        int activatedPlatformStroke = 100;
        int activatedPlayerStroke = 100;
        int activatedFinishStroke = 100;
        int activatedKeyStroke = 100;
        int activatedClearStroke = 100;

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
          else if(KeyCheck() == 52){
              selector = 4;
              //System.out.println("KEY");
          }
          else if(KeyCheck() == 53){
              selector = 5;
              //System.out.println("CLEAR");
          }
              return selector;
        }

        private int KeyCheck()
        {
            parent.keyTyped();
            return parent.keyCode;
        }

        public void CreatorUI(){
            PlatformButton();
            PlayerButton();
            FinishButton();
            KeyButton();
            ClearAllButton();

                if(SelectorManager() == 1){
                    activatedPlatformStroke = 0;
                    activatedPlayerStroke = 100;
                    activatedFinishStroke = 100;
                    activatedKeyStroke = 100;
                    activatedClearStroke = 100;

                }
                else if(SelectorManager() == 2){
                    activatedPlatformStroke = 100;
                    activatedPlayerStroke = 0;
                    activatedFinishStroke = 100;
                    activatedKeyStroke = 100;
                    activatedClearStroke = 100;
                }
                else if(SelectorManager() == 3){
                    activatedPlatformStroke = 100;
                    activatedPlayerStroke = 100;
                    activatedFinishStroke = 0;
                    activatedKeyStroke = 100;
                    activatedClearStroke = 100;
                }
                else if(SelectorManager() == 4){
                    activatedPlatformStroke = 100;
                    activatedPlayerStroke = 100;
                    activatedFinishStroke = 100;
                    activatedKeyStroke = 0;
                    activatedClearStroke = 100;
                }
                else if(SelectorManager() == 5){
                    activatedPlatformStroke = 100;
                    activatedPlayerStroke = 100;
                    activatedFinishStroke = 100;
                    activatedKeyStroke = 100;
                    activatedClearStroke = 0;
                }
        }

        private void PlatformButton(){
            parent.stroke(activatedPlatformStroke);
            parent.strokeWeight(5);
            parent.fill(255,0,0);
            parent.rectMode(parent.CENTER);
            parent.rect(100, 725, 75, 50);

            parent.fill(0);
            parent.textSize(12);
            parent.text("1.Platform", 70, 725);
        }
        private void PlayerButton(){
            parent.stroke(activatedPlayerStroke);
            parent.strokeWeight(5);
            parent.fill(255,255,0);
            parent.rectMode(parent.CENTER);
            parent.rect(250, 725, 75, 50);

            parent.fill(0);
            parent.textSize(12);
            parent.text("2.Player", 230, 725);
        }
        private void FinishButton(){
            parent.stroke(activatedFinishStroke);
            parent.strokeWeight(5);
            parent.fill(0,255,0);
            parent.rectMode(parent.CENTER);
            parent.rect(400, 725, 75, 50);

            parent.fill(0);
            parent.textSize(10);
            parent.text("3.Finish Point", 365, 725);
        }
        private void KeyButton(){
            parent.stroke(activatedKeyStroke);
            parent.strokeWeight(5);
            parent.fill(0,255,255);
            parent.rectMode(parent.CENTER);
            parent.rect(550, 725, 75, 50);

            parent.fill(0);
            parent.textSize(15);
            parent.text("4.Key", 530, 725);
        }
        private void ClearAllButton(){
            parent.stroke(activatedClearStroke);
            parent.strokeWeight(5);
            parent.fill(255);
            parent.rectMode(parent.CENTER);
            parent.rect(700, 725, 75, 50);

            parent.fill(0);
            parent.textSize(10);
            parent.text("5.Clear \n [Ctrl+z]", 665, 725);
        }
}
