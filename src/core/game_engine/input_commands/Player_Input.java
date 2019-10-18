package core.game_engine.input_commands;

import processing.core.PApplet;

public class Player_Input {
    public Input_Handler input_handler;
    Move_Right_Command move_right_command;
    Move_Left_Command move_left_command;
    Move_Up_Command move_up_command;
    Move_Down_Command move_down_command;
    boolean right, left, up, down;

    public Player_Input(Moveable entity) {
        move_right_command = new Move_Right_Command(entity);
        move_left_command = new Move_Left_Command(entity);
        move_up_command = new Move_Up_Command(entity);
        move_down_command = new Move_Down_Command(entity);
        input_handler = new Input_Handler(move_left_command, move_right_command, move_up_command, move_down_command);
    }

    public void key_handler(char key, int keyCode, boolean active) {
        if (key == 'a' || keyCode == PApplet.LEFT) {
            left = active;
        } else if (key == 'd' || keyCode == PApplet.RIGHT) {
            right = active;
        } else if (key == 'w' || keyCode == PApplet.UP) {
            up = active;
        } else if (key == 's' || keyCode == PApplet.DOWN) {
            down = active;
        } else if (!active && keyCode != 0) {
            left = false;
            right = false;
            up = false;
            down = false;
        }
    }

    public void check_input() {
        if (left) {
            input_handler.move_left();
        } else if (right) {
            input_handler.move_right();
        } else if (up) {
            input_handler.move_up();
        } else if (down) {
            input_handler.move_down();
        }
    }


}


