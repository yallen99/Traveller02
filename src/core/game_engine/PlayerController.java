package core.game_engine;

import core.game_engine.objects.Player;
import processing.core.PApplet;
import processing.core.PVector;

public class PlayerController {
    PApplet parent;
    public Player player;


    public PlayerController(PApplet p) {
        parent = p;
    }

    public void addPlayer(Player player) {
        this.player = player;
    }

    public void checkInput() {
        if (player == null) return;

        if (parent.key == 'w' || parent.key == 'W') {
            player.moveUp();
            player.setDirection(0);
        } else if (parent.key == 's' || parent.key == 'S') {
            player.moveDown();
            player.setDirection(2);
        } else if (parent.key == 'a' || parent.key == 'A') {
            player.moveLeft();
            player.setDirection(3);
        } else if (parent.key == 'd' || parent.key == 'D') {
            player.moveRight();
            player.setDirection(1);
        }
    }
}
