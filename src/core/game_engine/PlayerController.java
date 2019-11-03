package core.game_engine;

import core.game_engine.input_commands.Moveable;
import processing.core.PApplet;
import processing.core.PVector;

public class PlayerController implements Moveable {
    PApplet parent;
    int x = 300, y = 300;
    public PVector position;

    public PlayerController(PApplet p, int x, int y) {
        parent = p;
        this.position = new PVector(x, y, 0);
    }

    public void create_player() {
        parent.fill(255, 255, 0);
        parent.noStroke();
        parent.ellipse(position.x, position.y, 25, 25);
    }

    @Override
    public void move_right() {
        position.x += 50;
    }

    @Override
    public void move_left() {
        this.position.x -= 50;
    }

    @Override
    public void move_up() {
        this.position.y -= 50;
    }

    @Override
    public void move_down() {
        this.position.y += 50;
    }
}
