package core;
import core.game.SceneManager;
import processing.core.PApplet;

public class OptionSelector {
    public PApplet parent;
    public OptionSelector(PApplet p){
        this.parent = p;
        sceneManager = new SceneManager(parent); }

    //main menu button strokes
    int activatedPlayStroke = 0;
    int activatedEditStroke = 0;
    int activatedLevelsStroke = 0;
    int activatedClearDataStroke = 0;

        //level editor button strokes
        int activatedPlatformStroke = 50;
        int activatedPlayerStroke = 50;
        int activatedFinishStroke = 50;
        int activatedKeyStroke = 50;
        int activatedClearStroke = 50;

        SceneManager sceneManager;
        public int selector = 0;

        public int SelectorManager(){
          if(KeyCheck() == 49){
              selector = 1;
          }
          else if (KeyCheck() == 50){
              selector = 2;
          }
          else if(KeyCheck() == 51){
              selector = 3;
          }
          else if(KeyCheck() == 52){
              selector = 4;
          }
          else if(KeyCheck() == 53){
              selector = 5;
          }
          else if(KeyCheck() == 38) {
              //Play
              selector = 10;
          }
          else if(KeyCheck() == 39) {
              //Level Selector
              selector = 11;
          }
          else if(KeyCheck() == 37) {
              //Editor
              selector = 12;
          }
          else if(KeyCheck() == 40) {
             //Quit
              selector = 13;
          }
             //BACKSPACE = BACK -- key 8
          else if(KeyCheck() == 8){
              return selector = 100;
          }
              return selector;
        }
        public int KeyCheck() {
            parent.keyTyped();
            return parent.keyCode;
        }
        public void CreatorUI() {
            CheckForSelectedButtons();
            sceneManager.linkScenes();
          //  System.out.println("Buttons created           " + sceneManager.ActiveScene());
            if (sceneManager.ActiveScene() == "Main Menu") {
                PlayButton();
                EditButton();
                LevelSelectorButton();
                //ClearDataButton();
            }

            if (sceneManager.ActiveScene() == "Editor") {
                PlatformButton();
                PlayerButton();
                FinishButton();
                KeyButton();
                ClearAllButton();
            }
        }

        private void CheckForSelectedButtons() {
           if(sceneManager.ActiveScene() == "Main Menu") {
                    if (SelectorManager() == 10) {
                   activatedPlayStroke = 255;
                   activatedEditStroke = 0;
                   activatedLevelsStroke = 0;
                   activatedClearDataStroke = 0;
               }
               else if (SelectorManager() == 12) {
                   activatedPlayStroke = 0;
                   activatedEditStroke = 0;
                   activatedLevelsStroke = 255;
                   activatedClearDataStroke = 0;
               }
               else if (SelectorManager() == 11) {
                   activatedPlayStroke = 0;
                   activatedEditStroke = 255;
                   activatedLevelsStroke = 0;
                   activatedClearDataStroke = 0;
               }
               else if (SelectorManager() == 13) {
                   activatedPlayStroke = 0;
                   activatedEditStroke = 0;
                   activatedLevelsStroke = 0;
                   activatedClearDataStroke = 255;
               }
           }

           if(sceneManager.ActiveScene() == "Editor"){
                         if (SelectorManager() == 1) {
                        activatedPlatformStroke = 0;
                        activatedPlayerStroke = 50;
                        activatedFinishStroke = 50;
                        activatedKeyStroke = 50;
                        activatedClearStroke = 50;

                    }
                    else if (SelectorManager() == 2) {
                        activatedPlatformStroke = 50;
                        activatedPlayerStroke = 0;
                        activatedFinishStroke = 50;
                        activatedKeyStroke = 50;
                        activatedClearStroke = 50;
                    }
                    else if (SelectorManager() == 3) {
                        activatedPlatformStroke = 50;
                        activatedPlayerStroke = 50;
                        activatedFinishStroke = 0;
                        activatedKeyStroke = 50;
                        activatedClearStroke = 50;
                    }
                    else if (SelectorManager() == 4) {
                        activatedPlatformStroke = 50;
                        activatedPlayerStroke = 50;
                        activatedFinishStroke = 50;
                        activatedKeyStroke = 0;
                        activatedClearStroke = 50;
                    }
                    else if (SelectorManager() == 5) {
                        activatedPlatformStroke = 50;
                        activatedPlayerStroke = 50;
                        activatedFinishStroke = 50;
                        activatedKeyStroke = 50;
                        activatedClearStroke = 0;
                    }
            }
        }

        //menu buttons
        private void PlayButton(){
            parent.stroke(activatedPlayStroke);
            parent.strokeWeight(5);
             parent.fill(242,182,160);
             parent.rectMode(parent.CORNER);
             parent.rect(350,430,150,100);
             parent.textSize(40);
             parent.fill(0);
             parent.text("^",410,480);
             parent.text("Play",390,515);
        }
        private void EditButton(){
            parent.stroke(activatedEditStroke);
            parent.strokeWeight(5);
            parent.fill(242,182,160);
            parent.rectMode(parent.CORNER);
            parent.rect(520,550,150,100);
            parent.fill(0);
            parent.text(">",540,605);
            parent.textSize(30);
            parent.text("Levels",570,605);

        }
        private void LevelSelectorButton(){
            parent.stroke(activatedLevelsStroke);
            parent.strokeWeight(5);
            parent.fill(242,182,160);
            parent.rectMode(parent.CORNER);
            parent.rect(180,550,150,100);
            parent.textSize(40);
            parent.fill(0);
            parent.text("<",200,605);
            parent.textSize(40);
            parent.text("Edit",240,605);
        }

        //editor buttons
        private void PlatformButton(){
            parent.stroke(activatedPlatformStroke);
            parent.strokeWeight(5);
            parent.fill(200,193,217);
            parent.rectMode(parent.CENTER);
            parent.rect(100, 725, 75, 50);

            parent.fill(0);
            parent.textSize(12);
            parent.text("1.Platform", 70, 725);
        }
        private void PlayerButton(){
            parent.stroke(activatedPlayerStroke);
            parent.strokeWeight(5);
            parent.fill(216,232,242);
            parent.rectMode(parent.CENTER);
            parent.rect(250, 725, 75, 50);

            parent.fill(0);
            parent.textSize(12);
            parent.text("2.Player", 230, 725);
        }
        private void FinishButton(){
            parent.stroke(activatedFinishStroke);
            parent.strokeWeight(5);
            parent.fill(242,233,189);
            parent.rectMode(parent.CENTER);
            parent.rect(400, 725, 75, 50);

            parent.fill(0);
            parent.textSize(10);
            parent.text("3.Finish Point", 365, 725);
        }
        private void KeyButton(){
            parent.stroke(activatedKeyStroke);
            parent.strokeWeight(5);
            parent.fill(217,191,160);
            parent.rectMode(parent.CENTER);
            parent.rect(550, 725, 75, 50);

            parent.fill(0);
            parent.textSize(15);
            parent.text("4.Key", 530, 725);
        }
        private void ClearAllButton(){
            parent.stroke(activatedClearStroke);
            parent.strokeWeight(5);
            parent.fill(242,182,160);
            parent.rectMode(parent.CENTER);
            parent.rect(700, 725, 75, 50);

            parent.fill(0);
            parent.textSize(10);
            parent.text("5.Clear \n [Ctrl+z]", 675, 725);
        }

        //selector buttons
        public void CreateSelectorUI(){
            parent.fill(242, 233, 189);
            parent.noStroke();
            parent.rectMode(parent.CORNER);
            parent.rect(150, 100, 200, 150);

            parent.textSize(40);
            parent.fill(0);
            parent.text("Level 1", 165, 140);
            parent.textSize(30);
            parent.text("click 1 \nto play", 165, 180);
        }

        //editor messages
         public void PlayerMessageHidden(){
        parent.fill(80);
        parent.textSize(15);
        parent.text("Already a player in the scene!", 300, 25);
    }
         public void PLayerMessageDisplayed(){
        parent.fill(255,0,0);
        parent.textSize(15);
        parent.text("Already a player in the scene!", 300, 20);
    }
         public void FinishMessageHidden(){
        parent.fill(80);
        parent.textSize(15);
        parent.text("Already a finish point in the scene!", 300, 25);
    }
         public void FinishMessageDisplayed(){
        parent.fill(255,0,0);
        parent.textSize(15);
        parent.text("Already a finish point in the scene!", 300, 20);
    }

        //title
        public void Title(){
            parent.fill(255,200,101);
            parent.noStroke();
            parent.textSize(90);
            parent.text("THE MAZE", 200, 200);
        }
}
