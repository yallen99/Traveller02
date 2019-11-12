package core.game_engine.objects;

import core.game_engine.GameObject;
import core.game_engine.LevelEditor;
import core.game_engine.Movable;
import core.game_engine.Point;
import org.jetbrains.annotations.NotNull;
import processing.core.PApplet;
import processing.data.JSONObject;

public class Player extends GameObject implements Movable {
    ObjectTags tag = ObjectTags.PLAYER;
    LevelEditor levelEditor;
    Point topLeft, topRight, bottomLeft, bottomRight, leftTop, leftBottom, rightTop, rightBottom, point;
    private boolean topFree;
    private boolean bottomFree;
    private boolean leftFree;
    private boolean rightFree;

    private boolean isTopFree() {
        return topFree;
    }

    private boolean isBottomFree() {
        return bottomFree;
    }

    private boolean isLeftFree() {
        return leftFree;
    }

    private boolean isRightFree() {
        return rightFree;
    }

    public void GetWalls(){
        isLeftFree();
        isRightFree();
        isBottomFree();
        isTopFree();
}

    public Player(PApplet p,int x,int y) {
        super(p,x,y);
        updatePosition();
        levelEditor = new LevelEditor(parent);
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
        if(topFree) {
            y -= 50;
        }
        else if(!topFree){
         //   System.out.println("WAY BLOCKED");
        }
    }
    @Override
    public void moveDown() {
        if(bottomFree){
        y+=50 ;
        }
        else if(!bottomFree){
         //   System.out.println("WAY BLOCKED");
        }

    }
    @Override
    public void moveRight() {
        if(rightFree){
        x+=50;
        }
        else if(!rightFree){
         //   System.out.println("WAY BLOCKED");
        }
    }
    @Override
    public void moveLeft() {
        if(leftFree){
        x-=50 ;
        }
        else if(!leftFree){
         //   System.out.println("WAY BLOCKED");
        }
    }

    @Override
    public void getPoints(){
        point = new Point(x,y);
        topLeft = new Point(x-20, y-30);
        topRight = new Point(x+20, y-30);
        bottomLeft = new Point(x-25, y+30);
        bottomRight = new Point(x+25, y+30);
        leftTop = new Point(x-30, y-20);
        leftBottom = new Point(x-30, y +20);
        rightTop = new Point(x+30,  y-20);
        rightBottom = new Point(x+30, y+20);

    }

    public void CheckWallCollision(GameObject otherObject){
       if(otherObject.GetTag() == ObjectTags.PLATFORM) {
           CollisionUp(otherObject);
           CollisionDown(otherObject);
           CollisionLeft(otherObject);
           CollisionRight(otherObject);
       }
    }

    public boolean CheckSpecialTileCollision(GameObject otherObject){
        if(otherObject.getPoint().getY() == point.getY() &&
            otherObject.getPoint().getX() == point.getX()){
            return true;
        }
        return false;
    }
    public boolean CheckFinishCollision(GameObject otherObject){
        if(otherObject.getPoint().getY() == point.getY() &&
                otherObject.getPoint().getX() == point.getX()){
            System.out.println("YAAAAAAAAAAAAAAAAAAAAAAAAAAAAY");
            return true;
        }
        return false;
    }

    // for platforms
    private void CollisionUp(@NotNull GameObject otherObject){
//        if(((this.getBottomRight().GetX() >= otherObject.getTopLeft().GetX() &&
//           this.getBottomRight().GetX() <= otherObject.getTopRight().GetX()) &&
//           (this.getBottomRight().GetY() >= otherObject.getTopLeft().GetY() &&
//           this.getBottomRight().GetY() <= otherObject.getBottomLeft().GetY()))
//                ||
//          ((this.getBottomLeft().GetX() <= otherObject.getTopRight().GetX() &&
//           this.getBottomLeft().GetX() >= otherObject.getTopLeft().GetX()) &&
//          (this.getBottomLeft().GetY() >= otherObject.getTopRight().GetY() &&
//           this.getBottomLeft().GetY() <= otherObject.getBottomRight().GetY()))){
//            System.out.println("collided");
//        }
            if(topLeft.getY() <= otherObject.getBottomLeft().getY() &&
            topRight.getY() <= otherObject.getBottomRight().getY() &&
            point.getY() - otherObject.getPoint().getY() == 50 &&
            point.getX() == otherObject.getPoint().getX()){
                // System.out.println(otherObject.getPoint().getX() + "     " + otherObject.getPoint().getY());
                // System.out.println("SOMETHING ABOVE !!!");
                topFree = false;
            }
            else if(!topFree && topLeft.getY() >= otherObject.getBottomLeft().getY() &&
                    topRight.getY() >= otherObject.getBottomRight().getY() &&
                    point.getY() - otherObject.getPoint().getY() != 50 &&
                    point.getX() == otherObject.getPoint().getX()){
                topFree = true;
            }
    }
    private void CollisionDown(@NotNull GameObject otherObject){
        if(bottomLeft.getY() >= otherObject.getTopLeft().getY() &&
            bottomRight.getY() >= otherObject.getTopRight().getY() &&
                otherObject.getPoint().getY() - point.getY() == 50 &&
                point.getX() == otherObject.getPoint().getX()){
            bottomFree = false;
        }
        else if(!bottomFree && bottomLeft.getY() < otherObject.getTopLeft().getY() &&
                bottomRight.getY() < otherObject.getTopRight().getY() &&
                otherObject.getPoint().getY() - point.getY() != 50 &&
                point.getX() == otherObject.getPoint().getX()){
            bottomFree = true;
        }
    }
    private void CollisionLeft(@NotNull GameObject otherObject){

        if(leftTop.getX() <= otherObject.getTopRight().getX() &&
        leftBottom.getX() <= otherObject.getBottomRight().getX() &&
        point.getX() - otherObject.getPoint().getX() == 50 &&
        point.getY() == otherObject.getPoint().getY()){
          //  System.out.println("SOMETHING ON LEFT");
        leftFree = false;
        }
        else if(!leftFree && leftTop.getX() >= otherObject.getTopRight().getX() &&
                leftBottom.getX() >= otherObject.getBottomRight().getX() &&
                point.getX() - otherObject.getPoint().getX() != 50 &&
                point.getY() == otherObject.getPoint().getY()){
            leftFree = true;
        }
    }
    private void CollisionRight(@NotNull GameObject otherObject){

        if(rightTop.getX() >= otherObject.getTopLeft().getX() &&
        rightBottom.getX() >= otherObject.getBottomLeft().getX() &&
        otherObject.getPoint().getX() - point.getX() == 50 &&
        point.getY() == otherObject.getPoint().getY()){
          //  System.out.println("SOMETHING ON RIGHT");
       rightFree = false;
        }
        else if(!rightFree && rightTop.getX() <= otherObject.getTopLeft().getX() &&
                rightBottom.getX() <= otherObject.getBottomLeft().getX() &&
                otherObject.getPoint().getX() - point.getX() != 50 &&
                point.getY() == otherObject.getPoint().getY()){
            rightFree = true;
        }
    }


}
