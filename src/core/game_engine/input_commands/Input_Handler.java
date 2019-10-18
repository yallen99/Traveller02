package core.game_engine.input_commands;

public class Input_Handler {
    private Command leftCommand, rightCommand, upCommand, downCommand;
    public Input_Handler(Command leftCommand, Command rightCommand, Command upCommand, Command downCommand) {
        this.leftCommand = leftCommand;
        this.rightCommand = rightCommand;
        this.upCommand = upCommand;
        this.downCommand = downCommand;
    }

    public void move_right(){
        rightCommand.execute();
    }
    public void move_left(){
        leftCommand.execute();
    }
    public void move_up(){
        upCommand.execute();
    }
    public void move_down(){
        downCommand.execute();
    }


}
