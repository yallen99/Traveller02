package core.game_engine.input_commands;

public class Move_Down_Command implements Command{
    private Moveable entity;
    public Move_Down_Command(Moveable _entity){
        entity=_entity;
    }
    @Override
    public void execute() {
        entity.move_down();
    }
}