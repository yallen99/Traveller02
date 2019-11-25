package core.game_engine.objects;

import core.game_engine.GameObject;
import core.game_engine.LevelEditor;
import core.game_engine.Movable;
import core.game_engine.Point;
import org.jetbrains.annotations.NotNull;
import processing.core.PApplet;
import processing.data.JSONObject;

import java.util.ArrayList;

public class Player extends GameObject implements Movable {
    ObjectTags tag = ObjectTags.PLAYER;
    LevelEditor levelEditor;
    Point topLeft, topRight, bottomLeft, bottomRight, leftTop, leftBottom, rightTop, rightBottom, point;
    private boolean topFree = true;
    private boolean bottomFree = true;
    private boolean leftFree= true;
    private boolean rightFree = true;
    Platform platform;
    ArrayList<Platform> newPlatforms = new ArrayList();

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
            platform = new Platform(parent, this.getX(), this.getY()+50);
            newPlatforms.add(platform);
        }
    }
    @Override
    public void moveDown() {
        if(bottomFree){
        y+=50 ;
            platform = new Platform(parent, this.getX(), this.getY()-50);
            newPlatforms.add(platform);
        }

    }
    @Override
    public void moveRight() {
        if(rightFree){
        x+=50;
            platform = new Platform(parent, this.getX()-50, this.getY());
            newPlatforms.add(platform);
        }


    }
    @Override
    public void moveLeft() {
        if(leftFree){
        x-=50 ;
            platform = new Platform(parent, this.getX()+50, this.getY());
            newPlatforms.add(platform);
        }

    }

    public boolean Blocked(){
        if(!topFree && !bottomFree && !leftFree && !rightFree){
            return true;
        }
         return false;
    }

    public void CheckNewPlatformsCollision(){
     for(Platform platform: newPlatforms){
         CollisionDown(platform);
         CollisionUp(platform);
         CollisionRight(platform);
         CollisionLeft(platform);
        // System.out.println(topFree +"    "+ bottomFree +"     "+leftFree+"     "+rightFree);
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


    public boolean CheckSpecialTileCollision(GameObject otherObject){
        if(otherObject.getPoint().getY() == point.getY() &&
            otherObject.getPoint().getX() == point.getX()){
            return true;
        }
        return false;
    }

public void startOfLoop(){
    topFree = true; leftFree = true; rightFree = true; bottomFree = true;
}
    // for platforms
    public void CollisionUp(@NotNull GameObject otherObject) {
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
//           if(this.getPoint() == otherObject.getPoint()){
//
//           }

        //add here the 2d array loop
//        for(int yPos = getY()-50; yPos <= getY() + 50; yPos +=50){
//            for(int xPos = getX() -50; xPos <= getX() + 50; yPos +=50){


        /////////////////////////////////////////////////////////////////////////////////////////////////////
if(!topFree) return;
                if(topLeft.getY() <= otherObject.getBottomLeft().getY() &&
                        topRight.getY() <= otherObject.getBottomRight().getY() &&
                        point.getY() - otherObject.getPoint().getY() == 50 &&
                        point.getX() == otherObject.getPoint().getX()){
                    topFree = false;
                }
                else {
//                    if(!topFree && topLeft.getY() >= otherObject.getBottomLeft().getY() &&
//                        topRight.getY() >= otherObject.getBottomRight().getY() &&
//                        point.getY() - otherObject.getPoint().getY() != 50 &&
//                        point.getX() == otherObject.getPoint().getX()){
                    topFree = true;
                }

            }
//        topFree = true;
//        for (int yPos = otherObject.getY(); yPos<=this.getY()+50 && yPos>=this.getY() - 50; yPos+=50) {
//            if (this.point.getY() - 50 == otherObject.getPoint().getY()
//                    && point.getY() - otherObject.getPoint().getY() == 50 &&
//                    point.getX() == otherObject.getPoint().getX()) {
//                topFree = false;
//
//            }
//            else{
//
//                topFree = true;
//
//            }
//        }
    public void CollisionDown(@NotNull GameObject otherObject){
        if(!bottomFree) return;
                if (bottomLeft.getY() >= otherObject.getTopLeft().getY() &&
                        bottomRight.getY() >= otherObject.getTopRight().getY() &&
                        otherObject.getPoint().getY() - point.getY() == 50 &&
                        point.getX() == otherObject.getPoint().getX()) {
                    bottomFree = false;

                } else {
//                    if (!bottomFree && bottomLeft.getY() < otherObject.getTopLeft().getY() &&
//                        bottomRight.getY() < otherObject.getTopRight().getY() &&
//                        otherObject.getPoint().getY() - point.getY() != 50 &&
//                        point.getX() == otherObject.getPoint().getX()) {
                    bottomFree = true;
                }



    }
    public void CollisionLeft(@NotNull GameObject otherObject) {

        if(!leftFree) return;
        if (leftTop.getX() <= otherObject.getTopRight().getX() &&
                leftBottom.getX() <= otherObject.getBottomRight().getX() &&
                point.getX() - otherObject.getPoint().getX() == 50 &&
                point.getY() == otherObject.getPoint().getY()) {
            //  System.out.println("SOMETHING ON LEFT");
            leftFree = false;
        } else {
//                    if (!leftFree && leftTop.getX() >= otherObject.getTopRight().getX() &&
//                        leftBottom.getX() >= otherObject.getBottomRight().getX() &&
//                        point.getX() - otherObject.getPoint().getX() != 50 &&
//                        point.getY() == otherObject.getPoint().getY()) {
            leftFree = true;
        }

    }
    public void CollisionRight(@NotNull GameObject otherObject) {
        if(!rightFree) return;
        if (rightTop.getX() >= otherObject.getTopLeft().getX() &&
                rightBottom.getX() >= otherObject.getBottomLeft().getX() &&
                otherObject.getPoint().getX() - point.getX() == 50 &&
                point.getY() == otherObject.getPoint().getY()) {
            //  System.out.println("SOMETHING ON RIGHT");
            rightFree = false;
        } else {
//                    if (!rightFree && rightTop.getX() <= otherObject.getTopLeft().getX() &&
//                        rightBottom.getX() <= otherObject.getBottomLeft().getX() &&
//                        otherObject.getPoint().getX() - point.getX() != 50 &&
//                        point.getY() == otherObject.getPoint().getY()) {
            rightFree = true;
        }

    }



}
