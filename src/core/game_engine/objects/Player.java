package core.game_engine.objects;

import core.game_engine.GameObject;
import core.game_engine.LevelEditor;
import core.game_engine.Movable;
import processing.core.PApplet;
import processing.data.JSONObject;

public class Player extends GameObject implements Movable {
    ObjectTags tag = ObjectTags.PLAYER;
    private int direction;
    LevelEditor levelEditor;
    public Player(PApplet p,int x,int y) {
        super(p,x,y);
        updatePosition();
        levelEditor = new LevelEditor(parent);
    }



    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void nameEntity() {
        System.out.println("Player");
    }
    @Override
    public void updatePosition() {
        getPoints();
        parent.fill(255, 200, 101);
        parent.noStroke();
        parent.ellipse(x, y, 25, 25);

    }
    @Override
    public ObjectTags GetTag() {
        return tag;
    }
    @Override
    public void loadJSONObject(JSONObject json) {

    }
    @Override
    public JSONObject serializeToJSON(){
        JSONObject gameObjectData = super.serializeToJSON();
        gameObjectData.setString("tag", tag.toString());
        return gameObjectData;
    }
    @Override
    public void moveUp() {
        y-=50;
    }
    @Override
    public void moveDown() {
        y+=50;
    }
    @Override
    public void moveRight() {
        x+=50;
    }
    @Override
    public void moveLeft() {
        x-=50;
    }


    public void Collision(GameObject otherObject){
//        if(((this.getBottomRight().GetX() >= otherObject.getTopLeft().GetX() &&
//           this.getBottomRight().GetX() <= otherObject.getTopRight().GetX()) &&
//           (this.getBottomRight().GetY() >= otherObject.getTopLeft().GetY() &&
//           this.getBottomRight().GetY() <= otherObject.getBottomLeft().GetY()))
//                ||
//          ((this.getBottomLeft().GetX() <= otherObject.getTopRight().GetX() &&
//           this.getBottomLeft().GetX() >= otherObject.getTopLeft().GetX()) &&
//          (this.getBottomLeft().GetY() >= otherObject.getTopRight().GetY() &&
//           this.getBottomLeft().GetY() <= otherObject.getBottomRight().GetY()))){
//
//                         //found a simpler method :)
//        }

        if(this.getPoint().GetX() == otherObject.getPoint().GetX() &&
           this.getPoint().GetY() == otherObject.getPoint().GetY()) {
            System.out.println("Collided with " + ObjectTags.PLATFORM);
            if(otherObject.GetTag() == ObjectTags.PLATFORM){
                if(direction == 0){
                    y+=50;
                }
                if(direction == 1){
                    x-=50;
                }
                if(direction == 2){
                    y-=50;
                }
                if(direction == 3){
                    x+=50;
                }
            }
            else if(otherObject.GetTag() == ObjectTags.COLLECTABLE){
               // otherObject.coverMe();
               // levelEditor.removeObject(otherObject);
                System.out.println("COLLECTABLE + 1");
            }
        }
    }

}
